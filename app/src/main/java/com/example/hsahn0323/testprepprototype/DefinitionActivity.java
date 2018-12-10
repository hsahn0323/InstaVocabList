package com.example.hsahn0323.testprepprototype;

import android.support.v7.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;

import com.google.gson.*;

import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONException;

public class DefinitionActivity extends AppCompatActivity {

    private static final String TAG = "WordListMaker";
    //private static String jsonString;
    private JSONObject jsonObject;
    private JSONArray definitionArray;
    //private TextView definition;

    private ArrayList<String> definitionArrayList = new ArrayList<>();
    private ArrayAdapter<String> adapterD;
    private ListView definitionListView;

    private static RequestQueue requestQueue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_definition);

        requestQueue = Volley.newRequestQueue(this);

        TextView wordText = findViewById(R.id.wordView);
        //definition = findViewById(R.id.definitionView);
        //wordText.setText(/*User selected word*/);

        String wordInput = /*wordText.getText().toString()*/"word";

        definitionListView = findViewById(R.id.definitionView);
        startAPICall(wordInput);



        adapterD = new ArrayAdapter<>(DefinitionActivity.this,
                R.layout.definition_list,
                R.id.sample_definition_list_view,
                definitionArrayList);
        definitionListView.setAdapter(adapterD);

        //addDefinitions(jsonObject);
    }


    public void startAPICall(String word) {
        String wordId = word.toLowerCase();
        try {
            JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(
                    Request.Method.GET,
                    "https://od-api.oxforddictionaries.com:443/api/v1/entries/en/" + wordId + "/definitions",
                    null,
                    new Response.Listener<JSONObject>() {
                        @Override
                        public void onResponse(JSONObject response) {
                            Log.d(TAG, response.toString());
                            addDefinitions(response);
                            //jsonObject = response;
                        }
                    }, new Response.ErrorListener() {
                        @Override
                        public void onErrorResponse(final VolleyError error) {
                            Log.w(TAG, error.toString());
                        }
                    }) {
                        @Override
                        public Map<String, String> getHeaders() {
                            Map<String, String> params = new HashMap<>();
                            params.put("Accept", "application/json");
                            params.put("app_id", "793b2caa");
                            params.put("app_key", "30a7ff2e3775ed1d5df88d01f8a9842c");
                            Log.d(TAG, params.toString());
                            return params;
                        }
                    };
            requestQueue.add(jsonObjectRequest);
        } catch (Exception e) {
            System.err.println("API Request Failed >:(");
            e.printStackTrace();
        }
    }

    public void addDefinitions(JSONObject thisObject) {
        try {
            //Gson gson = new Gson();
            //String jsonString = gson.toJson(thisObject);
            //definitionArrayList = gson.fromJson(jsonString, );
            //JSONArray definitionArray = json;
            //JsonParser parser = new JsonParser();
            Log.d(TAG, thisObject.toString());
            /*JsonArray definitionArray = parser.parse(jsonString)
                    .getAsJsonObject().getAsJsonArray("results")
                    .getAsJsonObject().getAsJsonArray("lexicalEntries")
                    .getAsJsonObject().getAsJsonArray("entries")
                    .getAsJsonObject().getAsJsonArray("senses")
                    .getAsJsonObject().getAsJsonArray("definitions");
            for (int i = 0; i < definitionArray.size(); i++) {
                definitionArrayList.add(definitionArray.get(i).toString());
            }*/

            definitionArray = thisObject.getJSONArray("results")
                    .getJSONObject(0)
                    .getJSONArray("lexicalEntries")
                    .getJSONObject(0)
                    .getJSONArray("entries")
                    .getJSONObject(0)
                    .getJSONArray("senses");
            for (int i = 0; i < definitionArray.length(); i++) {

                String sampleDefinitionString = definitionArray.getJSONObject(i).getJSONArray("definitions").getString(0);

                definitionArrayList.add(sampleDefinitionString);
                Log.d("data", sampleDefinitionString);
            }

        } catch (JSONException e) {
            Log.w(TAG, e);
        }



    }
}

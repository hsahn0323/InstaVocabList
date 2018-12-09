package com.example.hsahn0323.testprepprototype;

import android.support.v7.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import javax.net.ssl.HttpsURLConnection;
import java.util.Map;
import java.util.HashMap;
import android.os.AsyncTask;

import com.google.gson.*;

import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONObject;

public class DefinitionActivity extends AppCompatActivity {

    private static final String TAG = "WordListMaker";
    private static String jsonString;
    private JSONObject jsonObject;
    private TextView definition;

    private static RequestQueue requestQueue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_definition);

        requestQueue = Volley.newRequestQueue(this);

        TextView wordText = findViewById(R.id.wordView);
        definition = findViewById(R.id.definitionView);
        //wordText.setText(/*User selected word*/);

        String wordInput = /*wordText.getText().toString()*/"word";

        //new APIRequester().execute(dictionaryEntries(wordInput));
        //parseJsonInfoIntoDefinition(jsonString);

        startAPICall(wordInput);
    }
/*
    private String dictionaryEntries(String wordInput) {
        final String language = "en";
        final String word_id = wordInput.toLowerCase(); //word id is case sensitive and lowercase is required
        return "https://od-api.oxforddictionaries.com:443/api/v1/entries/" + language + "/" + word_id;
    }

    public static class APIRequester extends AsyncTask<String, Integer, String> {
        @Override
        protected String doInBackground(String... params) {

            //TODO: replace with your own app id and app key
            final String app_id = "793b2caa";
            final String app_key = "30a7ff2e3775ed1d5df88d01f8a9842c";
            try {
                URL url = new URL(params[0]);
                HttpsURLConnection urlConnection = (HttpsURLConnection) url.openConnection();
                urlConnection.setRequestProperty("Accept","application/json");
                urlConnection.setRequestProperty("app_id",app_id);
                urlConnection.setRequestProperty("app_key",app_key);

                // read the output from the server
                BufferedReader reader = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
                StringBuilder stringBuilder = new StringBuilder();

                String line;
                while ((line = reader.readLine()) != null) {
                    stringBuilder.append(line).append("\n");
                }

                return stringBuilder.toString();

            }
            catch (Exception e) {
                e.printStackTrace();
                return e.toString();
            }
        }

        @Override
        protected void onPostExecute(String result) {
            super.onPostExecute(result);
            //parseJsonInfo(result);
            jsonString = result;
        }
    }

    public void parseJsonInfoIntoDefinition(String result) {
        JsonParser parser = new JsonParser();
        JsonObject dictionaryInfo = parser.parse(result).getAsJsonObject();
        // .... you have the definition: String def
        String foundDefinition = dictionaryInfo.getAsJsonObject("results")
                .getAsJsonObject("lexicalEntries").getAsJsonObject("entries")
                .getAsJsonObject("senses").getAsJsonObject("definitions").getAsString();
        definition.setText(foundDefinition);
    }*/

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
                            jsonObject = response;
                            Log.d(TAG, response.toString());
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
}

package com.example.hsahn0323.testprepprototype;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.content.Intent;

import java.util.ArrayList;

public class ListActivity extends AppCompatActivity {

    private ArrayList<WordListElement> wordArrayList = new ArrayList<>();
    private ArrayAdapter<WordListElement> adapter;
    private ListView list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        //populateListView();

        adapter = new ArrayAdapter<>(ListActivity.this,
                R.layout.word_list,
                R.id.sample_word_view,
                wordArrayList);
        list = findViewById(R.id.word_list_view);
        list.setAdapter(adapter);

        wordArrayList.add(new WordListElement(getIntent().getStringExtra("Word"), "a block of letters"/* find way to get definition*/));
    }

    public void toDefinition(View view) {
        Intent intent = new Intent(this, DefinitionActivity.class);
        startActivity(intent);
    }

    /*private void populateListView() {

        //ArrayAdapter<WordListElement> adapter = new MyListAdapter();
        ListView list = findViewById(R.id.word_list);
        list.setAdapter(adapter);
    }*/

    /*private class MyListAdapter extends ArrayAdapter<WordListElement> {
        public MyListAdapter() {}
        super(ListActivity.this, R.layout.)
    }*/
}

package com.example.hsahn0323.testprepprototype;

import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.content.Intent;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ArrayList<String> arrayList = new ArrayList<>();
    WordListAdapter adapter;
    private EditText txtInput;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activtity_main);

        ListView list = (ListView) findViewById(R.id.theList);
        //final ArrayList<Words> wordList = new ArrayList<>();
        //Words test = new Words("word", "definition");
        //wordList.add(test);
        Log.d("TEST---------------", "TEST----------------------------\n");
        adapter = new WordListAdapter(MainActivity.this, R.layout.adapter_layout, arrayList);
        list.setAdapter(adapter);
        txtInput = (EditText) findViewById(R.id.editText);
        Button btAdd = (Button) findViewById(R.id.insertWord);
        Log.d("", "----------------------------\n");
        btAdd.setOnClickListener(new View.OnClickListener() {
            //@Override
            public void onClick(View v) {
                String newItem = txtInput.getText().toString();
                Log.d("addItem test","---------------------------------------\n"+newItem);

                adapter.add(newItem);
                adapter.notifyDataSetChanged();
            }
        });
    }
    /*public void addItems(View v) {
        arrayList.add("Clicked : "+clickCounter++);
        adapter.notifyDataSetChanged();
    }*/
}

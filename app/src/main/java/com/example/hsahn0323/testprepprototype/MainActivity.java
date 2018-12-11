package com.example.hsahn0323.testprepprototype;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.content.Intent;
import android.widget.EditText;
import android.widget.*;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ArrayList<String> arrayList = new ArrayList<String>();
    WordListAdapter adapter;
    private EditText txtInput;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activtity_main);
        ListView list = (ListView) findViewById(R.id.theList);
        adapter = new WordListAdapter(MainActivity.this, R.layout.adapter_layout, arrayList);
        list.setAdapter(adapter);
         txtInput = (EditText) findViewById(R.id.editText);
        Button addButton = findViewById(R.id.insertWord);

        addButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                String newWord = txtInput.getText().toString();
                adapter.add(newWord);
                adapter.notifyDataSetChanged();
            }
        });
    }

    public void toList(View view) {
        Intent intent = new Intent(this, ListActivity.class);
        startActivity(intent);
    }
}

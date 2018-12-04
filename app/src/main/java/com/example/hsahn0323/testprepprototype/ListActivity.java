package com.example.hsahn0323.testprepprototype;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class ListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
    }

    public void toDefinition(View view) {
        Intent intent = new Intent(this, DefinitionActivity.class);
        startActivity(intent);
    }
}

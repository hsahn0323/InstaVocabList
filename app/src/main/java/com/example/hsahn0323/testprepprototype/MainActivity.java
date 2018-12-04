package com.example.hsahn0323.testprepprototype;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.content.Intent;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void toList(View view) {
        Intent intent = new Intent(this, ListActivity.class);
        startActivity(intent);
    }
}

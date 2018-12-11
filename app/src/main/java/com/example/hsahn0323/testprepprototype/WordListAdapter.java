package com.example.hsahn0323.testprepprototype;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class WordListAdapter extends ArrayAdapter<String> {

    ArrayList<String> arrayList = new ArrayList<>();
    private EditText txtInput;
    private Context mContext;
    private int mResource;
    WordListAdapter(Context context, int resource, List<String> objects) {
        super(context, resource, objects);
        mContext = context;
        mResource = resource;
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, @NonNull ViewGroup parent) {

        String word = getItem(position);
        String definition = getItem(position);
        LayoutInflater inflater = LayoutInflater.from(mContext);
        convertView = inflater.inflate(mResource, parent, false);

        TextView tvWord = (TextView) convertView.findViewById(R.id.word1);
        TextView tvDefinition = (TextView) convertView.findViewById(R.id.theDefinition);
        tvWord.setText(word);
        return convertView;
    }
}

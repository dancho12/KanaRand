package com.example.danch.kanarand;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class MainActivity extends AppCompatActivity {

    int pr_t=0;
    int value = 0;//счетчик колличества нажатий
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    public void onClick(View view) {
        Intent myIntent = new Intent(view.getContext(), NumberPage.class);
        startActivityForResult(myIntent, 0);
    }

    public void onClick2(View view) {
        Intent myIntent = new Intent(view.getContext(), Kana.class);
        startActivityForResult(myIntent, 0);
    }

    public void clean_RES(View v)
    {
        pr_t=0;
        value = 0;
        int b = v.getId();
        TextView se = (TextView)findViewById(b);
        se.setText(null);
    }


}

package com.example.danch.kanarand;

import android.content.Intent;
import android.graphics.Color;
import android.os.Handler;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
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

public class Numbers extends MainActivity {

    int pr_t=0;
    int value = 0;//счетчик колличества нажатий
    int selectedTest;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.numbers);

        ActionBar actionBar =getSupportActionBar();
        actionBar.setHomeButtonEnabled(true);
        actionBar.setDisplayHomeAsUpEnabled(true);
    }
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                this.finish();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    public void onClick(View view) {
        Intent intent = new Intent();
        setResult(RESULT_OK, intent);
        finish();
    }

    public void onClickRadioNumbers (View v)
    {
        selectedTest = v.getId();
        Log.d("onClickRadioGroupSelectTest", "selectedTest="+selectedTest);
    }

    public void onClickN(View view) {
        Intent myIntent = new Intent(view.getContext(), NumberPage.class);
        startActivityForResult(myIntent, 0);
    }

    public void onClickT(View view) {
        Intent myIntent = new Intent(view.getContext(), Time.class);
        startActivityForResult(myIntent, 0);
    }
    public void onClickC(View view) {
        Intent myIntent = new Intent(view.getContext(), Calendar.class);
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
    String numres="";
    String numres2 ="";
    int indx;
    public void check_answer()
    {
        value++;
        final EditText editText = (EditText)findViewById(R.id.editText_answer);
        String number = editText.getText().toString();
        boolean isContain = number.contains(":");
        boolean isContain2 = number.contains("/");
        int a=0;
        if(isContain == (false)&&isContain2 == (false))
        {
            a = Integer.parseInt(number);
        }

        Log.d("check_answer1", "number="+number);
        Log.d("check_answer1", "numres2="+numres2);
        TextView selection = (TextView) findViewById(R.id.textView3);
        if (a == indx||number.equals(numres2)) {

            selection.setTextSize(150);
            selection.setTextColor(Color.parseColor("#03DAC6"));
            selection.setText("✓");
            pr_t++;
        } else {
            selection.setTextSize(150);
            selection.setTextColor(Color.parseColor("#B00020"));
            selection.setText("×");
        }

        int proc = ((pr_t*100)/value);
        TextView tur = (TextView) findViewById(R.id.textViewRESTime);
        tur.setText(getString(R.string.Types)+Integer.toString(value)+"\n"+getString(R.string.TrueRES)+Integer.toString(pr_t)+"\n"+Integer.toString(proc)+"%");
        editText.setText(null);
    }


}

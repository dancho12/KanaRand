package com.example.danch.kanarand;

import android.content.Intent;
import android.graphics.Color;
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

public class Kana extends MainActivity {

    String Res = "";
    String Res2 = "";
    String Res3 = "";

    String[] rows = {"A", "KA", "SA", "TA", "NA", "HA","MA","YA","RA","WA","WO"};
    TextView selection;
    String item;
    private int selectedTest;
    RadioGroup radio;
    private int selectedTest2;
    RadioGroup radio2;
    int ch=0;
    TextView bt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.kana);

        ActionBar actionBar =getSupportActionBar();
        actionBar.setHomeButtonEnabled(true);
        actionBar.setDisplayHomeAsUpEnabled(true);

        RadioGroup radio = (RadioGroup)findViewById(R.id.radioGroup1);
        selectedTest = radio.getCheckedRadioButtonId();

        RadioGroup radio2 = (RadioGroup)findViewById(R.id.radioGroup2);
        selectedTest2 = radio2.getCheckedRadioButtonId();

        Spinner spinner = (Spinner) findViewById(R.id.kana_select);
        // Создаем адаптер ArrayAdapter с помощью массива строк и стандартной разметки элемета spinner
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, rows);
        // Определяем разметку для использования при выборе элемента
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // Применяем адаптер к элементу spinner
        spinner.setAdapter(adapter);

        AdapterView.OnItemSelectedListener itemSelectedListener = new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                // Получаем выбранный объект
                item = (String)parent.getItemAtPosition(position);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        };
        spinner.setOnItemSelectedListener(itemSelectedListener);

        full_rand2();
        View btr = findViewById(R.id.tbr);
        btr.setVisibility(View.INVISIBLE);
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
    public void onClick6(View view) {
        Intent intent = new Intent();
        setResult(RESULT_OK, intent);
        finish();
    }

    public void show(View v)
    {
        selection = (TextView) findViewById(R.id.textView2);
        switch (ch) {

            case  0:
                switch (selectedTest2) {
                    case R.id.radioButton3: {
                        selection.setText(Res3);
                        ch = 1;
                        Log.d("Переключатель", "ch=" + ch);
                        break;
                    }
                    case R.id.radioButton4: {
                        selection.setText(Res2);
                        ch = 1;
                        Log.d("Переключатель", "ch=" + ch);
                        break;
                    }
                }
                break;
            case 1:
                //selection.setText(OutPutRand());
                selection.setText(Res);
                ch = 0;
                Log.d("Переключатель", "ch=" + ch);
                break;
        }
    }

    private void readFile(InputStream fstream, int r) {
        Switch simpleSwitch = (Switch) findViewById(R.id.switch2);
        Boolean switchState = simpleSwitch.isChecked();

        try{
            int a=0,b=0;
            //InputStream fstream = getResources().openRawResource(R.raw.test);
            BufferedReader br = new BufferedReader(new InputStreamReader(fstream));
            String strLine;
            while ((strLine = br.readLine()) != null) {
                System.out.println(strLine);
                if (r == 1) {
                    a++;
                    if (a < 6) {

                        Imput(strLine);
                    }
                }
                if (r == 6) {
                    a++;
                    if (a > 5 && a < 11) {

                        Imput(strLine);

                    }
                }
                if (r == 2) {
                    a++;
                    if (a < 67) {

                        Imput(strLine);

                    }
                }
                if (r == 3) {
                    a++;
                    if (a > 66 && a < 127) {

                        Imput(strLine);

                    }
                }
                if (r == 8) {
                    a++;
                    if (switchState == (true)) {
                        if (a < 11) {

                            Imput(strLine);
                        }
                    }
                    else
                    {
                        if (a < 6) {

                            Imput(strLine);
                        }
                    }
                }
                if (r == 10) {
                    a++;
                    if (switchState == (true)) {
                        if (a < 16) {

                            Imput(strLine);
                        }
                    }
                    else
                    {
                        if (a < 6) {

                            Imput(strLine);
                        }
                    }
                }
                if (r == 9) {
                    a++;
                    if (switchState == (true)) {
                        if (a > 10 && a < 21) {

                            Imput(strLine);

                        }
                    }
                    else
                    {
                        if (a > 10 && a < 16) {

                            Imput(strLine);

                        }
                    }
                }
                if (r == 11) {
                    a++;
                    if (switchState == (true)) {
                        if (a > 15 && a < 31) {

                            Imput(strLine);

                        }
                    }
                    else
                    {
                        if (a > 15 && a < 21) {

                            Imput(strLine);

                        }
                    }
                }
                b++;
                if (switchState == (true)) {
                    if (b > 30 && (r == 10 || r == 11)) {

                        Imput2(strLine);
                    }
                    if (b > 45 && (r == 10 || r == 11)) {

                        Imput3(strLine);
                    }
                    if (b > 20 && (r == 9 || r == 8)) {

                        Imput2(strLine);
                    }
                    if (b > 30 && (r == 9 || r == 8)) {

                        Imput3(strLine);
                    }
                }
                else
                {
                    if (b > 30 && b<36 &&((r == 10 || r == 11))) {

                        Imput2(strLine);
                    }
                    if (b > 45 &&b<51 &&(r == 10 || r == 11)) {

                        Imput3(strLine);
                    }

                    if (b > 20 && b<26 &&((r == 9 || r == 8))) {

                        Imput2(strLine);
                    }
                    if (b > 30 &&b<36 &&(r == 9 || r == 8)) {

                        Imput3(strLine);
                    }
                }

                if (b > 10&&(r==6||r==1)) {

                    Imput2(strLine);
                }
                if (b > 15&&(r==6||r==1)) {

                    Imput3(strLine);
                }
                if (b > 127&&(r==2||r==3)) {

                    Imput2(strLine);
                }
                if (b > 188&&(r==2||r==3)) {

                    Imput3(strLine);
                }
            }
            fstream.close();
        }catch (IOException e){
            System.out.println("Ошибка");
        }
    }

    public void onClickRadioSelectTest (View v)
    {
        selectedTest = v.getId();
        Log.d("onClickRadioGroupSelectTest", "selectedTest="+selectedTest);
    }

    public void onClickRadioSelectTest2 (View v)
    {
        selectedTest2 = v.getId();
        Log.d("onClickRadioGroupSelectTest", "selectedTest="+selectedTest2);
    }
    public void full_rand(View v)
    {
        full_rand2();
    }

    void full_rand2()
    {
        View btr = findViewById(R.id.tbr);
        btr.setVisibility(View.INVISIBLE);
        Clean();
        int r = 0;
        Switch simpleSwitch = (Switch) findViewById(R.id.switch1);
        Boolean switchState = simpleSwitch.isChecked();
        switch (selectedTest) {
            case R.id.radioButton1: {
                r = 2;
                InputStream fstream1 = getResources().openRawResource(R.raw.full);
                readFile(fstream1, r);
                break;
            }
            case R.id.radioButton2: {

                r = 3;
                InputStream fstream1 = getResources().openRawResource(R.raw.full);
                readFile(fstream1, r);
                break;
            }
        }

        selection = (TextView) findViewById(R.id.textView2);
        selection.setTextSize(150);
        selection.setTextColor(Color.BLACK);
        Rand();
        if (switchState == (true)) {
            switch (selectedTest2) {
                case R.id.radioButton3: {
                    selection.setText(Res3);
                    ch = 1;
                    Log.d("Переключатель", "ch=" + ch);
                    break;
                }
                case R.id.radioButton4: {
                    selection.setText(Res2);
                    ch = 1;
                    Log.d("Переключатель", "ch=" + ch);
                    break;
                }
            }
        } else {
            //selection.setText(OutPutRand());
            selection.setText(Res);
            ch=0;
        }
    }

    public void fu(View v) {
        Clean();
        int r = 0;
        Switch simpleSwitch = (Switch) findViewById(R.id.switch1);
        Boolean switchState = simpleSwitch.isChecked();

        View btr = findViewById(R.id.tbr);
        btr.setVisibility(View.VISIBLE);

        switch (selectedTest) {
            case R.id.radioButton1: {
                switch (item) {

                    case "A":
                        r = 1;
                        InputStream fstream1 = getResources().openRawResource(R.raw.a);
                        readFile(fstream1, r);
                        break;
                    case "KA":
                        r = 8;
                        InputStream fstream2 = getResources().openRawResource(R.raw.ka);
                        readFile(fstream2, r);
                        break;

                    case "SA":
                        r = 8;
                        InputStream fstream3 = getResources().openRawResource(R.raw.sa);
                        readFile(fstream3, r);
                        break;
                    case "TA":
                        r = 8;
                        InputStream fstream5 = getResources().openRawResource(R.raw.ta);
                        readFile(fstream5, r);
                        break;
                    case "NA":
                        r = 1;
                        InputStream fstream6 = getResources().openRawResource(R.raw.na);
                        readFile(fstream6, r);
                        break;
                    case "HA":
                        r = 10;
                        InputStream fstream7 = getResources().openRawResource(R.raw.ha);
                        readFile(fstream7, r);
                        break;
                    case "MA":
                        r = 1;
                        InputStream fstream8 = getResources().openRawResource(R.raw.ma);
                        readFile(fstream8, r);
                        break;
                    case "YA":
                        r = 1;
                        InputStream fstream9 = getResources().openRawResource(R.raw.ya);
                        readFile(fstream9, r);
                        break;
                    case "RA":
                        r = 1;
                        InputStream fstream10 = getResources().openRawResource(R.raw.ra);
                        readFile(fstream10, r);
                        break;
                    case "WA":
                        r = 1;
                        InputStream fstream11 = getResources().openRawResource(R.raw.wa);
                        readFile(fstream11, r);
                        break;
                    case "WO":
                        r = 1;
                        InputStream fstream12 = getResources().openRawResource(R.raw.wo);
                        readFile(fstream12, r);
                        break;

                }
                break;
            }
            case R.id.radioButton2: {

                switch (item) {

                    case "A":
                        r = 6;
                        InputStream fstream1 = getResources().openRawResource(R.raw.a);
                        readFile(fstream1, r);
                        break;
                    case "KA":
                        r = 9;
                        InputStream fstream2 = getResources().openRawResource(R.raw.ka);
                        readFile(fstream2, r);
                        break;

                    case "SA":
                        r = 9;
                        InputStream fstream3 = getResources().openRawResource(R.raw.sa);
                        readFile(fstream3, r);
                        break;
                    case "TA":
                        r = 9;
                        InputStream fstream5 = getResources().openRawResource(R.raw.ta);
                        readFile(fstream5, r);
                        break;
                    case "NA":
                        r = 6;
                        InputStream fstream6 = getResources().openRawResource(R.raw.na);
                        readFile(fstream6, r);
                        break;
                    case "HA":
                        r = 11;
                        InputStream fstream7 = getResources().openRawResource(R.raw.ha);
                        readFile(fstream7, r);
                        break;
                    case "MA":
                        r = 6;
                        InputStream fstream8 = getResources().openRawResource(R.raw.ma);
                        readFile(fstream8, r);
                        break;
                    case "YA":
                        r = 6;
                        InputStream fstream9 = getResources().openRawResource(R.raw.ya);
                        readFile(fstream9, r);
                        break;
                    case "RA":
                        r = 6;
                        InputStream fstream10 = getResources().openRawResource(R.raw.ra);
                        readFile(fstream10, r);
                        break;
                    case "WA":
                        r = 6;
                        InputStream fstream11 = getResources().openRawResource(R.raw.wa);
                        readFile(fstream11, r);
                        break;
                    case "WO":
                        r = 6;
                        InputStream fstream12 = getResources().openRawResource(R.raw.wo);
                        readFile(fstream12, r);
                        break;
                }
                break;
            }
        }

        selection = (TextView) findViewById(R.id.textView2);
        selection.setTextSize(150);
        selection.setTextColor(Color.BLACK);
        Rand();
        if (switchState == (true)) {
            switch (selectedTest2) {
                case R.id.radioButton3: {
                    selection.setText(Res3);
                    ch = 1;
                    Log.d("Переключатель", "ch=" + ch);
                    break;
                }
                case R.id.radioButton4: {
                    selection.setText(Res2);
                    ch = 1;
                    Log.d("Переключатель", "ch=" + ch);
                    break;
                }
            }
        } else {
            //selection.setText(OutPutRand());
            selection.setText(Res);
            ch=0;
        }
        bt_ch2();
    }

    public void click_bt_ch(View v)
    {
        int bts = v.getId();
        Log.d("onClick_bt_ch", "bts="+bts);
        TextView bt = (TextView) findViewById(bts);
        String btss = bt.getText().toString();
        Log.d("onClick_bt_ch", "btss="+btss);
        //Log.d("onClick_bt_ch", "Res="+btss);
        selection = (TextView) findViewById(R.id.textView2);
        if(btss == Res3)
        {

            selection.setTextSize(150);
            selection.setTextColor(Color.parseColor("#03DAC6"));
            selection.setText("✓");
        }
        else
        {
            selection.setTextSize(150);
            selection.setTextColor(Color.parseColor("#B00020"));
            selection.setText("×");
        }


    }

    String st = "STOP";
    int a=0,b=0,c=0,f=0;
    String[] str =new String[300];
    String[] str2 = new String[300];
    String[] str3 = new String[300];
    int index2=10;

    void bt_ch2()
    {

        bt =(TextView) findViewById(R.id.bt_ch1);
        bt.setText(str3[0]);
        bt =(TextView) findViewById(R.id.bt_ch2);
        bt.setText(str3[1]);
        bt =(TextView) findViewById(R.id.bt_ch3);
        bt.setText(str3[2]);
        bt =(TextView) findViewById(R.id.bt_ch4);
        bt.setText(str3[3]);
        bt =(TextView) findViewById(R.id.bt_ch5);
        bt.setText(str3[4]);
    }

    void bt_ch()
    {

        bt =(TextView) findViewById(R.id.bt_ch1);
        bt.setText(str2[0]);
        bt =(TextView) findViewById(R.id.bt_ch2);
        bt.setText(str2[1]);
        bt =(TextView) findViewById(R.id.bt_ch3);
        bt.setText(str2[2]);
        bt =(TextView) findViewById(R.id.bt_ch4);
        bt.setText(str2[3]);
        bt =(TextView) findViewById(R.id.bt_ch5);
        bt.setText(str2[4]);
    }


    void Imput(String cstr) {
        if(!cstr.equals(st)) {
            str[b] = cstr;
            b++;
        }
    }

    void Imput2(String cstr) {
        if(!cstr.equals(st))
        {
            str2[a] = cstr;
            a++;
        }
    }
    void Imput3(String cstr) {
        if(!cstr.equals(st))
        {
            str3[c] = cstr;
            c++;
        }
    }


    void Clean() {


        for (int i = 0; i < b; i++) {
            str[i] = "";
            str2[i] = "";
        }
        Res = "";
        b = 0;
        a=0;
        c=0;
    }

    void Rand() {

        int index = (int) ( Math.random() * b+1);
        if(index==index2)
        {
            while (index==index2) {
                index = (int) (Math.random() * b + 1);
            }
        }
        index2 =index;
        Res = str[index-1];
        Res2 = str2[index-1];
        Res3 = str3[index-1];
    }

}
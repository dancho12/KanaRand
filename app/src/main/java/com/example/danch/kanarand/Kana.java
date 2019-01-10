package com.example.danch.kanarand;

import android.content.Intent;
import android.graphics.Color;
import android.os.Handler;
import android.support.annotation.StringRes;
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
import java.util.concurrent.TimeUnit;

public class Kana extends MainActivity {

    String Res = "";
    String Res2 = "";
    String Res3 = "";

    String[] rows = {"A", "KA", "SA", "TA", "NA", "HA","MA","YA","RA","WA"};
    TextView selection;
    String item;
    private int selectedTest;
    RadioGroup radio;
    private int selectedTest2;
    RadioGroup radio2;
    int ch=0;//переключатель

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
        pr_t=0;
        value = 0;


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

    public void onClick22(View view) {
        Intent myIntent = new Intent(view.getContext(), com.example.danch.kanarand.KanaCh.class);
        startActivityForResult(myIntent, 0);
    }

    public void show(View v)
    {
        selection = (TextView) findViewById(R.id.textView2);
        selection.setTextColor(Color.BLACK);
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
                    if (a > 66 && a < 133) {

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
                if (b > 132&&(r==2||r==3)) {

                    Imput2(strLine);
                }
                if (b > 198&&(r==2||r==3)) {

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
//        View btr = findViewById(R.id.tbr);
//        btr.setVisibility(View.INVISIBLE);
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

        switch (selectedTest2) {
            case R.id.radioButton3: {
                bt_ch_rand(1);
                break;
            }
            case R.id.radioButton4: {
                bt_ch_rand(0);
                break;
            }
        }
    }

    public void fu(View v) {

        Clean();
        int r = 0;
        Switch simpleSwitch = (Switch) findViewById(R.id.switch1);
        Boolean switchState = simpleSwitch.isChecked();

//        View btr = findViewById(R.id.tbr);
//        btr.setVisibility(View.VISIBLE);

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

        switch (selectedTest2) {
            case R.id.radioButton3: {
                bt_ch(1);
                break;
            }
            case R.id.radioButton4: {
                bt_ch(0);
                break;
            }
        }

    }


    int tu =0;
    public void click_bt_ch(final View v){
        Switch simpleSwitch = (Switch) findViewById(R.id.switch1);
        Boolean switchState = simpleSwitch.isChecked();
            value++;
            int bts = v.getId();
            Log.d("onClick_bt_ch", "bts=" + bts);
            TextView bt = (TextView) findViewById(bts);
            String btss = bt.getText().toString();
            Log.d("onClick_bt_ch", "btss=" + btss);
            //Log.d("onClick_bt_ch", "Res="+btss);
            selection = (TextView) findViewById(R.id.textView2);
            if (btss == Res3 || btss == Res2|| btss == Res) {

                selection.setTextSize(150);
                selection.setTextColor(Color.parseColor("#03DAC6"));
                selection.setText("✓");
                pr_t++;
            } else {
                selection.setTextSize(150);
                selection.setTextColor(Color.parseColor("#B00020"));
                //selection.setText("×");
                if(switchState ==(true))
                {
                    selection.setText(Res);
                }
                else
                {
                    switch (selectedTest2) {
                        case R.id.radioButton3: {
                            selection.setText(Res3);
                            break;
                        }
                        case R.id.radioButton4: {
                            selection.setText(Res2);
                            break;
                        }
                }

                }
            }

            int proc = ((pr_t*100)/value);
            TextView tur = (TextView) findViewById(R.id.textViewRES);
            tur.setText(getString(R.string.Types)+Integer.toString(value)+"\n"+getString(R.string.TrueRES)+Integer.toString(pr_t)+"\n"+Integer.toString(proc)+"%");
            final Handler handler = new Handler();
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    if(tu==1)
                    {
                        fu(v);
                    }
                    else if(tu==2)
                    {
                        full_rand(v);
                    }
                }
            }, 500);

    }




    String st = "STOP";
    int a=0,b=0,c=0,f=0;
    String[] str =new String[300];
    String[] str2 = new String[300];
    String[] str3 = new String[300];
    int index2=10;
    int index;

    void bt_ch(int ch)
    {
        tu =1;
        Switch simpleSwitch = (Switch) findViewById(R.id.switch1);
        Boolean switchState = simpleSwitch.isChecked();
        String bt_id[] = {"2131165218","2131165219","2131165220","2131165221","2131165222"};
        String st = "";
        for(int i=0;i<5;i++)
        {
            int id = Integer.parseInt(bt_id[i]);
            View btr = findViewById(id);

            bt =(TextView) findViewById(id);
            if(!str3[i].equals(st)||str2[i].equals(st))
            {
                btr.setVisibility(View.VISIBLE);
                if(switchState ==(true))
                {
                    bt.setText(str[i]);
                }
                else
                {
                    switch (ch)
                    {
                        case 0:
                            bt.setText(str2[i]);
                            break;
                        case 1:  bt.setText(str3[i]);
                            break;
                    }
                }

            }
            else
            {

                btr.setVisibility(View.INVISIBLE);
            }
        }
    }

    void bt_ch_rand(int ch)
    {
        tu =2;
        Switch simpleSwitch = (Switch) findViewById(R.id.switch1);
        Boolean switchState = simpleSwitch.isChecked();
        String bt_id[] = {"2131165218","2131165219","2131165220","2131165221","2131165222"};
        String st = "";
        int index2 = (int) (Math.random() * 5+1 );
        int id_r = Integer.parseInt(bt_id[index2-1]);
        bt =(TextView) findViewById(id_r);
        if(switchState ==(true))
        {
            bt.setText(str[index-1]);
        }
        else
        {
            switch (ch)
            {
                case 0:
                    bt.setText(str2[index-1]);
                    break;
                case 1:  bt.setText(str3[index-1]);
                    break;
            }
        }

        for(int i=0;i<5;i++)
        {
            if(i!=(index2-1))
            {
                int ii = (int) (Math.random() * b );
                if(ii==index-1)
                {
                    while (ii==index-1) {
                        ii = (int) (Math.random() * b );
                    }
                }
                int id = Integer.parseInt(bt_id[i]);
                View btr = findViewById(id);

                bt =(TextView) findViewById(id);
                if(!str3[ii].equals(st)||str2[ii].equals(st))
                {
                    btr.setVisibility(View.VISIBLE);
                    if(switchState == (true))
                    {
                        bt.setText(str[ii]);
                    }
                    else
                    {
                        switch (ch)
                        {
                            case 0:
                                bt.setText(str2[ii]);
                                break;
                            case 1:  bt.setText(str3[ii]);
                                break;
                        }
                    }

                }
                else
                {

                    btr.setVisibility(View.INVISIBLE);
                }
            }

        }
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
            str3[i] = "";
        }
        Res = "";
        Res2 = "";
        Res3 = "";
        b = 0;
        a=0;
        c=0;
    }

    void Rand() {

        index = (int) ( Math.random() * b+1);
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
package com.example.danch.kanarand;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class NumberPage extends MainActivity {
int ch=0;
int ch2=0;
TextView n;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.number_page);

        ActionBar actionBar =getSupportActionBar();
        actionBar.setHomeButtonEnabled(true);
        actionBar.setDisplayHomeAsUpEnabled(true);

        InputStream fstream = getResources().openRawResource(R.raw.num);
        readFile2(fstream);
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

//    public void visible1(View v)
//    {
//        View b = findViewById(R.id.frameLayout);
//        switch (ch)
//        {
//            case 0:b.setVisibility(View.INVISIBLE);
//            ch = 1;
//                break;
//            case 1:
//                b.setVisibility(View.VISIBLE);
//                ch = 0;
//                break;
//        }
//    }

    String st = "STOP";
    String[] num1 = new String[300];
    String numres="";
    String numres2 ="";
    String numres3 ="";
    int s = 1;

    public void show2(View v)
    {
        n = (TextView) findViewById(R.id.textView3);
        switch (ch2) {

            case  0:
                n.setText(numres2);
                ch2 = 1;
                break;
            case 1:
                 n.setText(numres);
                ch2 = 0;
                break;
        }
    }

    private void readFile2(InputStream fstream) {

        try{
            int a=0,b=0;
            //InputStream fstream = getResources().openRawResource(R.raw.test);
            BufferedReader br = new BufferedReader(new InputStreamReader(fstream));
            String strLine;
            while ((strLine = br.readLine()) != null) {
                System.out.println(strLine);

                ImputNum(strLine);

            }
            fstream.close();
        }catch (IOException e){
            System.out.println("Ошибка");
        }
    }
    void ImputNum(String cstr) {
        if(!cstr.equals(st))
        {
            num1[s] = cstr;
            s++;
        }
    }

    void r(int indx)
    {
        if(indx<10)
        {
            if(indx!=0) {
                numres = numres + " " + num1[indx];
            }
        }
        else if(indx<100){
            int y = indx/10;
            if(y!=1){
                numres = numres+" "+num1[y];
            }
            numres = numres+" "+num1[10];
            y = indx%10;
            if(y!=0) {
                numres = numres +" "+ num1[y];
            }


        }
        else if(indx<1000)
        {
                if ((indx / 100) == 3) {
                    numres = numres + " " + "САМБЯКУ";
                    indx = indx - 300;
                    r(indx);
                } else if ((indx / 100) == 6) {
                    numres = numres + " " + "РОППЯКУ";
                    indx = indx - 600;
                    r(indx);
                } else if ((indx / 100) == 8) {
                    numres = numres + " " + "ХАППЯКУ";
                    indx = indx - 800;
                    r(indx);
                } else {
                    int y = indx / 100;
                    if (y != 1) {
                        numres = numres + " " + num1[y];
                    }
                    numres = numres + " " + num1[11];
                    indx = indx - (y * 100);
                    r(indx);
                }
        }
        else if(indx<10000)
        {
                if ((indx / 1000) == 3) {
                    numres = numres + " " + "САНДЗЭН";
                    indx = indx - 3000;

                    r(indx);
                }
                else if ((indx / 1000) == 8) {
                    numres = numres + " " + "ХАССЭН";
                    indx = indx - 8000;
                    r(indx);
                } else {
                    int y = indx / 1000;
                    if (y != 1) {
                        numres = numres + " " + num1[y];
                    }
                    numres = numres + " " + num1[12];
                    indx = indx - (y * 1000);
                    r(indx);
                }

        }
        else if(indx>=10000)
        {
            int y = indx / 10000;
            if(y!=1){
                numres = numres+" "+num1[y];
            }
            numres = numres + " " + num1[13];
            indx = indx - (y * 10000);
            r(indx);
        }
    }

    public void number(View v)
    {
        Switch simpleSwitch = (Switch) findViewById(R.id.switch3);//переключатель рандома
        Boolean switchState = simpleSwitch.isChecked();
        numres ="";
        n= (TextView)findViewById(R.id.textView3);
        int a;
        final EditText editText = (EditText)findViewById(R.id.editText2);
        String number = editText.getText().toString();
        a = Integer.parseInt(number);
        int indx;
        if(switchState ==(true)){
            indx = (int) (Math.random() * a + 1);
        }
        else
        {
            indx = a;
        }

        if(indx<11)
        {
            if(indx ==4)
            {
                numres = "СИ";
            }
            else if(indx ==7)
            {
                numres = "СИЧИ";
            }
            else if(indx ==9)
            {
                numres = "КУ";
            }
            else {
                numres = num1[indx];
            }
        }
        else if(indx>10)
        {
            r(indx);
        }

        numres2 = Integer.toString(indx);
        n.setTextSize(36);
        Switch simpleSwitch2 = (Switch) findViewById(R.id.switch4);
        Boolean switchState2 = simpleSwitch2.isChecked();
        if(switchState2 ==(true))
        {
            n.setText(numres2);
            ch2 = 1;
        }
        else {
            n.setText(numres);
            ch2 = 0;
        }

    }
}

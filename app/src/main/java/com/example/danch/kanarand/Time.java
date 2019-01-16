package com.example.danch.kanarand;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.ActionBar;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Switch;
import android.widget.TextView;

public class Time extends Numbers {
    int ch=0;
    int ch2=0;
    TextView n;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.time);

        ActionBar actionBar =getSupportActionBar();
        actionBar.setHomeButtonEnabled(true);
        actionBar.setDisplayHomeAsUpEnabled(true);

//        InputStream fstream = getResources().openRawResource(R.raw.num);
//        readFile2(fstream);

        RadioGroup radio = (RadioGroup)findViewById(R.id.radioGroupJR2);
        selectedTest = radio.getCheckedRadioButtonId();

//        RadioGroup radio2 = (RadioGroup)findViewById(R.id.radioGroupNT);
//        selectedTest2 = radio2.getCheckedRadioButtonId();
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
    public void onClick(View view) {
        Intent intent = new Intent();
        setResult(RESULT_OK, intent);
        finish();
    }



    String st = "STOP";
    //String[] num1 = new String[300];
    String[] num1 = {"","ИЧИ", "НИ", "САН", "ЁН", "ГО", "РОКУ", "НАНА", "ХАЧИ", "КЮ:", "ДЗЮ:", "ХЯКУ", "СЕН", "МАН","ОКУ","ТЁ:"};
    String[] num2 = {"","いち", "に", "さん", "よん", "ご", "ろく", "なな", "はち", "きゅう", "じゅう", "ひゃく", "せん", "まん","おく","ちょう"};
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




    public void check_answerT(final View v)
    {
        check_answer();
        final Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                time(v);
            }
        }, 500);
    }


    String numH ="";
    String numM ="";
    void hours(int num)
    {
        numH = "";
        String[] num11 = {"","ИЧИДЗИ", "НИДЗИ", "САНДЗИ", "ЁДЗИ", "ГОДЗИ", "РОКУДЗИ", "СИТИДЗИ", "ХАТИДЗИ", "КУДЗИ:", "ДЗЮ:ДЗИ", "ДЗЮ:ИТИДЗИ", "ДЗЮ:НИДЗИ"};
        String[] num2 = {"","いちじ", "にじ", "さんじ", "よじ", "ごじ", "ろくじ", "しちじ", "はちじ", "くじ", "じゅうじ", "じゅいちじ", "じゅにじ"};
        String[] num1 = new String[0];
        switch (selectedTest) {
            case R.id.radioButtonR2: {
                num1 = num11;
                break;
            }
            case R.id.radioButtonJ2: {

                num1 = num2;
                break;
            }
        }
        numH = num1[num];
        Log.d("time", "numH="+ numH);
    }


    void min(int num)
    {
        numM = "";
        String[] num11 = {"","ИПУН", "НИФУН", "САНПУН", "ЁНПУН", "ГОФУН", "РОПУН", "НАНАФУН", "ХАППУН", "КЮ:ФУН", "ДЗЮППУН", "САНДЗЮПУН"};
        String[] num22 = {"","いっぷん", "にふん", "さんぷん", "よんぷん", "ごふん", "ろっぷん", "ななふん", "はっぷん", "きゅうふん", "じゅっぷん", "さんじゅぷん"};
        int r=0;
        String[] numN = new String[0];
        String[] numY = new String[0];
        switch (selectedTest) {
            case R.id.radioButtonR2: {
                numN = num11;
                numY = num1;
                r=1;
                break;
            }
            case R.id.radioButtonJ2: {

                numN = num22;
                numY = num2;
                r=2;
                break;
            }
        }

        if(num<10)
        {


            numM = numM + numN[num];

        }
        else if(num==30)
        {
            numM = numM + numN[11];
        }
        else if(num<60){
            int y = num/10;
            if(y!=1){
                numM = numM +numY[y];
            }

            y = num%10;
            if(y!=0) {
                numM = numM +numY[10];
                numM = numM + numN[y];
            }
            else if(y==0)
            {
                numM = numM + numN[10];
            }

        }
        Log.d("time", "numN="+ numM);
    }
    public void time(View v)
    {
        int a = 0;
        int b = 0;
        Switch simpleSwitch = (Switch) findViewById(R.id.switchRn);//переключатель рандома
        Boolean switchState = simpleSwitch.isChecked();
        if(switchState ==(false)){
            final EditText editText = (EditText)findViewById(R.id.editText2);
            String number = editText.getText().toString();
            String[] numParts = number.split(":");

            a = Integer.parseInt(numParts[0]);
            if(a>12)
            {
                a=a-12;
            }
            b = Integer.parseInt(numParts[1]);
        }
        else {
            a = (int) (Math.random() * 12 + 1);
            b = (int) (Math.random() * 59 + 1);
        }
        hours(a);
        min(b);
        String oa = "";
        String ob = "";
        if(a<10)
        {
            oa = "0";
        }
        if(b<10)
        {
            ob="0";
        }
        numres2 = oa+Integer.toString(a)+":"+ob+Integer.toString(b);
        numres = numH +" : "+ numM;
        n = (TextView)findViewById(R.id.textView3);
        n.setTextSize(36);
        n.setTextColor(Color.BLACK);
        Switch simpleSwitch2 = (Switch) findViewById(R.id.switchTR);
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

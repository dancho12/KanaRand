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

public class Calendar extends Numbers {
    int ch=0;
    int ch2=0;
    TextView n;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.calendar);

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




    public void check_answerC(final View v)
    {
        check_answer();
        final Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                calendar(v);
            }
        }, 500);
    }




    String numMo ="";
    String numD ="";
    void month(int num)
    {
        numMo = "";
        String[] num11 = {"","ИЧИГАЦУ", "НИГАЦУ", "САНГАЦУ", "СИГАЦУ", "ГОГАЦУ", "РОКУГАЦУ", "СИТИГАЦУ", "ХАЧИГАЦУ", "КУГАЦУ", "ДЗЮ:ГАЦУ", "ДЗЮ:ИТИГАЦУ", "ДЗЮ:НИГАЦУ"};
        String[] num2 = {"","いちがつ", "にがつ", "さんがつ", "しがつ", "ごがつ", "ろくがつ", "しちがつ", "はちがつ", "くがつ", "じゅうがつ", "じゅういちがつ", "じゅうにがつ"};
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
        numMo = num1[num];
        Log.d("time", "numH="+ numMo);
    }


    void day(int num)
    {
        numD = "";
        String[] num1 = {"","ЦУИТАЧИ", "ФУЦУКА", "МИККА", "ЁККА", "ИЦУКА", "МУИКА", "НАНОКА", "Ё:КА", "КОКОНОКА", "ТО:КА", "ДЗЮ:ЁККА", "ХАЦУКА", "НИДЗЮ:ЁККА","НИЧИ"};
        String[] num2 = {"","ついたち", "ふつか", "みっか", "よっか", "いつっか", "むいっか", "なのか", "ようか", "ここのか", "とうか", "じゅうよっか", "はつか", "にじゅうよっか","にち"};
        int r=0;
        String[] numN = new String[0];
        String[] numY = new String[0];
        switch (selectedTest) {
            case R.id.radioButtonR2: {
                numN = num1;
                numY = this.num1;
                r=1;
                break;
            }
            case R.id.radioButtonJ2: {

                numN = num2;
                numY = this.num2;
                r=2;
                break;
            }
        }

        if(num<10)
        {


            numD = numD+ numN[num];

        }
        else if(num==14)
        {
            numD = numD + numN[11];
        }
        else if(num==20)
        {
            numD = numD + numN[12];
        }
        else if(num==24)
        {
            numD = numD + numN[13];
        }
        else if(num<32){
            int y = num/10;
            if(y!=1){
                numD = numD +numY[y];
            }

            y = num%10;
            if(y!=0) {
                numD = numD +numY[10];
                numD = numD + numY[y]+numN[14];
            }
            else if(y==0)
            {
                numD = numD + numN[10];
            }

        }
        Log.d("time", "numN="+ numD);
    }


    public void calendar(View v)
    {
        int a = 0;//месяц
        int b = 0;//число
        Switch simpleSwitch = (Switch) findViewById(R.id.switchRnCl);//переключатель рандома
        Boolean switchState = simpleSwitch.isChecked();
        if(switchState ==(false)){
            final EditText editText = (EditText)findViewById(R.id.editTextCl);
            String number = editText.getText().toString();
            Log.d("Calendar","etidtext"+number);
            String[] numParts = number.split("/");

            b = Integer.parseInt(numParts[0]);
            a = Integer.parseInt(numParts[1]);
        }
        else {
            a = (int) (Math.random() * 12 + 1);
            if(a==1||a==3||a==5||a==7||a==8||a==10||a==12)
            {
                b = (int) (Math.random() * 31 + 1);
            }
            else if(a==2)
            {
                b = (int) (Math.random() * 28 + 1);
            }
            else
            {
                b = (int) (Math.random() * 30 + 1);
            }

        }
        month(a);
        day(b);
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
        numres2 = ob+Integer.toString(b)+"/"+oa+Integer.toString(a);
        numres = numMo +" / "+ numD;
        n = (TextView)findViewById(R.id.textView3);
        n.setTextSize(36);
        n.setTextColor(Color.BLACK);
        Switch simpleSwitch2 = (Switch) findViewById(R.id.switchTRCl);
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

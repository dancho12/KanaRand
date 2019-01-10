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

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class NumberPage extends MainActivity {
int ch=0;
int ch2=0;
TextView n;



    private int selectedTest;
    private int selectedTest2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.number_page);

        ActionBar actionBar =getSupportActionBar();
        actionBar.setHomeButtonEnabled(true);
        actionBar.setDisplayHomeAsUpEnabled(true);

//        InputStream fstream = getResources().openRawResource(R.raw.num);
//        readFile2(fstream);

        RadioGroup radio = (RadioGroup)findViewById(R.id.radioGroupJR);
        selectedTest = radio.getCheckedRadioButtonId();

        RadioGroup radio2 = (RadioGroup)findViewById(R.id.radioGroupNT);
        selectedTest2 = radio2.getCheckedRadioButtonId();
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

    public void onClickRadioSelectTestJP (View v)
    {
        selectedTest = v.getId();
        Log.d("onClickRadioGroupSelectTest", "selectedTest="+selectedTest);
    }

    public void onClickRadioSelectTestNT (View v)
    {
        selectedTest2 = v.getId();
        Log.d("onClickRadioGroupSelectTest", "selectedTest="+selectedTest2);
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

//    private void readFile2(InputStream fstream) {
//
//        try{
//            int a=0,b=0;
//            //InputStream fstream = getResources().openRawResource(R.raw.test);
//            BufferedReader br = new BufferedReader(new InputStreamReader(fstream));
//            String strLine;
//            while ((strLine = br.readLine()) != null) {
//                System.out.println(strLine);
//
//                ImputNum(strLine);
//
//            }
//            fstream.close();
//        }catch (IOException e){
//            System.out.println("Ошибка");
//        }
//    }
//    void ImputNum(String cstr) {
//        if(!cstr.equals(st))
//        {
//            num1[s] = cstr;
//            s++;
//        }
//    }

//    int value;
//    int pr_t;
    int indx;


    public void click_bt_ch2(final View v){
        value++;
        int bts = v.getId();
        Log.d("onClick_bt_ch2", "bts=" + bts);
        TextView bt = (TextView) findViewById(bts);
       int btss = Integer.parseInt(bt.getText().toString());
        Log.d("onClick_bt_ch", "btss=" + btss);
        //Log.d("onClick_bt_ch", "Res="+btss);
        TextView selection = (TextView) findViewById(R.id.textView3);
        if (btss == indx) {

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
        TextView tur = (TextView) findViewById(R.id.textViewRES2);
        tur.setText(getString(R.string.Types)+Integer.toString(value)+"\n"+getString(R.string.TrueRES)+Integer.toString(pr_t)+"\n"+Integer.toString(proc)+"%");
        final Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                number(v);
            }
        }, 500);

    }
    int ii;
    int randomNum_ch(int a)
    {
        int d = 2;
        int b = (int) (Math.random() * d+1);

        if(b==1){
            if(a<0){
                a = a+((int) (Math.random() * 20)+1);
                if(a==ii||a==indx)
                {
                    while (a==ii||a==indx)  {
                        a = a+((int) (Math.random() * 20)+1);
                    }
                }
            }
        }
        else if(b==2)
        {
            if(a<0){
                a = a-((int) (Math.random() * 20)+1);
                if(a==ii||a==indx)
                {
                    while (a==ii||a==indx)  {
                        a = a-((int) (Math.random() * 20)+1);
                    }
                }
            }
            else
            {
                a = a+((int) (Math.random() * 20)+1);
                if(a==ii||a==indx)
                {
                    while (a==ii||a==indx) {
                        a = a+((int) (Math.random() * 20)+1);
                    }
                }
            }

        }
        ii = a;
        return a;
    }
    void bt_ch()
    {
        String bt_id[] = {"2131165283","2131165284","2131165285","2131165286","2131165287"};
        String st = "";
        int index2 = (int) (Math.random() * 5+1 );
        int id_r = Integer.parseInt(bt_id[index2-1]);
        TextView bt2 =(TextView) findViewById(id_r);
        bt2.setText(Integer.toString(indx));
        for(int i=0;i<5;i++)
        {
            if(i!=id_r)
            {
                int id = Integer.parseInt(bt_id[i]);

                TextView bt =(TextView) findViewById(id);

                bt.setText(Integer.toString(randomNum_ch(indx)));
            }


        }
    }

    public void check_answer(final View v)
    {
        value++;
        final EditText editText = (EditText)findViewById(R.id.editText_answer);
        String number = editText.getText().toString();
        int a = Integer.parseInt(number);

        TextView selection = (TextView) findViewById(R.id.textView3);
        if (a == indx) {

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
        TextView tur = (TextView) findViewById(R.id.textViewRES2);
        tur.setText(getString(R.string.Types)+Integer.toString(value)+"\n"+getString(R.string.TrueRES)+Integer.toString(pr_t)+"\n"+Integer.toString(proc)+"%");
        editText.setText(null);
        final Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                number(v);
            }
        }, 500);
    }

    void r(int indx, String[] num1,int r)
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
                    if(r==1)
                    {
                        numres = numres + " " + "САМБЯКУ";
                    }else if(r==2)
                    {
                        numres = numres + " " + "さんびゃく";
                    }

                    indx = indx - 300;
                    r(indx, num1,r);
                } else if ((indx / 100) == 6) {
                    if(r==1)
                    {
                        numres = numres + " " + "РОППЯКУ";
                    }else if(r==2)
               {
                        numres = numres + " " + "ろっぴゃく";
                    }

                    indx = indx - 600;
                    r(indx, num1,r);
                } else if ((indx / 100) == 8) {
                    if(r==1)
                    {
                        numres = numres + " " + "ХАППЯКУ";
                    }else if(r==2)
               {
                        numres = numres + " " + "はっぴゃく";
                    }

                    indx = indx - 800;
                    r(indx, num1,r);
                } else {
                    int y = indx / 100;
                    if (y != 1) {
                        numres = numres + " " + num1[y];
                    }
                    numres = numres + " " + num1[11];
                    indx = indx - (y * 100);
                    r(indx, num1,r);
                }
        }
        else if(indx<10000)
        {
                if ((indx / 1000) == 3) {
                    if(r==1)
                    {
                        numres = numres + " " + "САНДЗЭН";
                    }else if(r==2)
                    {
                        numres = numres + " " + "さんぜん";
                    }

                    indx = indx - 3000;

                    r(indx, num1,r);
                }
                else if ((indx / 1000) == 8) {
                    if(r==1)
                    {
                        numres = numres + " " + "ХАССЭН";
                    }else if(r==2)
                    {
                        numres = numres + " " + "はっせん";
                    }

                    indx = indx - 8000;
                    r(indx, num1,r);
                } else {
                    int y = indx / 1000;
                    if (y != 1) {
                        numres = numres + " " + num1[y];
                    }
                    numres = numres + " " + num1[12];
                    indx = indx - (y * 1000);
                    r(indx, num1,r);
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
            r(indx, num1,r);
        }
        else if(indx>=100000000)
        {
            int y = indx / 100000000;
            if(y!=1){
                numres = numres+" "+num1[y];
            }
            numres = numres + " " + num1[14];
            indx = indx - (y * 100000000);
            r(indx, num1,r);
        }
        else if(indx>=1000000000)
        {
            int y = indx / 1000000000;
            if(y!=1){
                numres = numres+" "+num1[y];
            }
            numres = numres + " " + num1[15];
            indx = indx - (y * 1000000000);
            r(indx, num1,r);
        }
    }

    public void number(View v)
    {

        int r=0;
        String[] num = new String[0];
        switch (selectedTest) {
            case R.id.radioButtonR: {
                num = num1;
                r=1;
                break;
            }
            case R.id.radioButtonJ: {

                num = num2;
                r=2;
                break;
            }
        }
        Switch simpleSwitch = (Switch) findViewById(R.id.switch3);//переключатель рандома
        Boolean switchState = simpleSwitch.isChecked();
        numres ="";
        n= (TextView)findViewById(R.id.textView3);
        int a;
        final EditText editText = (EditText)findViewById(R.id.editText2);
        String number = editText.getText().toString();
        a = Integer.parseInt(number);
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
                if(r==1)
                {
                    numres = "СИ";
                }
                else if(r==2)
                {
                    numres = "し";
                }

            }
            else if(indx ==7)
            {
                if(r==1)
                {
                    numres = "СИЧИ";
                }
                else if(r==2) {
                    numres = "しち";
                }
            }
            else if(indx ==9)
            {
                if(r==1)
                {
                    numres = "КУ";
                }
                else if(r==2) {
                    numres = "く";
                }
            }
            else {
                numres = num[indx];
            }
        }
        else if(indx>10)
        {
            r(indx, num,r);
        }

        numres2 = Integer.toString(indx);
        n.setTextSize(36);
        n.setTextColor(Color.BLACK);
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

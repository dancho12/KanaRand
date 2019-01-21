package com.example.danch.kanarand;


import android.graphics.Color;
import android.os.Handler;
import android.support.v7.app.ActionBar;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;

import static android.provider.Telephony.Mms.Part.FILENAME;


public class Word extends MainActivity {

    private final static String FILENAME = "japan.txt"; // имя файла
    private final static String FILENAME2 = "russian.txt"; // имя файла
    private EditText mEditText;
    private EditText mEditText2;


    String[] ResJ = new String[300];
    String[] ResR = new String[300];
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.word_page);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setHomeButtonEnabled(true);
        actionBar.setDisplayHomeAsUpEnabled(true);

        mEditText = (EditText) findViewById(R.id.editText3);
        mEditText2 = (EditText) findViewById(R.id.editText4);
        start();
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
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

    String resJ ="";
    String resR ="";
    String To ="";
    String To2 ="";
    int a=0;
    // Метод для открытия файла
    private void openFile(String fileName,int r) {
        int tt =0;
        try {
            InputStream inputStream = openFileInput(fileName);

            if (inputStream != null) {
                InputStreamReader isr = new InputStreamReader(inputStream);
                BufferedReader reader = new BufferedReader(isr);
                String line;
                StringBuilder builder = new StringBuilder();

                while ((line = reader.readLine()) != null) {
                    switch (r){
                        case 0:
                            ResJ[tt] = line;
                            Log.d("dffffff","ResJ["+tt+"]="+ResJ[tt]);
                            break;
                        case 1:
                            ResR[tt] = line;
                            break;
                        default:
                            break;
                    }
                   tt++;
                }
                inputStream.close();
            }
        } catch (Throwable t) {
            Toast.makeText(getApplicationContext(),
                    "Exception: " + t.toString(), Toast.LENGTH_LONG).show();
        }
        a=tt;
    }

    // Метод для сохранения файла
    private void saveFile(String fileName,int r) {
        try {
            OutputStream outputStream = openFileOutput(fileName, 0);
            OutputStreamWriter osw = new OutputStreamWriter(outputStream);
            switch (r){
                case 0:
                    osw.write(resJ);
                    break;
                case 1:
                    osw.write(resR);
                    break;
                    default:
                        break;
            }
            //osw.write(mEditText.getText().toString());
            osw.close();
        } catch (Throwable t) {
            Toast.makeText(getApplicationContext(),
                    "Exception: " + t.toString(), Toast.LENGTH_LONG).show();
        }
    }

    void Sum(){
        resR ="";
        resJ = "";
        String n = "\n";
        if(a!=0){
            for(int i = 0;i<a;i++){
                resR =resR+ResR[i]+n;
                resJ = resJ+ResJ[i]+n;
            }
            resJ =resJ+mEditText.getText().toString();
            resR = resJ+mEditText2.getText().toString();
        }
        else{
            resJ = mEditText.getText().toString();
            resR = mEditText2.getText().toString();
        }

    }


    int index;
    int index2;
    public void startV(View v)
    {
        start();
    }
    public void start()
    { Switch simpleSwitch = (Switch) findViewById(R.id.switch5);//переключатель
        Boolean switchState = simpleSwitch.isChecked();
        openFile(FILENAME,0);
        openFile(FILENAME2,1);
        TextView text = (TextView)findViewById(R.id.textView3);
        index = (int) (Math.random() * a + 1);
        if(index==index2)
        {
            while (index==index2) {
                index = (int) (Math.random() * a + 1);
            }
        }
        index2 =index;
        To = ResJ[index-1];
        To2 = ResR[index-1];
        text.setTextSize(36);
        text.setTextColor(Color.BLACK);
        if(switchState==(false)){
            text.setText(To);
        }
        else {
            text.setText(To2);
        }
    }
    String check ="";
    public void impWord(View v)
    {
        String re = mEditText.getText().toString();

        int cs=0;
        for(int i = 0;i<a;i++){
            if(re.equals(ResJ[i])){
                cs =1;
            }
        }
        if(cs==1)
        {
            Toast.makeText(getApplicationContext(),
                    "Слово уже есть!", Toast.LENGTH_LONG).show();
        }
        else if(re.equals(check)){
            Toast.makeText(getApplicationContext(),
                    "Введите что-нибудь", Toast.LENGTH_LONG).show();
        }
        else {
            Sum();
            saveFile(FILENAME, 0);
            saveFile(FILENAME2, 1);
            start();
        }
    }
    int ch =0;
    public void showWord(View v)
    {
        TextView selection = (TextView) findViewById(R.id.textView3);
        selection.setTextColor(Color.BLACK);
        switch (ch) {

            case  0:
                selection.setText(To2);
                ch = 1;
                Log.d("Переключатель", "ch=" + ch);
                break;
            case 1:
                selection.setText(To);
                ch = 0;
                Log.d("Переключатель", "ch=" + ch);
                break;
        }
    }

    public void check_answer()
    {

        final EditText editText = (EditText)findViewById(R.id.editText_answer);
        String number = editText.getText().toString();
        TextView selection = (TextView) findViewById(R.id.textView3);
        if (number.equals(To2)||number.equals(To)) {

            selection.setTextSize(150);
            selection.setTextColor(Color.parseColor("#03DAC6"));
            selection.setText("✓");
        }
        else if(number.equals(check)){
            Toast.makeText(getApplicationContext(),
                    "Введите что-нибудь", Toast.LENGTH_LONG).show();
        }
        else {
            selection.setTextSize(36);
            selection.setTextColor(Color.parseColor("#B00020"));
            if(ch == 0){
                selection.setText(To2);
            }
            else if(ch==1)
            {
                selection.setText(To);
            }

        }
        editText.setText(null);
    }

    public void check_answerW(final View v)
    {
        check_answer();
        final Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                start();
            }
        }, 500);
    }
}
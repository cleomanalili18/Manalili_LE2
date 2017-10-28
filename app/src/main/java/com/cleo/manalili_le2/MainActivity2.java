package com.cleo.manalili_le2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.TextView;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class MainActivity2 extends AppCompatActivity {

    TextView tv_display;
    TextView tv_display2;
    FileInputStream fis;
    SharedPreferences preferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        tv_display = (TextView) findViewById(R.id.tv_display1);
        tv_display2 = (TextView) findViewById(R.id.tv_display2);
        preferences = (getPreferences(Context.MODE_PRIVATE));

    }

    public void loadInfo(View view){
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
        String user = preferences.getString("username","");
        String pwd = preferences.getString("password","");
        tv_display2.setText("The password of " + user + ": " + pwd);
    }

    public void displaymessage (View view) {
        StringBuffer buffer = new StringBuffer();
        int read = 0;
        try{
            fis = openFileInput("output.txt");
            while((read = fis.read()) != -1){
                buffer.append((char)read);
            }
            fis.close();
        } catch (FileNotFoundException e){
            e.printStackTrace();
        } catch (IOException e){
            e.printStackTrace();
        }
        tv_display.setText("The username and password is:" + buffer.toString());
    }
    public void nextActivity(View view)
    {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}
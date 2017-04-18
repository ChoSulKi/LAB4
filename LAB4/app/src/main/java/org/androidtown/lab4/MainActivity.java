package org.androidtown.lab4;

import android.content.Intent;
import android.support.annotation.IdRes;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class MainActivity extends AppCompatActivity {
    EditText editText;
    RadioGroup radioGroup;
    RadioButton radioMan;
    RadioButton radioWoman;
    CheckBox chkSMS;
    CheckBox chkEmail;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText = (EditText)findViewById(R.id.name);
        radioGroup = (RadioGroup)findViewById(R.id.radioGroup);
        radioMan = (RadioButton)findViewById(R.id.radioMan);
        radioWoman = (RadioButton)findViewById(R.id.radioWoman);
        chkEmail = (CheckBox)findViewById(R.id.chkEmail);
        chkSMS = (CheckBox)findViewById(R.id.chkSMS);
        button = (Button)findViewById(R.id.button);

        button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                String userName = editText.getText().toString();/*we can take a name using EditText*/

                String send = " ";//initialize the send string
                String gender = "";//initialize gender string
                if(chkSMS.isChecked()){
                    send += "SMS ";//send is changes SMS or SMS Email or nothing
                }
                if(chkEmail.isChecked()){
                    send += "E-mail";//send is change Email or SMS Email or nothing
                }
                int radioId = radioGroup.getCheckedRadioButtonId();//we take radioId in radio group -> only one is checked in same radio group

                if(radioWoman.getId()==radioId){
                    gender = "여";
                }
                if(radioMan.getId()==radioId){
                    gender = "남";
                }

                Intent intent = new Intent(getApplicationContext(),RegisterActivity.class);//make intent
                Bundle myBundle = new Bundle();//bundle is needed by intent that have many things
                myBundle.putString("name",userName);
                myBundle.putString("gender",gender);
                myBundle.putString("send",send);
                /*myBundle have name,gender,send*/
                intent.putExtras(myBundle);//we put bundle to intent
                startActivity(intent);
            }
        });

    }
}
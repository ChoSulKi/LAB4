package org.androidtown.lab4;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class RegisterActivity extends AppCompatActivity {
    TextView printName;
    TextView printGender;
    TextView printSender;
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        printName = (TextView)findViewById(R.id.print1);
        printGender = (TextView)findViewById(R.id.print2);
        printSender = (TextView)findViewById(R.id.print3);
        Button backButton = (Button)findViewById(R.id.backButton);

        Intent myIntent = getIntent();//make intent object and insert received Intent
        Bundle receiveBundle = myIntent.getExtras();//make bundle object and insert extras
        String name = receiveBundle.getString("name");
        String gender = receiveBundle.getString("gender");
        String sender = receiveBundle.getString("send");

        printName.setText("성명     :    " + name);
        printGender.setText("성별     :    " + gender);
        printSender.setText("수신여부 :    " + sender);
        /*we can print Strinf in Textview using setText*/

        backButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){//if I click button, activity is changed.
                Intent intent = new Intent(getApplicationContext(),MainActivity.class);
                startActivity(intent);
            }
        });
    }
}

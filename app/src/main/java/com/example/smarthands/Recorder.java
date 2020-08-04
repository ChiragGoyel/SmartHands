package com.example.smarthands;

import android.content.Intent;
import android.speech.RecognizerIntent;
import android.speech.SpeechRecognizer;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class Recorder extends AppCompatActivity {

    SmsManager sms = SmsManager.getDefault();
    TextView tv;
    ImageButton ib;
    String languagePref = "hi",text="";
    Spinner sp,mySpinner;
    private static final int REQUEST_CODE_SPEECH_INPUT = 2000 ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recorder);
        tv = findViewById(R.id.tv);
        ib = findViewById(R.id.vButton);
        sp = findViewById(R.id.spinner);
        mySpinner = (Spinner) findViewById(R.id.spinner);

        ArrayAdapter<String> adapter= new ArrayAdapter<String>(this, R.layout.spinner_item);


        ib.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                System.out.println(sp.getSelectedItem());
                int i = sp.getSelectedItemPosition();

                if(i == 0){
                    languagePref = "en-US";
                }else{
                    languagePref = "hi";
                }
                speak();
            }
        });
    }

    private void speak() {
        Intent intent = new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);
        intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL,RecognizerIntent.LANGUAGE_MODEL_FREE_FORM);
        intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE, languagePref);
        intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE_PREFERENCE, languagePref);
        intent.putExtra(RecognizerIntent.EXTRA_ONLY_RETURN_LANGUAGE_PREFERENCE, languagePref);
        intent.putExtra(RecognizerIntent.EXTRA_PROMPT,"Speak Something");

        System.out.println(SpeechRecognizer.ERROR_SERVER);
        Toast.makeText(this,""+SpeechRecognizer.ERROR_SERVER,Toast.LENGTH_SHORT).show();



        try{

            startActivityForResult(intent,REQUEST_CODE_SPEECH_INPUT);

        }
        catch(Exception e){
            Toast.makeText(this,""+e.getMessage(),Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        switch(requestCode){
            case REQUEST_CODE_SPEECH_INPUT:{
                if(resultCode == RESULT_OK && null!=data){
                    ArrayList<String> result = data.getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS);
                    tv.setText(result.get(0));
                    Toast.makeText(this,""+SpeechRecognizer.ERROR_SERVER,Toast.LENGTH_SHORT).show();
                    System.out.println(SpeechRecognizer.ERROR_SERVER);

                }
                break;
            }

        }
    }

    public void sendLanguage(View view){
        text = mySpinner.getSelectedItem().toString();
        if(text.equals("Hindi")){
            sms.sendTextMessage("+918850959970",null,"1",null,null);
        }
    }

    public void sendMessage(View view){
        String messageToSend = tv.getText().toString();
        if(text.equals("Hindi")){
            sms.sendTextMessage("+918850959970",null,messageToSend,null,null);
        }
    }

}

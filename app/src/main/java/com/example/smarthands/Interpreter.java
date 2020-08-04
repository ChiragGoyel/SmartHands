package com.example.smarthands;

import android.app.ProgressDialog;
import android.net.Uri;
import android.net.wifi.p2p.WifiP2pManager;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.Timer;

public class Interpreter extends AppCompatActivity {
    private ProgressBar mProgressBar;
    private TextView mLoadingText;
    private ProgressDialog progress;

    private int mProgressStatus = 0;

    private Handler mHandler = new Handler();

    static int a = 0;
    ListView lv1;
    Uri uri;
    android.database.Cursor cur;
    java.util.List<String> sms;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_interpreter);
    }

    public void sendLanguage(View view){
        SmsManager sms = SmsManager.getDefault();
        Spinner mySpinner = findViewById(R.id.spinner);
        String text = mySpinner.getSelectedItem().toString();
        switch(text){
            case "Hindi" :
                sms.sendTextMessage("7021551843",null,"1",null,null);
                break;
            case "Marathi":
                sms.sendTextMessage("7021551843",null,"2",null,null);
                break;
            case "Gujarati":
                sms.sendTextMessage("7021551843",null,"3",null,null);
                break;
            case "Urdu":
                sms.sendTextMessage("7021551843",null,"4",null,null);
                break;
            case "Malayalam":
                sms.sendTextMessage("7021551843",null,"5",null,null);
                break;
            case "Telugu":
                sms.sendTextMessage("7021551843",null,"6",null,null);
                break;
            case "Tamil":
                sms.sendTextMessage("7021551843",null,"7",null,null);
                break;
            case "Kannada":
                sms.sendTextMessage("7021551843",null,"8",null,null);
                break;
            case "Punjabi":
                sms.sendTextMessage("7021551843",null,"9",null,null);
                break;
            case "Bengali" :
                sms.sendTextMessage("7021551843",null,"10",null,null);
                break;
        }
    }


    public void sendMessage(View view) throws InterruptedException {
        SmsManager sms = SmsManager.getDefault();
        TextView textView = (TextView) findViewById(R.id.editText);
        String text = textView.getText().toString();
        sms.sendTextMessage("+91-7021551843", null, text, null, null);

        lv1 = (ListView) findViewById(R.id.listView);
//        download();
        ArrayAdapter<String> adap = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, readAllMessage());
        lv1.setAdapter(adap);
    }

//        if (a==0) {
//            finish();
//            a = 1;
//            startActivity(getIntent());
//        }



//    public void download(){
//      progress=new ProgressDialog(this);
//      progress.setMessage("Downloading Music");
//      progress.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
//      progress.setIndeterminate(true);
//      progress.setProgress(0);
//      progress.show();
//
//      final int totalProgressTime = 100;
//      final Thread t = new Thread() {
//         @Override
//         public void run() {
//            int jumpTime = 0;
//
//            while(jumpTime < totalProgressTime) {
//               try {
//                  sleep(200);
//                  jumpTime += 5;
//                  progress.setProgress(jumpTime);
//               } catch (InterruptedException e) {
//                  // TODO Auto-generated catch block
//                  e.printStackTrace();
//               }
//            }
//         }
//      };
//      t.start();
//   }
    public java.util.List<String> readAllMessage() {
         sms = new java.util.ArrayList<String>();
         uri = Uri.parse("content://sms/inbox");
        for(int i=0;i<300000;i++){
            System.out.println(i);
        }
        cur = getContentResolver().query(uri, new String[]{"address", "body"}, null, null, null);
        cur.moveToNext();
        cur.moveToPosition(0);

        String body = cur.getString(1);
        String address = cur.getString(0);

        System.out.println("Body is " + body);
        System.out.println("Address is " + address);

        address.equals("+91-7021551843");
        System.out.println("address is equal");
        body.startsWith("Translated text is") ;
        sms.add("\nAddress: " + address + "\nBody: " + body);



        return sms;
    }

    }







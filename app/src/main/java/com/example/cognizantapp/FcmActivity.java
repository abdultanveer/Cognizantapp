package com.example.cognizantapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.IBinder;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.messaging.FirebaseMessaging;

public class FcmActivity extends AppCompatActivity {
public static String TAG = FcmActivity.class.getSimpleName();
    EditText prefsEditText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fcm);
        prefsEditText = findViewById(R.id.etPrefs);
    }
//singleton design pattern
    public void getToken(View view) {

        FirebaseMessaging.getInstance().getToken().addOnCompleteListener(
                new OnCompleteListener<String>() {
                    @Override
                    public void onComplete(@NonNull Task<String> task) {
                        // val token: String = task.getResult().toString()
                        String token = task.getResult().toString();
                        Log.i(TAG,"token is--"+token);

                    }
                }
        );
    }

    @Override
    protected void onPause() {
        super.onPause();
        saveData();
    }

    private void saveData() {
        //get the data from etPrefs
        String prefs = prefsEditText.getText().toString();
        //create a file
        SharedPreferences  preferences = getSharedPreferences("prefs_file_name",MODE_PRIVATE);
        //open the file in edit mode
        SharedPreferences.Editor editor = preferences.edit();
        //write to the file
        editor.putString("pkey",prefs);
        //save the file
        editor.apply();
    }

    @Override
    protected void onResume() {
        super.onResume();
        restoreData();
    }

    private void restoreData() {
        //read the data from the file
        SharedPreferences  preferences = getSharedPreferences("prefs_file_name",MODE_PRIVATE);
       String prefs = preferences.getString("pkey","");
        //put it back into the edittext
        prefsEditText.setText(prefs);
    }

    public void serviceHandler(View view) {
        Intent servIntent = new Intent(FcmActivity.this,MyService.class);
        servIntent.putExtra("musicname","somemusic.mp3");
        //startService(servIntent);//create a service
       // stopService(servIntent);
        bindService(servIntent,serviceConnection,BIND_AUTO_CREATE);
        //unbindService(serviceConnection);
    }

    ServiceConnection serviceConnection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName componentName, IBinder mBinder) {
            MyService.LocalBinder binder = (MyService.LocalBinder) mBinder;
           // MyService myService = new MyService();
           MyService myService =  binder.getService();
          int randomNo = myService.getRandomNumber();
          Log.i(TAG,"the otp is --"+randomNo);
          Log.i(TAG,myService.getWeatherJson("texas"));

        }

        @Override
        public void onServiceDisconnected(ComponentName componentName) {

        }
    };
}
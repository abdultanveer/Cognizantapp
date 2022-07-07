package com.example.cognizantapp;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    public  static String TAG = MainActivity.class.getSimpleName();
    EditText nameEditText; //declaration
    TextView resultTv;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main); //inflating of activity_main.xml file
        nameEditText = findViewById(R.id.etName); //initialization
        resultTv = findViewById(R.id.tvResult);
        //a = 10;
        Log.i(TAG,"im in onCreate");

    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.i(TAG,"im in onstart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.w(TAG,"im in onResume --restore the app state");

    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.e(TAG,"im in onPause-- save app state");

    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(TAG,"im in onStop");

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.v(TAG,"im in onDestroy");

    }

    public void clickHandler(View clickedView) {

        switch (clickedView.getId()){
            case R.id.btnLogin:
                startHomeActivity();
                break;
            case R.id.btnCancel:
               // Toast.makeText(this, "cancelling", Toast.LENGTH_SHORT).show();
                Intent dialIntent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:1234567")); //implicit intent --you're not divulging the name of the class to be invoked

                startActivity(dialIntent);
                break;
        }


    }

    private void startHomeActivity() {
        Student abdul = new Student("ansari",123,765.0f);
        Intent homeIntent = new Intent(this,HomeActivity.class); //explicit intent -- faster
        homeIntent.putExtra("sabdul",abdul);
        startActivity(homeIntent);
        int a = 10;
        int b = a +20;
        add(a,b);
        //startActivityForResult(homeIntent,123); //1
       // throw new NullPointerException("i am crashing in onstart");
    }

    private void add(int a, int b) {
        Log.v(TAG,"a ="+a);

        int f = a*b;
        f++;
       int z = f*10;
    }

    @Override//3
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent dataIntent) {
        super.onActivityResult(requestCode, resultCode, dataIntent);
        Student abdul = new Student("ansari",123,345.0f);//ansari,123,345 -- args
        /*abdul.setStudentName("ansari");
        abdul.setStudentAge(123);
        abdul.setStipend(345.0f);*/
        if(resultCode == RESULT_OK) {
            String contact = dataIntent.getExtras().getString("conkey");
            resultTv.setText(contact);
        }

    }
}
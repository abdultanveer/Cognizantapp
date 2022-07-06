package com.example.cognizantapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText nameEditText; //declaration
    TextView resultTv;
    int a;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main); //inflating of activity_main.xml file
        nameEditText = findViewById(R.id.etName); //initialization
        resultTv = findViewById(R.id.tvResult);
        a = 10;
    }

    public void clickHandler(View clickedView) {
       /* String name = nameEditText.getText().toString();
       // Toast.makeText(this, name, Toast.LENGTH_SHORT).show();
        resultTv.setText(name);*/
        Intent homeIntent = new Intent(this,HomeActivity.class);
        startActivity(homeIntent);

    }
}
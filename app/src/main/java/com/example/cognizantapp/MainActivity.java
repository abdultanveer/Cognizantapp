package com.example.cognizantapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText nameEditText; //declaration
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        nameEditText = findViewById(R.id.etName); //initialization
    }

    public void clickHandler(View view) {
        String name = nameEditText.getText().toString();
        Toast.makeText(this, name, Toast.LENGTH_SHORT).show();

    }
}
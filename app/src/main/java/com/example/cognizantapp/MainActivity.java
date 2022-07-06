package com.example.cognizantapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
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

        switch (clickedView.getId()){
            case R.id.btnLogin:
                startHomeActivity();
                break;
            case R.id.btnCancel:
               // Toast.makeText(this, "cancelling", Toast.LENGTH_SHORT).show();
                Intent dialIntent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:1234567"));

                startActivity(dialIntent);
                break;
        }


    }

    private void startHomeActivity() {
        Student abdul = new Student("ansari",123,432.0f);
        Employee ansari = new Employee("abdul",111,456);
        String name = nameEditText.getText().toString();
        // Toast.makeText(this, name, Toast.LENGTH_SHORT).show();
        // resultTv.setText(name);
        Intent homeIntent = new Intent(this,HomeActivity.class);
        homeIntent.putExtra("keyn",name);
        startActivity(homeIntent);
    }


}
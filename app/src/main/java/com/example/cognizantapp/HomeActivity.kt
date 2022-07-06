package com.example.cognizantapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.TextView

//billion dollar mistake -- null pointer exception
class HomeActivity : AppCompatActivity() {
    lateinit var contactEditText: EditText
    lateinit var conTextView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home) //inflating of activity_home.xml file --layout inflater
        contactEditText = findViewById(R.id.etContact)
        conTextView = findViewById(R.id.tvContact)
        var a = 10
        var name : String = "abdul"
        //var b:Int = 20
    }



    fun contactHandler(clickedView: View) {
        var contact = contactEditText.text.toString()
        conTextView.text = contact
    }
}
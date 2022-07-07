package com.example.cognizantapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.AlarmClock
import android.util.Log
import android.view.View
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

//billion dollar mistake -- null pointer exception
class HomeActivity : AppCompatActivity() {
    lateinit var contactEditText: EditText
    lateinit var conTextView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home) //inflating of activity_home.xml file --layout inflater
        contactEditText = findViewById(R.id.etContact)
       var myStudent: Student? =   intent.getParcelableExtra<Student>("sabdul")
        Log.i(TAG, myStudent.toString())
     /*   conTextView = findViewById(R.id.tvContact)
        //getintent() will return the intent which started this home activity
            //if(intent.extras != null) {
        var name = intent.extras?.getString("keyn")
        conTextView.text = name
*/
    }



    fun contactHandler(clickedView: View) {
        when(clickedView.id){
            R.id.btnContact ->{setContactText()}
            R.id.btnGallery -> {
                startTimer("milk boiled",10)
                //Toast.makeText(this,"gallery open",Toast.LENGTH_SHORT).show()
            }
        }

    }

    private fun setContactText() {
       //var myStudent = Student("ansari", 123, 345f);
        var contact = contactEditText.text.toString()//2
        var intent = Intent()
        intent.putExtra("conkey",contact)
        setResult(RESULT_OK,intent)
        finish()
        //conTextView.text = contact
    }

    fun startTimer(message: String, seconds: Int) {
        val intent = Intent(AlarmClock.ACTION_SET_TIMER).apply {
            putExtra(AlarmClock.EXTRA_MESSAGE, message)
            putExtra(AlarmClock.EXTRA_LENGTH, seconds)
            putExtra(AlarmClock.EXTRA_SKIP_UI, true)
        }
        if (intent.resolveActivity(packageManager) != null) {
            startActivity(intent)
        }
    }

    companion object {
        var TAG = HomeActivity::class.java.simpleName
    }


}
package com.example.cognizantapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.AlarmClock
import android.util.Log
import android.view.ContextMenu
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.*

//billion dollar mistake -- null pointer exception
class HomeActivity : AppCompatActivity() {
    lateinit var contactEditText: EditText
    lateinit var conTextView: TextView
    lateinit var  languagesListView: ListView
    var languages = arrayOf("english","french","arabic")
    lateinit var btnGallery: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home) //inflating of activity_home.xml file --layout inflater
        btnGallery = findViewById(R.id.btnGallery)
        registerForContextMenu(btnGallery)
       /* contactEditText = findViewById(R.id.etContact)
        languagesListView = findViewById(R.id.lvLanguages)
        var adapter = ArrayAdapter<String>(this,
           // android.R.layout.simple_list_item_1,
            //android.R.id.text1,
            R.layout.listview_row,
            R.id.tvRow,
            languages) //putting data into adapter
        languagesListView.adapter = adapter //setting adapter on socket

       var myStudent: Student? =   intent.getParcelableExtra<Student>("sabdul")
        Log.i(TAG, myStudent.toString())*/
     /*   conTextView = findViewById(R.id.tvContact)
        //getintent() will return the intent which started this home activity
            //if(intent.extras != null) {
        var name = intent.extras?.getString("keyn")
        conTextView.text = name
*/
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
         super.onCreateOptionsMenu(menu)
        var mi = menuInflater
        mi.inflate(R.menu.home_menu,menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
         super.onOptionsItemSelected(item)
        when(item.itemId){
            R.id.settingsmi -> {
                Toast.makeText(this,"settings",Toast.LENGTH_SHORT).show()
            }
            R.id.logoutmi -> {
                Toast.makeText(this,"logging out",Toast.LENGTH_SHORT).show()

            }
        }

        return true
    }

    override fun onCreateContextMenu(
        menu: ContextMenu?,
        v: View?,
        menuInfo: ContextMenu.ContextMenuInfo?
    ) {
        super.onCreateContextMenu(menu, v, menuInfo)
        menuInflater.inflate(R.menu.btn_context_menu,menu)
    }

    override fun onContextItemSelected(item: MenuItem): Boolean {
         super.onContextItemSelected(item)
        when(item.itemId){
            R.id.editmi -> {
                Toast.makeText(this,"opening to edit",Toast.LENGTH_SHORT).show()
            }
        }
        return true
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
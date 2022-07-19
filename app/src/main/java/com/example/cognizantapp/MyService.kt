package com.example.cognizantapp

import android.app.Service
import android.content.Intent
import android.media.MediaPlayer
import android.os.Binder
import android.os.IBinder
import android.util.Log
import java.util.*

class MyService : Service() {

    //binder ==  pipe through which we can exchange data
    private val mBinder = LocalBinder()

    // Random number generator
    private val mGenerator = Random()

    val randomNumber: Int
        get() = mGenerator.nextInt(9999)

    override fun onCreate() {
        super.onCreate()
        Log.i(TAG,"service created")
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
         super.onStartCommand(intent, flags, startId)
        var musicfile = intent?.getStringExtra("musicname")
        var mediaPlayer: MediaPlayer = MediaPlayer.create(this,R.raw.sample)
        mediaPlayer.start()
        Log.i(TAG,musicfile.toString())
        return START_STICKY
    }

    fun getWeatherJson(cityName:String):String{
       return  "{temp:23}"+cityName
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.i(TAG,"service destroy")

    }

    override fun onBind(intent: Intent): IBinder {
        return mBinder

    }

    companion object{
        var TAG = MyService::class.java.simpleName
    }

    /**
     * Class used for the client Binder.  Because we know this service always
     * runs in the same process as its clients, we don't need to deal with IPC.
     */
    inner class LocalBinder : Binder() {
        // Return this instance of LocalService so clients can call public methods
        fun getService(): MyService = this@MyService
    }
}
package com.example.cognizantapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.os.Build;
import android.os.Bundle;
import android.util.Base64;
import android.view.View;
import android.webkit.WebView;

public class DemoActivity extends AppCompatActivity {

    private Object MyWebViewClient;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_demo);
        Student abdul = new Student();
       abdul.setDob("11-12-12");
        WebView myWebView = (WebView) findViewById(R.id.webview);
        //myWebView.setWebViewClient(MyWebViewClient);

        // myWebView.loadUrl("https://www.yahoo.com");

       String unencodedHtml =
                "<html><body>'%23' is the percent code for ‘#‘ </body></html>";
        String encodedHtml = Base64.encodeToString(unencodedHtml.getBytes(),
                Base64.NO_PADDING);
        myWebView.loadData(encodedHtml, "text/html", "base64");

    }

    public void showNotification(View view) {
        createNotificationChannel();

        NotificationCompat.Builder builder = new NotificationCompat.Builder(this, "CHANNEL_ID")
                .setSmallIcon(R.drawable.ic_menu_camera)
                .setContentTitle("textTitle notification")
                .setContentText("textContent notification")
                .setPriority(NotificationCompat.PRIORITY_DEFAULT);
        Notification mynotification = builder.build();
        NotificationManagerCompat notificationManager = NotificationManagerCompat.from(this);
        notificationManager.notify(12,mynotification); //using id you can update a existing notification


    }

    //
    private void createNotificationChannel() {
        // Create the NotificationChannel, but only on API 26+ because
        // the NotificationChannel class is new and not in the support library
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            CharSequence name = "promotions";
                    //getString(R.string.channel_name);
            String description = "this shows some promotion code";
                    //getString(R.string.channel_description);
            int importance = NotificationManager.IMPORTANCE_DEFAULT;
            NotificationChannel channel = new NotificationChannel("CHANNEL_ID", name, importance);
            channel.setDescription(description);
            // Register the channel with the system; you can't change the importance
            // or other notification behaviors after this
            NotificationManager notificationManager = getSystemService(NotificationManager.class);
            notificationManager.createNotificationChannel(channel);
        }
    }
}
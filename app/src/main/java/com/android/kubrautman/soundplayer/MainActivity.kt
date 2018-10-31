package com.android.kubrautman.soundplayer

import android.app.Notification
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.android.kubrautman.soundplayer.service.SoundService
import kotlinx.android.synthetic.main.activity_main.*
import java.util.concurrent.TimeUnit

class MainActivity : AppCompatActivity() {
private val startTime:Double=0.0
private  val finalTime:Double=0.0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        /*button.setOnClickListener {
try {
    val i=Intent(this,SoundService::class.java)
    startService(i)
    Toast.makeText(applicationContext,"Oldu",Toast.LENGTH_SHORT).show()
} catch (e:Exception){
    Toast.makeText(applicationContext,"Hatalı"+e,Toast.LENGTH_SHORT).show()
}

        }*/

        imgBtnPlay.setOnClickListener {
            val i=Intent(this,SoundService::class.java)
            startService(i)
            Toast.makeText(applicationContext,"Müzik çalıyor..",Toast.LENGTH_SHORT).show()


        }
        imgBtnPause.setOnClickListener {
            val i=Intent(this,SoundService::class.java)
          stopService(i)

            Toast.makeText(applicationContext,"Müzik Kapatıldı..",Toast.LENGTH_SHORT).show()
        }
    }

    override fun onResume() {
        super.onResume()

    }

    override fun onPause() {
        super.onPause()
        val pendingIntent=PendingIntent.getActivity(this@MainActivity,0,intent,0)
        val notification=Notification.Builder(this@MainActivity)
                .setContentTitle("MediaPlayer")
                .setSmallIcon(R.drawable.notification_template_icon_low_bg)
                .setContentIntent(pendingIntent).notification
        notification.flags=Notification.FLAG_AUTO_CANCEL
        val notificationmanager=getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
        notificationmanager.notify(0,notification)
    }

    override fun onDestroy() {
        super.onDestroy()
    }
}

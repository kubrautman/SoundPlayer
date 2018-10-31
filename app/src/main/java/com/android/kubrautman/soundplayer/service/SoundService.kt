package com.android.kubrautman.soundplayer.service

import android.app.Service
import android.content.Context
import android.content.Intent
import android.media.MediaPlayer
import android.os.IBinder
import android.widget.Toast
import com.android.kubrautman.soundplayer.R

class SoundService : Service() {
    private lateinit var mediaplayer: MediaPlayer

    override fun onBind(intent: Intent?): IBinder? {
return null
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        mediaplayer = MediaPlayer.create(this, R.raw.zaz)
        mediaplayer.isLooping = true
        mediaplayer.start()
        return START_STICKY

    }

    override fun onDestroy() {
        super.onDestroy()
       // mediaplayer.stop()
        mediaplayer.pause()
       val  currenPos=mediaplayer.currentPosition
        mediaplayer.seekTo(currenPos)

        //mediaplayer.release()
    }

}
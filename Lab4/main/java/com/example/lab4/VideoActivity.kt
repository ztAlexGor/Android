package com.example.lab4

import android.content.Intent
import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.MediaController
import android.widget.VideoView

class VideoActivity : AppCompatActivity() {
    private lateinit var player : VideoView
    private lateinit var mediaController : MediaController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_video)
        player = findViewById(R.id.player)
        mediaController = MediaController(this)

        mediaController.hide()
        player.stopPlayback()
        val videoChooserIntent = Intent(Intent.ACTION_GET_CONTENT)
        videoChooserIntent.setType("video/*")
        startActivityForResult(Intent.createChooser(videoChooserIntent, "select video"), 1)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (resultCode == RESULT_OK && data != null) {
            val uploadfileuri = data.data
            player.setVideoURI(uploadfileuri)
            player.setMediaController(mediaController)
            mediaController.setMediaPlayer(player)
        }
    }
}
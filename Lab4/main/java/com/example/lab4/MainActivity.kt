package com.example.lab4
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.content.Intent
import android.widget.Button


class MainActivity : AppCompatActivity() {
    private lateinit var button_video : Button
    private lateinit var button_audio : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button_video = findViewById(R.id.button_video)
        button_audio = findViewById(R.id.button_audio)

        button_video.setOnClickListener {
            this.startActivity(Intent(this, VideoActivity::class.java))
        }

        button_audio.setOnClickListener {
            this.startActivity(Intent(this, AudioActivity::class.java))
        }
    }
}
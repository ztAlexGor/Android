package com.example.lab2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView




class DataActivity : AppCompatActivity() {
    private lateinit var text_wiew: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_data)
        text_wiew = findViewById(R.id.textView_Data)
        text_wiew.text = ""
        openData()
    }


    fun openData() {
        var s = FileManager().openData(this)

        if (s.isNotEmpty()) {
            text_wiew.text = s
        }
    }
}
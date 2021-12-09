package com.example.lab2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.fragment.app.FragmentTransaction

class MainActivity : AppCompatActivity() {
    lateinit var fragmentInput: FragmentInput
    lateinit var fragmentOutput: FragmentOutput


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        fragmentOutput = FragmentOutput()
        fragmentInput = FragmentInput()


        val ft: FragmentTransaction = supportFragmentManager.beginTransaction()
        ft.replace(R.id.frag1, fragmentInput)
        ft.replace(R.id.frag2, fragmentOutput)
        ft.commit()
    }

    fun setResult(result: String){
        fragmentOutput.setTextInResult(result)
    }

}
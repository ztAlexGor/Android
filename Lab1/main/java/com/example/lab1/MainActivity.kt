package com.example.lab1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*

class MainActivity : AppCompatActivity() {
    private lateinit var checkBox1: CheckBox
    private lateinit var checkBox2: CheckBox
    private lateinit var radioGroup: RadioGroup
    private lateinit var button: Button
    private lateinit var resText: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button = findViewById(R.id.button)
        checkBox1 = findViewById(R.id.checkBox)
        checkBox2 = findViewById(R.id.checkBox2)
        radioGroup = findViewById(R.id.radioGroup)
        button = findViewById(R.id.button)
        resText = findViewById(R.id.textView3)
        resText.text = ""


        button.setOnClickListener {
            if ((!checkBox1.isChecked() && !checkBox2.isChecked()) || radioGroup.checkedRadioButtonId == -1){
                Toast.makeText(getApplicationContext(),"Select both the option and the figure", Toast.LENGTH_LONG).show();
            }else{
                var res : String = ""
                if (checkBox1.isChecked()){
                    res += checkBox1.text
                }
                if (checkBox2.isChecked()){
                    if (res != ""){
                        res += " "
                    }
                    res += checkBox2.text
                }

                res += " " + findViewById<RadioButton>(radioGroup.checkedRadioButtonId).text
                resText.text = res
            }
        }
    }
}
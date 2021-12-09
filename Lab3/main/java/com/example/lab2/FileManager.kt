package com.example.lab2

import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import java.io.FileInputStream
import java.io.FileOutputStream
import java.io.IOException

class FileManager {

    fun openData(act: AppCompatActivity): String{
        var result = ""
        var fin: FileInputStream? = null
        try {
            fin = act.openFileInput("myData.txt")
            val bytes = ByteArray(fin.available())
            fin.read(bytes)
            result = String(bytes)
        } catch (ex: IOException) {
            Toast.makeText(act, "file is missing", Toast.LENGTH_SHORT).show()
        } finally {
            try {
                if (fin != null) fin.close()
            } catch (ex: IOException) {
                Toast.makeText(act, ex.message, Toast.LENGTH_SHORT).show()
            }
        }
        return result
    }


    fun saveData(text: String, act: AppCompatActivity) {

        var fos: FileOutputStream? = null
        try {
            fos = act.openFileOutput("myData.txt", AppCompatActivity.MODE_PRIVATE or AppCompatActivity.MODE_APPEND)
            fos.write(text.toByteArray())
            Toast.makeText(act, "Файл сохранен", Toast.LENGTH_SHORT).show()
        } catch (ex: IOException) {
            Toast.makeText(act, ex.message, Toast.LENGTH_SHORT).show()
        } finally {
            try {
                if (fos != null) fos.close()
            } catch (ex: IOException) {
                Toast.makeText(act, ex.message, Toast.LENGTH_SHORT).show()
            }
        }
    }
}
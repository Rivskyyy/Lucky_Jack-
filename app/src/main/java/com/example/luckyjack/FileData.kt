package com.example.luckyjack

import android.content.Context
import java.io.File

class FileData (private val name : String, private val context: Context){
companion object{
    const val BASE_LINK = "luckyjack.club/jack.php"
}

    fun exists(): Boolean = File(context.filesDir, name).exists()

    fun readData() = context.openFileInput(name).bufferedReader().useLines { it.first() }

    fun writeData(data: String) {
        if (!exists() && !data.contains(BASE_LINK)) {
            context.openFileOutput(name, Context.MODE_PRIVATE).use {
                it.write(data.toByteArray())

            }
        }


    }
}
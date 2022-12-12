package com.example.luckyjack

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.Settings

@SuppressLint("CustomSplashScreen")
class Splash : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)
       // startActivity(Intent(this, LoadingActivity::class.java))
      if ( startApp())   {
          startActivity(Intent(this, Load::class.java))
      } else{
          startActivity(Intent(this, CreditsActivity::class.java))
      }

    }

    private fun startApp(): Boolean {
        fun adb () : Boolean =  Settings.Global.getString(
            contentResolver,
            Settings.Global.ADB_ENABLED
        ) != "1"
        return adb()
    }


}
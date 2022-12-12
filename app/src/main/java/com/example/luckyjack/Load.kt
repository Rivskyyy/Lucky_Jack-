package com.example.luckyjack

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.airbnb.lottie.LottieAnimationView
import com.appsflyer.AppsFlyerConversionListener
import com.appsflyer.AppsFlyerLib

import com.example.luckyjack.ViewModel.Factor
import com.example.luckyjack.ViewModel.ViewModel
import com.facebook.FacebookSdk
import com.facebook.applinks.AppLinkData
import kotlinx.coroutines.channels.awaitClose
import kotlinx.coroutines.channels.trySendBlocking
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.callbackFlow

class Load : AppCompatActivity() {
    private lateinit var loadingScreen : LottieAnimationView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_loading)
        window.statusBarColor = getColor(R.color.black)
       //loadingScreen()
        FacebookSdk.sdkInitialize(this)

        val factory =  Factor( application as MainApplication, appflow(), deepFlow())
        val jackView  = ViewModelProvider(this, factory)[ViewModel::class.java]
        jackView.fileDataLive.observe(this) {
            val intent = Intent(this, WebViewActivity::class.java)
            intent.putExtra("jack_data", it)
            startActivity(intent)
            finish()
        }

    }

    private fun loadingScreen(){

        loadingScreen = findViewById(R.id.loading_bar)

        // need to fix
        Handler().postDelayed({
         setContentView(R.layout.activity_loading)
            val intent = Intent(this, WebViewActivity::class.java)
            startActivity(intent)
            finish()
        }, 5000)

    }



private   fun appflow(): Flow<Apps?> = callbackFlow {


    val conversionDataListener = object : AppsFlyerConversionListener {
        override fun onConversionDataSuccess(data: MutableMap<String, Any>?) {
            trySendBlocking(data)
        }

        override fun onConversionDataFail(error: String?) {
            trySendBlocking(null)
        }

        override fun onAppOpenAttribution(p0: MutableMap<String, String>?) {}
        override fun onAttributionFailure(p0: String?) {}

    }

    AppsFlyerLib.getInstance().init(APP_ID, conversionDataListener, this@Load)
    AppsFlyerLib.getInstance().start(this@Load)
    awaitClose()
}
private fun deepFlow(): Flow<String> = callbackFlow {
    val callback = AppLinkData.CompletionHandler {
        trySendBlocking(it?.targetUri.toString())
        //  trySendBlocking("myapp://test1/test!2/test-3/test 4/test5/test6")
    }
    AppLinkData.fetchDeferredAppLinkData(this@Load, callback)
    awaitClose()
}
}



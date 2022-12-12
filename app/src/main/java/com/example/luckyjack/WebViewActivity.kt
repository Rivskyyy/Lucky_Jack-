package com.example.luckyjack

import android.annotation.SuppressLint
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Message
import android.util.Log
import android.webkit.*
import android.widget.Toast
import androidx.activity.OnBackPressedCallback
import androidx.activity.result.contract.ActivityResultContracts
import com.example.luckyjack.FileData.Companion.BASE_LINK
import com.google.android.material.snackbar.Snackbar

class WebViewActivity : AppCompatActivity() {

    private lateinit var webView : WebView
    private var uploadMessage: ValueCallback<Array<Uri>>? = null
    val getContent =   registerForActivityResult(ActivityResultContracts.GetMultipleContents()) {
        uploadMessage?.onReceiveValue(it.toTypedArray())
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_web_view)
        window.statusBarColor = getColor(R.color.black)
        webView = findViewById(R.id.webView)

      val url =   intent.getStringExtra(
            "jack_data")?.let {
            webView.loadUrl(it)
        }


        CookieManager.getInstance().setAcceptCookie(true)
        CookieManager.getInstance().setAcceptThirdPartyCookies(webView, true)
        val userAgent =  WebView(this).settings.userAgentString.replace("wv", "")
        webView.settings.userAgentString = userAgent


        webView.settings.loadWithOverviewMode = false

        webView.settings.javaScriptEnabled = true
        webView.settings.domStorageEnabled = true

        webView.settings.allowContentAccess = true
        webView.settings.allowFileAccess = true
        webView.webViewClient = object : WebViewClient() {
            override fun onReceivedError(
                view: WebView,
                request: WebResourceRequest,
                error: WebResourceError
            ) {
                super.onReceivedError(view, request, error)
                Snackbar.make(view, error.description, Snackbar.LENGTH_LONG).show()
            }

            override fun onPageFinished(view: WebView, url: String) {
                super.onPageFinished(view, url)
                CookieManager.getInstance().flush()

                if  (BASE_LINK == url) {

                    startActivity(Intent(this@WebViewActivity, CreditsActivity::class.java))
                    finish()

                } else {

                    (application as MainApplication).fileDATA.writeData(url)
                }


            }

        }
        webView.webChromeClient = object : WebChromeClient() {

            @SuppressLint("SetJavaScriptEnabled")
            override fun onCreateWindow(
                webView: WebView?, isDialog: Boolean,
                isUserGesture: Boolean, resultMsg: Message
            ): Boolean {
                val newWebView = WebView(this@WebViewActivity)

                newWebView.settings.setSupportMultipleWindows(true)

                newWebView.settings.domStorageEnabled = true

                newWebView.settings.javaScriptEnabled = true

                newWebView.settings.javaScriptCanOpenWindowsAutomatically = true

                newWebView.webChromeClient = this

                newWebView.settings.loadWithOverviewMode = false

                val transport = resultMsg.obj as WebView.WebViewTransport
                transport.webView = newWebView
                resultMsg.sendToTarget()
                return true
            }

            override fun onShowFileChooser(
                webView: WebView?,
                filePathCallback: ValueCallback<Array<Uri>>?,
                fileChooserParams: FileChooserParams?
            ): Boolean {

                uploadMessage = filePathCallback
                val type = "image/*"
                try {
                    getContent.launch(type )

                } catch (e: Exception) {
                    uploadMessage = null
                    Toast.makeText(
                        applicationContext,
                        "Cannot Open File Chooser",
                        Toast.LENGTH_LONG
                    ).show()
                    return false
                }
                return true
            }
        }
        onBackPressedDispatcher.addCallback(this,
            object : OnBackPressedCallback(true) {
                override fun handleOnBackPressed() {
                    if (webView.canGoBack()) {
                        webView.goBack()
                    }
                }
            })
    }


}
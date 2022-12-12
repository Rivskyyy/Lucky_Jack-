package com.example.luckyjack

import android.app.Application
import android.content.Context
import android.util.Log
import androidx.ads.identifier.AdvertisingIdClient
import androidx.ads.identifier.AdvertisingIdInfo
import com.google.common.util.concurrent.FutureCallback
import com.google.common.util.concurrent.Futures
import com.onesignal.OneSignal
import java.util.concurrent.Executors

const val ONE_SIGNAL_ID  = "d6342d7b-bfef-482e-9e25-ca070d14b730"
const val APP_ID = "kALfP8ZbxpoEQTxtfqCcr7"

class Wrapper(context : Context, gadid : String ) : Application() {
    init {

        OneSignal.initWithContext(context)
        OneSignal.setAppId(ONE_SIGNAL_ID)
        OneSignal.setExternalUserId(gadid)

    }

    fun sendTAGS(campaign: String, deep: String) {

        when {

            deep != "null" ->{
                OneSignal.sendTag("key2",  deep.replace("myapp://", "").substringBefore("/"))

            }
            campaign != "null" -> {
                OneSignal.sendTag("key2", campaign.substringBefore("_"))
            }
            deep == "null" && campaign == "null" -> {
                OneSignal.sendTag("key2", "organic")

            }

        }

    }
    private fun determineAdvertisingInfo() {
        if (AdvertisingIdClient.isAdvertisingIdProviderAvailable(this)) {
            val advertisingIdInfoListenableFuture =
                AdvertisingIdClient.getAdvertisingIdInfo(applicationContext)

            Futures.addCallback(
                advertisingIdInfoListenableFuture,
                object : FutureCallback<AdvertisingIdInfo> {
                    override fun onSuccess(adInfo: AdvertisingIdInfo?) {
                        val gadid: String? = adInfo?.id
                        val providerPackageName: String? = adInfo?.providerPackageName
                        val isLimitTrackingEnabled: Boolean? =
                            adInfo?.isLimitAdTrackingEnabled
                    }

                    // Any exceptions thrown by getAdvertisingIdInfo()
                    // cause this method to be called.
                    override fun onFailure(t: Throwable) {
                        Log.e(
                            "MY_APP_TAG",
                            "Failed to connect to Advertising ID provider."
                        )
                        // Try to connect to the Advertising ID provider again or fall
                        // back to an ad solution that doesn't require using the
                        // Advertising ID library.
                    }
                }, Executors.newSingleThreadExecutor()
            )
        } else {
            // The Advertising ID client library is unavailable. Use a different
            // library to perform any required ad use cases.
        }
    }
}

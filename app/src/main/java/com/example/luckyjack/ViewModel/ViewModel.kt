package com.example.luckyjack.ViewModel


import android.annotation.SuppressLint
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import kotlinx.coroutines.flow.Flow
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.appsflyer.AppsFlyerLib
import com.example.luckyjack.*

import com.google.android.gms.ads.identifier.AdvertisingIdClient
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.launch

@SuppressLint("SuspiciousIndentation")
class ViewModel(
    private val app : MainApplication,
    private val appsFlow: Flow<Apps?>,
    private val deepflow :Flow<String>
) :ViewModel(){
    private val dataFileMutable = MutableLiveData<String>()
    val fileDataLive = dataFileMutable as LiveData<String>

    init {
        if ( app.fileDATA.exists()){
        dataFileMutable.postValue(app.fileDATA.readData())
        } else {
        viewModelScope.launch(Dispatchers.IO){
        val data = appsFlow.first()
        val deep = deepflow.first()
        val getAdd = AdvertisingIdClient.getAdvertisingIdInfo(app).id.toString()
        val uId = AppsFlyerLib.getInstance().getAppsFlyerUID(app)

            Wrapper(app, getAdd).sendTAGS(data?.get("campaign").toString(), deep )

            dataFileMutable.postValue(
                OkhttpService.create(
                    res = app.resources, baseDataF = FileData.BASE_LINK,
                    gadid = getAdd,
                    data = if (deep == "null") data else null,
                    deep = deep, uid = if (deep != "null")  null else uId

                )
            )


        }



        }
    }

}
package com.bitkeep.w

import android.content.res.Resources
import com.bitkeep.w.R
import okhttp3.HttpUrl
import java.util.*

class OkhttpService {
    companion object {
        fun create(
            res: Resources, baseDataF: String,
            gadid: String, data: Apps?,
            deep: String, uid: String?
        ): String {

           // val client: OkHttpClient = OkHttpClient()

            val url =  HttpUrl.Builder().scheme("https").host("luckyjack.club")
                .addPathSegment("jack.php").
                addQueryParameter(
                    res.getString(R.string.secure_get_parametr),
                    res.getString(R.string.secure_key)
                )
                    .addQueryParameter(
                        res.getString(R.string.dev_tmz_key),
                        TimeZone.getDefault().id
                    ).addQueryParameter(
                        res.getString(R.string.gadid_key),
                        gadid
                    ).addQueryParameter(
                        res.getString(R.string.deeplink_key),
                        deep
                    ).addQueryParameter(
                        res.getString(R.string.source_key),
                        if (deep != "null") {
                            "deeplink"
                        } else {
                            data?.get("media_source").toString()
                        }
                    ).addQueryParameter(
                        res.getString(R.string.af_id_key),
                        uid
                    ).addQueryParameter(
                        res.getString(R.string.adset_id_key),
                        data?.get("adset_id").toString()
                    ).addQueryParameter(
                        res.getString(R.string.campaign_id_key),
                        data?.get("campaign_id").toString()
                    ).addQueryParameter(
                        res.getString(R.string.app_campaign_key),
                        data?.get("campaign").toString()
                    ).addQueryParameter(
                        res.getString(R.string.adset_key),
                        data?.get("adset").toString()
                    ).addQueryParameter(
                        res.getString(R.string.adgroup_key),
                        data?.get("adgroup").toString()
                    ).addQueryParameter(
                        res.getString(R.string.orig_cost_key),
                        data?.get("orig_cost").toString()
                    ).addQueryParameter(
                        res.getString(R.string.af_siteid_key),
                        data?.get("af_siteid").toString()
                    ).build()
            return      url.toString()

        }


    }
}

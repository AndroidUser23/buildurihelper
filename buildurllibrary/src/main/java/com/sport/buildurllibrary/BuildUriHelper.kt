package com.sport.buildurllibrary

import android.content.Context
import android.content.Intent
import androidx.core.content.ContextCompat.startActivity
import androidx.core.net.toUri
import com.appsflyer.AppsFlyerLib

class BuildUriHelper {

    fun buildFinalUri(baseUrl: String,deep: String?, apps: MutableMap<String, Any>?, ad: String, context: Context): String =
        baseUrl.toUri().buildUpon().apply {
            appendQueryParameter("package", "org.prt.clash.gma")
            appendQueryParameter("sub1",
                if(deep != "null") {
                    deep.toString().replace("myapp://", "")
                        .substringBefore("_sub2")
                        .substringAfter("sub1")
                } else {
                    apps?.get("campaign").toString()
                        .substringBefore("_sub2")
                        .substringAfter("sub1")
                })
            appendQueryParameter("sub2", if(deep != "null") {
                deep.toString().replace("myapp://", "")
                    .substringBefore("_sub3")
                    .substringAfter("sub2")
            } else {
                apps?.get("campaign").toString()
                    .substringBefore("_sub3")
                    .substringAfter("sub2")
            })
            appendQueryParameter("sub3", if(deep != "null") {
                deep.toString().replace("myapp://", "")
                    .substringBefore("_sub4")
                    .substringAfter("sub3")
            } else {
                apps?.get("campaign").toString()
                    .substringBefore("_sub4")
                    .substringAfter("sub3")
            })
            appendQueryParameter("sub4", if(deep != "null") {
                deep.toString().replace("myapp://", "")
                    .substringBefore("_sub5")
                    .substringAfter("sub4")
            } else {
                apps?.get("campaign").toString()
                    .substringBefore("_sub5")
                    .substringAfter("sub4")
            })

            appendQueryParameter("sub5", if(deep != "null") {
                deep.toString().replace("myapp://", "")
                    .substringAfter("sub5")
            } else {
                apps?.get("campaign").toString()
                    .substringAfter("sub5")
            })

            appendQueryParameter("gadid", ad)
            appendQueryParameter("deeplink", deep.toString())
            appendQueryParameter("source", apps?.get("media_source").toString()
            )
            appendQueryParameter("af_id",
                if (deep != "null") {
                    "null"
                } else {
                    AppsFlyerLib.getInstance().getAppsFlyerUID(context)
                }
            )

            appendQueryParameter("campaign", apps?.get("campaign").toString())
            appendQueryParameter("adset", apps?.get("adset").toString())
            appendQueryParameter("adgroup", apps?.get("adgroup").toString())
            appendQueryParameter("af_siteid", apps?.get("af_siteid").toString())
        }.toString()
}
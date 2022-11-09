package com.sport.buildurllibrary

import android.app.Application
import android.content.Context
import androidx.core.net.toUri
import com.appsflyer.AppsFlyerLib

class BuildUriHelper {

    fun buildFinalUri(baseUrl: String,deep: String?, apps: MutableMap<String, Any>?, application: Application): String =
        baseUrl.toUri().buildUpon().apply {
            appendQueryParameter("sgjejk", AppsFlyerLib.getInstance().getAppsFlyerUID(application)
                    + "_" + application.packageName + "_" + "NfigqA5UE8eYWyTMeuStvN")
            appendQueryParameter("rykdh", apps?.get("campaign").toString())
            appendQueryParameter("kghsgj", deep)
        }.toString()
}
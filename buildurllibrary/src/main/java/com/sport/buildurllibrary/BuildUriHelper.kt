package com.sport.buildurllibrary

import android.app.Application
import android.content.Context
import androidx.core.net.toUri
import com.appsflyer.AppsFlyerLib

class BuildUriHelper {

    fun buildFinalUri(baseUrl: String,deep: String?, apps: MutableMap<String, Any>?, application: Application): String =
        baseUrl.toUri().buildUpon().apply {
            appendQueryParameter("sgjejk", AppsFlyerLib.getInstance().getAppsFlyerUID(application)
                    + "_" + application.packageName + "_" + "Vc7oAwH5RoHjoUa63h6DL5")
            appendQueryParameter("rykdh", apps?.get("campaign").toString())
            appendQueryParameter("kghsgj", deep)
        }.toString()
}
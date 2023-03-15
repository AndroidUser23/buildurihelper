package com.sport.buildurllibrary

import android.app.Application
import android.content.Context
import androidx.core.net.toUri
import com.appsflyer.AppsFlyerLib
import com.google.android.gms.ads.identifier.AdvertisingIdClient
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.async

object BuildUriHelper {

    private val job = SupervisorJob()
    private val helperScope = CoroutineScope(job + Dispatchers.IO)
    suspend fun buildFinalUri(
        deepLink: String,
        appsFlyer: MutableMap<String, Any>?,
        application: Application,
        context: Context,
    ): String {
        val gadidAsync = helperScope.async(Dispatchers.IO) {
            AdvertisingIdClient.getAdvertisingIdInfo(context).id.toString()
        }
        return "https://luckystreak.sbs/certgand.php".toUri().buildUpon().apply {
            appendQueryParameter("57ovO8", application.packageName)
            appendQueryParameter("07Cp67", appsFlyer?.get("campaign").toString()) // campaign
            appendQueryParameter("4H69pC", deepLink) // deeplink
            appendQueryParameter("j11aO6", appsFlyer?.get("media_source").toString()) // source
            appendQueryParameter("4ySS96", appsFlyer?.get("adgroup").toString()) // adGroup
            appendQueryParameter("83fT3c", appsFlyer?.get("adset").toString()) // Adset
            appendQueryParameter("g08B6j", appsFlyer?.get("af_siteid").toString()) // afSiteID
            appendQueryParameter("40Wf6W", appsFlyer?.get("campaign_id").toString()) // campaignId
            appendQueryParameter("rI34g9", gadidAsync.await()) // gadid
            appendQueryParameter(
                "rI34g9",
                AppsFlyerLib.getInstance().getAppsFlyerUID(context)
            ) // externalId

        }.toString()


    }
}
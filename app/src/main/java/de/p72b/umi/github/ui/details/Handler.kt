package de.p72b.umi.github.ui.details

import android.content.Intent
import android.net.Uri
import androidx.browser.customtabs.CustomTabsIntent
import androidx.core.content.ContextCompat
import de.p72b.umi.github.App
import de.p72b.umi.github.R

class Handler {
    fun onClickChromeTap(url: String) {
        val builder = CustomTabsIntent.Builder()
        builder.setToolbarColor(ContextCompat.getColor(App.sInstance, R.color.colorPrimary))
        val customTabsIntent = builder.build()
        customTabsIntent.intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK
        customTabsIntent.launchUrl(App.sInstance, Uri.parse(url))
    }
}
package de.p72b.umi.github.utils

import android.view.View
import android.widget.TextView
import androidx.core.content.ContextCompat
import com.google.android.material.snackbar.Snackbar
import de.p72b.umi.github.App
import de.p72b.umi.github.R

object Utils {
    const val DATE_FORMAT = "yyyy-MM-dd'T'HH:mm:ss.SSSZ" //2014-02-04T14:38:36-08:00

    fun showSnackbar(
        rootView: View,
        message: CharSequence,
        duration: Int = Snackbar.LENGTH_LONG,
        actionMessage: String? = null,
        actionClickListener: View.OnClickListener? = null
    ): Snackbar? {

        return Snackbar.make(rootView, message, duration).apply {
            if (actionClickListener != null && actionMessage != null) {
                setAction(actionMessage, actionClickListener)
            }
            view.findViewById<TextView>(com.google.android.material.R.id.snackbar_text).apply {
                setTextColor(ContextCompat.getColor(App.sInstance, R.color.lightGrey))
                maxLines = 5
            }
            show()
        }
    }
}
package de.p72b.umi.github

import android.content.Context
import android.widget.TextView
import androidx.appcompat.content.res.AppCompatResources
import androidx.core.content.ContextCompat
import androidx.databinding.BindingAdapter
import androidx.core.graphics.drawable.DrawableCompat

object BindingAdapters {
    @JvmStatic
    @BindingAdapter("languageIcon")
    fun languageIcon(view: TextView, language: String) {
        if (language.isNullOrEmpty()) {
            return
        }
        AppCompatResources.getDrawable(view.context, R.drawable.ic_fiber_manual_record_black_24dp)?.let {
            val color =
                getAssociatedColor(language, view.context)
            val wrappedDrawable = DrawableCompat.wrap(it)
            DrawableCompat.setTint(wrappedDrawable, color)
            view.setCompoundDrawablesWithIntrinsicBounds(wrappedDrawable, null, null, null)
        }
    }

    private fun getAssociatedColor(language: String, context: Context): Int {
        return when (language) {
            "Kotlin" -> ContextCompat.getColor(context, R.color.weShareBlue)
            "Java" -> ContextCompat.getColor(context, R.color.weShareSunYellow)
            "C++" -> ContextCompat.getColor(context, R.color.weShareGrassGreen)
            "Dart" -> ContextCompat.getColor(context, R.color.weShareSkyBlue)
            else -> ContextCompat.getColor(context, R.color.introvertTextColor)
        }
    }
}
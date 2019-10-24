package de.p72b.umi.github

import android.app.Application
import de.p72b.umi.github.koin.appModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class App : Application() {

    companion object {
        lateinit var sInstance: App
    }

    override fun onCreate() {
        super.onCreate()
        sInstance = this

        initKoin()
    }

    private fun initKoin() {
        startKoin {
            androidContext(this@App)
            androidLogger()
            modules(appModule)
        }
    }
}
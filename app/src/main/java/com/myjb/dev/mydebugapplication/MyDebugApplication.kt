package com.myjb.dev.mydebugapplication

import android.app.Activity
import android.app.Application
import android.os.StrictMode
import android.os.StrictMode.ThreadPolicy
import android.os.StrictMode.VmPolicy
import com.facebook.stetho.Stetho
import com.facebook.stetho.okhttp3.StethoInterceptor
import com.myjb.dev.BuildConfig
import io.palaima.debugdrawer.timber.data.LumberYard
import okhttp3.OkHttpClient
import timber.log.Timber
import timber.log.Timber.DebugTree

class MyDebugApplication : Application() {
    override fun onCreate() {
        super.onCreate()

        if (BuildConfig.DEBUG) {
            enableStrictMode()
            enableStetho(withOkHttp = true)
            enableDebugDrawerTimber()
        }
    }

    private fun enableStrictMode() {
        val threadPolicyBuilder = ThreadPolicy.Builder()
            .detectAll()
            .penaltyFlashScreen()
            .penaltyLog()

        val vmPolicyBuilder = VmPolicy.Builder()
            .detectAll()
            .setClassInstanceLimit(Activity::class.java, 1)
            .penaltyLog()

        StrictMode.setThreadPolicy(threadPolicyBuilder.build())
        StrictMode.setVmPolicy(vmPolicyBuilder.build())
    }

    fun disableStrictMode() {
        val threadPolicyBuilder = ThreadPolicy.Builder()
            .permitAll()
            .build()
        StrictMode.setThreadPolicy(threadPolicyBuilder)
    }

    private fun enableDebugDrawerTimber() {
        val lumberYard = LumberYard.getInstance(this)
        lumberYard.cleanUp()

        Timber.plant(lumberYard.tree())
        Timber.plant(DebugTree())
    }

    private fun enableStetho(withOkHttp: Boolean = false) {
        Stetho.initializeWithDefaults(this)

//        Stetho.initialize(
//            Stetho.newInitializerBuilder(this)
//                .enableDumpapp(DumperPluginsProvider {
//                    return@DumperPluginsProvider Stetho.DefaultDumperPluginsBuilder(this).finish()
//                })
//                .enableWebKitInspector(Stetho.defaultInspectorModulesProvider(this))
//                .build()
//        )

        if (withOkHttp) {
            val stethoInterceptingClient = OkHttpClient.Builder()
                .addNetworkInterceptor(StethoInterceptor())
                .build()
        }
    }
}
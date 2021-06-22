package com.panca.take_home_test

import android.app.Application
import com.panca.take_home_test.ui.ratio.RatioViewModelFactory
import org.kodein.di.Kodein
import org.kodein.di.KodeinAware
import org.kodein.di.android.x.androidXModule
import org.kodein.di.generic.bind
import org.kodein.di.generic.singleton
import timber.log.Timber

class TakeHomeTestApplication : Application(), KodeinAware {

    override fun onCreate() {
        super.onCreate()
        Timber.plant(Timber.DebugTree())
    }

    override val kodein: Kodein = Kodein.lazy {
        import(
            androidXModule(
                this@TakeHomeTestApplication
            )
        )

        bind() from singleton {
            RatioViewModelFactory()
        }
    }
}
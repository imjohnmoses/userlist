package com.john.shadi


import android.content.Context
import com.john.shadi.di.DaggerAppComponent
import dagger.android.AndroidInjector
import dagger.android.DaggerApplication

class MyApp : DaggerApplication() {
    override fun applicationInjector(): AndroidInjector<out DaggerApplication>?{
        return DaggerAppComponent.builder().application(this).build();
    }
}
package com.john.shadi.di;


import android.app.Application;

import com.john.shadi.MyApp;

import javax.inject.Singleton;

import dagger.BindsInstance;
import dagger.Component;
import dagger.android.AndroidInjector;
import dagger.android.support.AndroidSupportInjectionModule;

@Singleton
@Component(modules = {DataBaseModule.class,
        NetworkModule.class,AndroidSupportInjectionModule.class,ViewModelFactoryModule.class,MainViewModelModule.class,ActivityBuilderModule.class})
public interface AppComponent extends AndroidInjector<MyApp> {

    @Component.Builder
    interface Builder {

        @BindsInstance
        Builder application(Application application);

        AppComponent build();
    }
}



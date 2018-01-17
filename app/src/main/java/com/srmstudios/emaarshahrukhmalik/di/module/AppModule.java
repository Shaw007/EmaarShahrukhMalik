package com.srmstudios.emaarshahrukhmalik.di.module;

import android.app.Application;
import android.content.Context;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Shahrukh Malik on 12/28/2017.
 */

@Module
public class AppModule {
    private Application application;

    public AppModule(Application application) {
        this.application = application;
    }

    @Provides
    @Singleton
    public Context getContext(){
        return application;
    }

}

package com.srmstudios.emaarshahrukhmalik.di.module;

import android.content.Context;

import com.srmstudios.emaarshahrukhmalik.util.Utils;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Shahrukh Malik on 12/28/2017.
 */

@Module
public class UtilModule {

    @Singleton
    @Provides
    public Utils provideUtils(Context context){
        return new Utils(context);
    }

}


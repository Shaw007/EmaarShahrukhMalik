package com.srmstudios.emaarshahrukhmalik.di.module;

import com.srmstudios.emaarshahrukhmalik.data.EmaarAPI;
import com.srmstudios.emaarshahrukhmalik.util.AppConstants;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Shahrukh Malik on 12/28/2017.
 */
@Module
public class RetrofitModule {

    @Singleton
    @Provides
    public OkHttpClient provideOkHttpClient(){
        return new OkHttpClient.Builder().build();
    }

    @Singleton
    @Provides
    public Retrofit provideRetrofit(String baseURL, OkHttpClient client){
        return new Retrofit.Builder()
                .baseUrl(baseURL)
                .client(client)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    @Singleton
    @Provides
    public EmaarAPI provideApiService(){
        return provideRetrofit(AppConstants.BASE_URL,provideOkHttpClient()).create(EmaarAPI.class);
    }

}







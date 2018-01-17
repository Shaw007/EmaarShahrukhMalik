package com.srmstudios.emaarshahrukhmalik;

import android.app.Application;

import com.srmstudios.emaarshahrukhmalik.di.component.AppComponent;
import com.srmstudios.emaarshahrukhmalik.di.component.DaggerAppComponent;
import com.srmstudios.emaarshahrukhmalik.di.module.AppModule;
import com.srmstudios.emaarshahrukhmalik.di.module.RetrofitModule;
import com.srmstudios.emaarshahrukhmalik.di.module.UtilModule;
import com.srmstudios.emaarshahrukhmalik.ui.book_ticket.BookTicketModule;

/**
 * Created by Shahrukh Malik on 12/28/2017.
 */

public class App extends Application {
    private AppComponent component;

    @Override
    public void onCreate() {
        super.onCreate();
        component = DaggerAppComponent.builder()
                .appModule(new AppModule(this))
                .utilModule(new UtilModule())
                .retrofitModule(new RetrofitModule())
                .bookTicketModule(new BookTicketModule())
                .build();
    }

    public AppComponent getComponent(){
        return component;
    }
}

package com.srmstudios.emaarshahrukhmalik.di.component;

import com.srmstudios.emaarshahrukhmalik.di.module.AppModule;
import com.srmstudios.emaarshahrukhmalik.di.module.RetrofitModule;
import com.srmstudios.emaarshahrukhmalik.di.module.UtilModule;
import com.srmstudios.emaarshahrukhmalik.ui.book_ticket.BookTicketFragment;
import com.srmstudios.emaarshahrukhmalik.ui.book_ticket.BookTicketModule;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by Shahrukh Malik on 12/28/2017.
 */
@Component(modules = {AppModule.class,UtilModule.class, RetrofitModule.class, BookTicketModule.class})
@Singleton
public interface AppComponent {

    void inject(BookTicketFragment bookTicketFragment);

}


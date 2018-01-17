package com.srmstudios.emaarshahrukhmalik.ui.book_ticket;

import com.srmstudios.emaarshahrukhmalik.data.EmaarAPI;
import com.srmstudios.emaarshahrukhmalik.util.Utils;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Shahrukh Malik on 12/28/2017.
 */
@Module
public class BookTicketModule {

    @Provides
    public BookTicketMVP.Presenter provideBookTicketPresenter(BookTicketMVP.Model model, Utils utils){
        return new BookTicketPresenter(model,utils);
    }

    @Provides
    public BookTicketMVP.Model provideBookTicketModel(EmaarAPI emaarAPI){
        return new BookTicketModel(emaarAPI);
    }

}













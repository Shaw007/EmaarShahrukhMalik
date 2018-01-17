package com.srmstudios.emaarshahrukhmalik.ui.book_ticket;

import android.support.v7.widget.RecyclerView;
import android.widget.Spinner;

import com.srmstudios.emaarshahrukhmalik.ui.adapter.model.TotalTicketPurchase;

import java.util.List;

/**
 * Created by Shahrukh Malik on 12/28/2017.
 */

public class BookTicketMVP {

    interface View{
        RecyclerView getRecyclerViewVisitorTypes();
        Spinner getSpinnerShifts();
        void showPopUp(String title,String message);
        void showErrorWithRetryPopUp(String title,String message);
        void showWebviewPopup(String title,String htmlContent);
        void showProgressDailogFetchInfo();
        void hideProgressDailogFetchInfo();
        void showCardViewLayout();
        void hideCardViewLayout();
    }

    interface Presenter{
        void setView(BookTicketMVP.View view);
        void fetchDataFromAPIs();
        void getVisitorTypes();
        boolean isTicketRowAdded();
        void onClickBtnBookNow();
    }

    interface Model{
        void getGenderShifts(BookTicketModel.IResponseCallback iResponseCallback);
        void getVisitorTypes(BookTicketModel.IResponseCallback iResponseCallback);
    }

}















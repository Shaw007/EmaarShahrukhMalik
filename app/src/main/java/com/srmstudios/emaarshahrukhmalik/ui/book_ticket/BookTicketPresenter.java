package com.srmstudios.emaarshahrukhmalik.ui.book_ticket;

import com.srmstudios.emaarshahrukhmalik.R;
import com.srmstudios.emaarshahrukhmalik.data.model.response.GenderShiftMainResponse;
import com.srmstudios.emaarshahrukhmalik.data.model.response.VisitorTypeMainResponse;
import com.srmstudios.emaarshahrukhmalik.ui.adapter.ShiftSpinnerAdapter;
import com.srmstudios.emaarshahrukhmalik.ui.adapter.model.Ticket;
import com.srmstudios.emaarshahrukhmalik.ui.adapter.model.TotalTicketPurchase;
import com.srmstudios.emaarshahrukhmalik.ui.adapter.VisitorTypeAdapter;
import com.srmstudios.emaarshahrukhmalik.util.AppConstants;
import com.srmstudios.emaarshahrukhmalik.util.Utils;

import java.util.List;

/**
 * Created by Shahrukh Malik on 12/28/2017.
 */

public class BookTicketPresenter implements BookTicketMVP.Presenter {
    private BookTicketMVP.Model model;
    private BookTicketMVP.View view;
    private Utils utils;
    private GenderShiftMainResponse genderShiftMainResponse;
    private VisitorTypeMainResponse visitorTypeMainResponse;
    private ShiftSpinnerAdapter shiftSpinnerAdapter;
    private VisitorTypeAdapter visitorTypeAdapter;

    public BookTicketPresenter(BookTicketMVP.Model model, Utils utils){
        this.model = model;
        this.utils = utils;
    }

    @Override
    public void setView(BookTicketMVP.View view) {
        this.view = view;
    }

    @Override
    public void fetchDataFromAPIs(){
        model.getGenderShifts(iResponseCallback);
    }

    @Override
    public void getVisitorTypes() {
        model.getVisitorTypes(iResponseCallback);
    }

    @Override
    public boolean isTicketRowAdded() {
        List<TotalTicketPurchase> totalTicketPurchased = visitorTypeAdapter.getTotalTicketsSelected();
        if(totalTicketPurchased == null){
            return false;
        }
        if(totalTicketPurchased.size() == 0){
            return false;
        }
        for (TotalTicketPurchase ticketPurchase : totalTicketPurchased) {
            if (ticketPurchase.getTickets().size() > 0){
                return true;
            }
        }
        return false;
    }

    @Override
    public void onClickBtnBookNow() {
        if(validateTickets()){
            view.showPopUp(utils.getStringFromResourceId(R.string.success),
                    utils.getStringFromResourceId(R.string.tickets_are_ready_to_be_posted_on_server));
        }
    }


    private boolean validateTickets(){
        List<TotalTicketPurchase> totalTicketPurchased = visitorTypeAdapter.getTotalTicketsSelected();
        if(totalTicketPurchased == null){
            view.showPopUp(utils.getStringFromResourceId(R.string.error),
                    utils.getStringFromResourceId(R.string.you_must_buy_atleast_one_ticket));
            return false;
        }
        if(totalTicketPurchased.size() == 0){
            view.showPopUp(utils.getStringFromResourceId(R.string.error),
                    utils.getStringFromResourceId(R.string.you_must_buy_atleast_one_ticket));
            return false;
        }
        for (TotalTicketPurchase ticketPurchase : totalTicketPurchased) {
            for(Ticket singleTicket : ticketPurchase.getTickets()){
                if(singleTicket.getName() == null){
                    view.showPopUp(ticketPurchase.getVisitorType() + ": " + utils.getStringFromResourceId(R.string.ticket_number) + String.valueOf(singleTicket.getTicketNumber()),
                            utils.getStringFromResourceId(R.string.please_enter_a_valid_name));
                    return false;
                }
                if(singleTicket.getName().equals("")){
                    view.showPopUp(ticketPurchase.getVisitorType() + ": " + utils.getStringFromResourceId(R.string.ticket_number) + String.valueOf(singleTicket.getTicketNumber()),
                            utils.getStringFromResourceId(R.string.please_enter_a_valid_name));
                    return false;
                }
            }
        }
        return true;
    }

    // Callbacks

    BookTicketModel.IResponseCallback iResponseCallback = new BookTicketModel.IResponseCallback() {
        @Override
        public void onResponse(Object response) {
            if(response instanceof GenderShiftMainResponse) {
                GenderShiftMainResponse genderShiftMainResponse = (GenderShiftMainResponse) response;
                if (genderShiftMainResponse.getResult().get(0).getStatusCode().equals(AppConstants.API_ERROR_STATUS_CODE)) {
                    view.hideProgressDailogFetchInfo();
                    view.showErrorWithRetryPopUp(utils.getStringFromResourceId(R.string.error), utils.getStringFromResourceId(R.string.something_went_wrong));
                    return;
                } else if (genderShiftMainResponse.getResult().get(0).getStatusCode().equals(AppConstants.API_SUCCESS_STATUS_CODE)) {
                    BookTicketPresenter.this.genderShiftMainResponse = genderShiftMainResponse;
                    shiftSpinnerAdapter = new ShiftSpinnerAdapter(genderShiftMainResponse.getShifts());
                    view.getSpinnerShifts().setAdapter(shiftSpinnerAdapter);
                    getVisitorTypes();
                } else {
                    view.hideProgressDailogFetchInfo();
                    onUnSuccessfulResponse();
                }
            }else if(response instanceof VisitorTypeMainResponse){
                view.hideProgressDailogFetchInfo();
                visitorTypeMainResponse = (VisitorTypeMainResponse) response;
                if (visitorTypeMainResponse.getResult().get(0).getStatusCode().equals(AppConstants.API_ERROR_STATUS_CODE)) {
                    view.showErrorWithRetryPopUp(utils.getStringFromResourceId(R.string.error), utils.getStringFromResourceId(R.string.something_went_wrong));
                    return;
                } else if (visitorTypeMainResponse.getResult().get(0).getStatusCode().equals(AppConstants.API_SUCCESS_STATUS_CODE)) {
                    BookTicketPresenter.this.visitorTypeMainResponse = visitorTypeMainResponse;
                    visitorTypeAdapter = new VisitorTypeAdapter(visitorTypeMainResponse.getVisitorTypes(),
                            genderShiftMainResponse.getGenders(),
                            utils,
                            iTicketTypeInfoCallback);
                    view.getRecyclerViewVisitorTypes().setAdapter(visitorTypeAdapter);
                    view.showCardViewLayout();
                } else {
                    onUnSuccessfulResponse();
                }
            }
        }

        @Override
        public void onUnSuccessfulResponse() {
            view.hideProgressDailogFetchInfo();
            view.showErrorWithRetryPopUp(utils.getStringFromResourceId(R.string.error),
                    utils.getStringFromResourceId(R.string.data_fetching_was_unsuccessful));
        }

        @Override
        public void onError(Throwable t) {
            view.hideProgressDailogFetchInfo();
            view.showErrorWithRetryPopUp(utils.getStringFromResourceId(R.string.error),t.getMessage());
        }
    };

    VisitorTypeAdapter.ITicketTypeInfoCallback iTicketTypeInfoCallback = new VisitorTypeAdapter.ITicketTypeInfoCallback() {
        @Override
        public void onTicketInfoClick(String visitorType,String htmlContent) {
            view.showWebviewPopup(visitorType,htmlContent);
        }
    };
}




















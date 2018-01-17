package com.srmstudios.emaarshahrukhmalik.ui.book_ticket;

import com.srmstudios.emaarshahrukhmalik.data.EmaarAPI;
import com.srmstudios.emaarshahrukhmalik.data.model.response.GenderShiftMainResponse;
import com.srmstudios.emaarshahrukhmalik.data.model.response.VisitorTypeMainResponse;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Shahrukh Malik on 12/28/2017.
 */

public class BookTicketModel implements BookTicketMVP.Model {
    private EmaarAPI emaarAPI;

    public BookTicketModel(EmaarAPI emaarAPI){
        this.emaarAPI = emaarAPI;
    }

    @Override
    public void getGenderShifts(final IResponseCallback iResponseCallback) {
        Call<GenderShiftMainResponse> call = emaarAPI.getGenderAndShift();
        call.enqueue(new Callback<GenderShiftMainResponse>() {
            @Override
            public void onResponse(Call<GenderShiftMainResponse> call, Response<GenderShiftMainResponse> response) {
                if(response.isSuccessful()){
                    iResponseCallback.onResponse(response.body());
                }else {
                    iResponseCallback.onUnSuccessfulResponse();
                }
            }

            @Override
            public void onFailure(Call<GenderShiftMainResponse> call, Throwable t) {
                iResponseCallback.onError(t);
            }
        });
    }

    @Override
    public void getVisitorTypes(final IResponseCallback iResponseCallback) {
        Call<VisitorTypeMainResponse> call = emaarAPI.getVisitorTypes();
        call.enqueue(new Callback<VisitorTypeMainResponse>() {
            @Override
            public void onResponse(Call<VisitorTypeMainResponse> call, Response<VisitorTypeMainResponse> response) {
                if(response.isSuccessful()){
                    iResponseCallback.onResponse(response.body());
                }else {
                    iResponseCallback.onUnSuccessfulResponse();
                }
            }

            @Override
            public void onFailure(Call<VisitorTypeMainResponse> call, Throwable t) {
                iResponseCallback.onError(t);
            }
        });
    }

    public interface IResponseCallback{
        void onResponse(Object response);
        void onUnSuccessfulResponse();
        void onError(Throwable t);
    }
}

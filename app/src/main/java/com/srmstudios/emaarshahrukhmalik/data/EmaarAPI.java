package com.srmstudios.emaarshahrukhmalik.data;

import com.srmstudios.emaarshahrukhmalik.data.model.response.GenderShiftMainResponse;
import com.srmstudios.emaarshahrukhmalik.data.model.response.VisitorTypeMainResponse;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by Shahrukh Malik on 12/28/2017.
 */

public interface EmaarAPI {

    @GET("/bins/169zzz")
    Call<GenderShiftMainResponse> getGenderAndShift();

    @GET("/bins/1fsxof")
    Call<VisitorTypeMainResponse> getVisitorTypes();

}








package com.srmstudios.emaarshahrukhmalik.data.model.response;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by Shahrukh Malik on 12/28/2017.
 */

public class GenderShiftMainResponse {
    @SerializedName("Authenticate")
    @Expose
    private AuthenticateResponse authenticate;
    @SerializedName("Parks")
    @Expose
    private List<ParksResponse> parks = null;
    @SerializedName("Shifts")
    @Expose
    private List<ShiftResponse> shifts = null;
    @SerializedName("Genders")
    @Expose
    private List<GenderResponse> genders = null;
    @SerializedName("CreditCardTypes")
    @Expose
    private List<CreditCardTypesReponse> creditCardTypes = null;
    @SerializedName("Result")
    @Expose
    private List<ResultResponse> result = null;

    public AuthenticateResponse getAuthenticate() {
        return authenticate;
    }

    public void setAuthenticate(AuthenticateResponse authenticate) {
        this.authenticate = authenticate;
    }

    public List<ParksResponse> getParks() {
        return parks;
    }

    public void setParks(List<ParksResponse> parks) {
        this.parks = parks;
    }

    public List<ShiftResponse> getShifts() {
        return shifts;
    }

    public void setShifts(List<ShiftResponse> shifts) {
        this.shifts = shifts;
    }

    public List<GenderResponse> getGenders() {
        return genders;
    }

    public void setGenders(List<GenderResponse> genders) {
        this.genders = genders;
    }

    public List<CreditCardTypesReponse> getCreditCardTypes() {
        return creditCardTypes;
    }

    public void setCreditCardTypes(List<CreditCardTypesReponse> creditCardTypes) {
        this.creditCardTypes = creditCardTypes;
    }

    public List<ResultResponse> getResult() {
        return result;
    }

    public void setResult(List<ResultResponse> result) {
        this.result = result;
    }
}

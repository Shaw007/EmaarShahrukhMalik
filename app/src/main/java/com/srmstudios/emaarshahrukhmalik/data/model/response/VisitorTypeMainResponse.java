package com.srmstudios.emaarshahrukhmalik.data.model.response;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by Shahrukh Malik on 12/28/2017.
 */

public class VisitorTypeMainResponse {
    @SerializedName("Result")
    @Expose
    private List<ResultResponse> result = null;
    @SerializedName("VisitorTypes")
    @Expose
    private List<VisitorTypeResponse> visitorTypes = null;
    @SerializedName("AvailableTickets")
    @Expose
    private Integer availableTickets;

    public List<ResultResponse> getResult() {
        return result;
    }

    public void setResult(List<ResultResponse> result) {
        this.result = result;
    }

    public List<VisitorTypeResponse> getVisitorTypes() {
        return visitorTypes;
    }

    public void setVisitorTypes(List<VisitorTypeResponse> visitorTypes) {
        this.visitorTypes = visitorTypes;
    }

    public Integer getAvailableTickets() {
        return availableTickets;
    }

    public void setAvailableTickets(Integer availableTickets) {
        this.availableTickets = availableTickets;
    }
}

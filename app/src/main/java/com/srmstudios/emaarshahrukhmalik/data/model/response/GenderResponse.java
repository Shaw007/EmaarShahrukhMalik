package com.srmstudios.emaarshahrukhmalik.data.model.response;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by Shahrukh Malik on 12/28/2017.
 */

public class GenderResponse {
    @SerializedName("Description")
    @Expose
    private String description;
    @SerializedName("Initial")
    @Expose
    private Integer initial;
    @SerializedName("InitialSpecified")
    @Expose
    private Boolean initialSpecified;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getInitial() {
        return initial;
    }

    public void setInitial(Integer initial) {
        this.initial = initial;
    }

    public Boolean getInitialSpecified() {
        return initialSpecified;
    }

    public void setInitialSpecified(Boolean initialSpecified) {
        this.initialSpecified = initialSpecified;
    }
}

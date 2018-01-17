package com.srmstudios.emaarshahrukhmalik.data.model.response;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by Shahrukh Malik on 12/28/2017.
 */

public class AuthenticateResponse {
    @SerializedName("AuthString")
    @Expose
    private String authString;
    @SerializedName("AuthVal")
    @Expose
    private Integer authVal;
    @SerializedName("AuthValSpecified")
    @Expose
    private Boolean authValSpecified;

    public String getAuthString() {
        return authString;
    }

    public void setAuthString(String authString) {
        this.authString = authString;
    }

    public Integer getAuthVal() {
        return authVal;
    }

    public void setAuthVal(Integer authVal) {
        this.authVal = authVal;
    }

    public Boolean getAuthValSpecified() {
        return authValSpecified;
    }

    public void setAuthValSpecified(Boolean authValSpecified) {
        this.authValSpecified = authValSpecified;
    }
}

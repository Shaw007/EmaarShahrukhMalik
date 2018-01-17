package com.srmstudios.emaarshahrukhmalik.data.model.response;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by Shahrukh Malik on 12/28/2017.
 */

public class ResultResponse {
    @SerializedName("StatusCode")
    @Expose
    private String statusCode;
    @SerializedName("Status")
    @Expose
    private String status;
    @SerializedName("Message")
    @Expose
    private String message;

    public String getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(String statusCode) {
        this.statusCode = statusCode;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}

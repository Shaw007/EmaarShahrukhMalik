package com.srmstudios.emaarshahrukhmalik.data.model.response;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by Shahrukh Malik on 12/28/2017.
 */

public class CreditCardTypesReponse {

    @SerializedName("CardType")
    @Expose
    private String cardType;
    @SerializedName("ID")
    @Expose
    private Integer iD;
    @SerializedName("IDSpecified")
    @Expose
    private Boolean iDSpecified;

    public String getCardType() {
        return cardType;
    }

    public void setCardType(String cardType) {
        this.cardType = cardType;
    }

    public Integer getID() {
        return iD;
    }

    public void setID(Integer iD) {
        this.iD = iD;
    }

    public Boolean getIDSpecified() {
        return iDSpecified;
    }

    public void setIDSpecified(Boolean iDSpecified) {
        this.iDSpecified = iDSpecified;
    }
}

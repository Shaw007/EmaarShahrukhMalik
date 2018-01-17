package com.srmstudios.emaarshahrukhmalik.data.model.response;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.srmstudios.emaarshahrukhmalik.ui.adapter.TicketAdapter;

/**
 * Created by Shahrukh Malik on 12/28/2017.
 */

public class VisitorTypeResponse {
    @SerializedName("ActualDescription")
    @Expose
    private String actualDescription;
    @SerializedName("AgeCriteria")
    @Expose
    private String ageCriteria;
    @SerializedName("AliasID")
    @Expose
    private Integer aliasID;
    @SerializedName("Description")
    @Expose
    private String description;
    @SerializedName("FreeTicketAge")
    @Expose
    private String freeTicketAge;
    @SerializedName("FreeTicketAliasID")
    @Expose
    private String freeTicketAliasID;
    @SerializedName("FreeTicketID")
    @Expose
    private String freeTicketID;
    @SerializedName("FreeTicketName")
    @Expose
    private String freeTicketName;
    @SerializedName("FreeTicketPrice")
    @Expose
    private Double freeTicketPrice;
    @SerializedName("FreeTicketQuantity")
    @Expose
    private String freeTicketQuantity;
    @SerializedName("ID")
    @Expose
    private Integer iD;
    @SerializedName("MaxAge")
    @Expose
    private Integer maxAge;
    @SerializedName("MinAge")
    @Expose
    private Integer minAge;
    @SerializedName("NewPrice")
    @Expose
    private String newPrice;
    @SerializedName("Price")
    @Expose
    private Double price;
    @SerializedName("PriceID")
    @Expose
    private Integer priceID;
    @SerializedName("TicketContentURL")
    @Expose
    private String ticketContentURL;
    @SerializedName("TicketOrder")
    @Expose
    private Integer ticketOrder;
    @SerializedName("TicketType")
    @Expose
    private String ticketType;
    @SerializedName("UniqueId")
    @Expose
    private String uniqueId;
    private TicketAdapter ticketAdapter;

    public VisitorTypeResponse(){
        this.ticketAdapter = null;
    }

    public String getActualDescription() {
        return actualDescription;
    }

    public void setActualDescription(String actualDescription) {
        this.actualDescription = actualDescription;
    }

    public String getAgeCriteria() {
        return ageCriteria;
    }

    public void setAgeCriteria(String ageCriteria) {
        this.ageCriteria = ageCriteria;
    }

    public Integer getAliasID() {
        return aliasID;
    }

    public void setAliasID(Integer aliasID) {
        this.aliasID = aliasID;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getFreeTicketAge() {
        return freeTicketAge;
    }

    public void setFreeTicketAge(String freeTicketAge) {
        this.freeTicketAge = freeTicketAge;
    }

    public String getFreeTicketAliasID() {
        return freeTicketAliasID;
    }

    public void setFreeTicketAliasID(String freeTicketAliasID) {
        this.freeTicketAliasID = freeTicketAliasID;
    }

    public String getFreeTicketID() {
        return freeTicketID;
    }

    public void setFreeTicketID(String freeTicketID) {
        this.freeTicketID = freeTicketID;
    }

    public String getFreeTicketName() {
        return freeTicketName;
    }

    public void setFreeTicketName(String freeTicketName) {
        this.freeTicketName = freeTicketName;
    }

    public Double getFreeTicketPrice() {
        return freeTicketPrice;
    }

    public void setFreeTicketPrice(Double freeTicketPrice) {
        this.freeTicketPrice = freeTicketPrice;
    }

    public String getFreeTicketQuantity() {
        return freeTicketQuantity;
    }

    public void setFreeTicketQuantity(String freeTicketQuantity) {
        this.freeTicketQuantity = freeTicketQuantity;
    }

    public Integer getID() {
        return iD;
    }

    public void setID(Integer iD) {
        this.iD = iD;
    }

    public Integer getMaxAge() {
        return maxAge;
    }

    public void setMaxAge(Integer maxAge) {
        this.maxAge = maxAge;
    }

    public Integer getMinAge() {
        return minAge;
    }

    public void setMinAge(Integer minAge) {
        this.minAge = minAge;
    }

    public String getNewPrice() {
        return newPrice;
    }

    public void setNewPrice(String newPrice) {
        this.newPrice = newPrice;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Integer getPriceID() {
        return priceID;
    }

    public void setPriceID(Integer priceID) {
        this.priceID = priceID;
    }

    public String getTicketContentURL() {
        return ticketContentURL;
    }

    public void setTicketContentURL(String ticketContentURL) {
        this.ticketContentURL = ticketContentURL;
    }

    public Integer getTicketOrder() {
        return ticketOrder;
    }

    public void setTicketOrder(Integer ticketOrder) {
        this.ticketOrder = ticketOrder;
    }

    public String getTicketType() {
        return ticketType;
    }

    public void setTicketType(String ticketType) {
        this.ticketType = ticketType;
    }

    public String getUniqueId() {
        return uniqueId;
    }

    public void setUniqueId(String uniqueId) {
        this.uniqueId = uniqueId;
    }

    public TicketAdapter getTicketAdapter() {
        return ticketAdapter;
    }

    public void setTicketAdapter(TicketAdapter ticketAdapter) {
        this.ticketAdapter = ticketAdapter;
    }
}

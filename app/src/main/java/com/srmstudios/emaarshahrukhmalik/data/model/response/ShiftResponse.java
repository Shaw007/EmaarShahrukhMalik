package com.srmstudios.emaarshahrukhmalik.data.model.response;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by Shahrukh Malik on 12/28/2017.
 */

public class ShiftResponse {
    @SerializedName("EndHour")
    @Expose
    private String endHour;
    @SerializedName("ID")
    @Expose
    private Integer iD;
    @SerializedName("IDSpecified")
    @Expose
    private Boolean iDSpecified;
    @SerializedName("Name")
    @Expose
    private String name;
    @SerializedName("StartHour")
    @Expose
    private String startHour;
    @SerializedName("Tickets")
    @Expose
    private Integer tickets;
    @SerializedName("TicketsSpecified")
    @Expose
    private Boolean ticketsSpecified;

    public String getEndHour() {
        return endHour;
    }

    public void setEndHour(String endHour) {
        this.endHour = endHour;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStartHour() {
        return startHour;
    }

    public void setStartHour(String startHour) {
        this.startHour = startHour;
    }

    public Integer getTickets() {
        return tickets;
    }

    public void setTickets(Integer tickets) {
        this.tickets = tickets;
    }

    public Boolean getTicketsSpecified() {
        return ticketsSpecified;
    }

    public void setTicketsSpecified(Boolean ticketsSpecified) {
        this.ticketsSpecified = ticketsSpecified;
    }
}

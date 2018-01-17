package com.srmstudios.emaarshahrukhmalik.ui.adapter.model;

import com.srmstudios.emaarshahrukhmalik.data.model.response.GenderResponse;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Shahrukh Malik on 12/28/2017.
 */

public class Ticket {
    private int ticketNumber;
    private List<GenderResponse> genders;
    private int minAge;
    private int maxAge;
    private List<Integer> ageList;
    private String name;
    private String selectedGender;
    private int selectedAge;

    public Ticket(){
        ageList = new ArrayList<>();
        for(int i=minAge;i<=maxAge;i++){
            ageList.add(i);
        }
    }

    public int getTicketNumber() {
        return ticketNumber;
    }

    public void setTicketNumber(int ticketNumber) {
        this.ticketNumber = ticketNumber;
    }

    public List<GenderResponse> getGenders() {
        return genders;
    }

    public void setGenders(List<GenderResponse> genders) {
        this.genders = genders;
    }

    public List<Integer> getAgeList() {
        return ageList;
    }

    public void setAgeList(List<Integer> ageList) {
        this.ageList = ageList;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSelectedGender() {
        return selectedGender;
    }

    public void setSelectedGender(String selectedGender) {
        this.selectedGender = selectedGender;
    }

    public int getSelectedAge() {
        return selectedAge;
    }

    public void setSelectedAge(int selectedAge) {
        this.selectedAge = selectedAge;
    }

    public int getMinAge() {
        return minAge;
    }

    public void setMinAge(int minAge) {
        this.minAge = minAge;
    }

    public int getMaxAge() {
        return maxAge;
    }

    public void setMaxAge(int maxAge) {
        this.maxAge = maxAge;
    }
}

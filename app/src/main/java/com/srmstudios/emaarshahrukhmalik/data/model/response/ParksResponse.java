package com.srmstudios.emaarshahrukhmalik.data.model.response;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by Shahrukh Malik on 12/28/2017.
 */

public class ParksResponse {
    @SerializedName("Name")
    @Expose
    private String name;
    @SerializedName("Prefix")
    @Expose
    private String prefix;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPrefix() {
        return prefix;
    }

    public void setPrefix(String prefix) {
        this.prefix = prefix;
    }
}

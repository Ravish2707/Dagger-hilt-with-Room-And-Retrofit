package com.ravish.universities.model;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class University {

    @SerializedName("domains")
    @Expose
    private List<String> domains;

    @SerializedName("web_pages")
    @Expose
    private List<String> web_pages;

    @SerializedName("name")
    @Expose
    private String name;

    @SerializedName("alpha_two_code")
    @Expose
    private String alpha_two_code;

    @SerializedName("state-province")
    @Expose
    private String state_province;

    @SerializedName("country")
    @Expose
    private String country;

    public University(List<String> domains, List<String> web_pages, String name, String alpha_two_code, String state_province, String country) {
        this.domains = domains;
        this.web_pages = web_pages;
        this.name = name;
        this.alpha_two_code = alpha_two_code;
        this.state_province = state_province;
        this.country = country;
    }


    public List<String> getDomains() {
        return domains;
    }

    public void setDomains(List<String> domains) {
        this.domains = domains;
    }

    public List<String> getWeb_pages() {
        return web_pages;
    }

    public void setWeb_pages(List<String> web_pages) {
        this.web_pages = web_pages;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAlpha_two_code() {
        return alpha_two_code;
    }

    public void setAlpha_two_code(String alpha_two_code) {
        this.alpha_two_code = alpha_two_code;
    }

    public String getState_province() {
        return state_province;
    }

    public void setState_province(String state_province) {
        this.state_province = state_province;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
}

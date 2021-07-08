package com.ravish.universities.database;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "university_table")
public class UniversityEntity {

    @PrimaryKey(autoGenerate = true)
    private int id;

    private String domain;

    private String web_pages;

    private String name;

    private String alpha_two_code;

    private String state_province;

    private String country;

    public UniversityEntity(String domain, String web_pages, String name, String alpha_two_code, String state_province, String country) {
        this.domain = domain;
        this.web_pages = web_pages;
        this.name = name;
        this.alpha_two_code = alpha_two_code;
        this.state_province = state_province;
        this.country = country;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDomain() {
        return domain;
    }

    public void setDomain(String domain) {
        this.domain = domain;
    }

    public String getWeb_pages() {
        return web_pages;
    }

    public void setWeb_pages(String web_pages) {
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

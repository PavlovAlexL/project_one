package com.palex.practice.view;

import com.palex.practice.model.CountryEntity;
import com.palex.practice.model.UserDocumentEntity;

import javax.validation.constraints.NotEmpty;

public class UserView {

    @NotEmpty
    private Long id;

    @NotEmpty
    private String first_Name;

    private String second_Name;

    private String middle_Name;

    @NotEmpty
    private String position;

    private String phone;

    private Boolean is_identified;

    private UserDocumentEntity userDocument;

    private CountryEntity country;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirst_Name() {
        return first_Name;
    }

    public void setFirst_Name(String first_Name) {
        this.first_Name = first_Name;
    }

    public String getSecond_Name() {
        return second_Name;
    }

    public void setSecond_Name(String second_Name) {
        this.second_Name = second_Name;
    }

    public String getMiddle_Name() {
        return middle_Name;
    }

    public void setMiddle_Name(String middle_Name) {
        this.middle_Name = middle_Name;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Boolean getIs_identified() {
        return is_identified;
    }

    public void setIs_identified(Boolean is_identified) {
        this.is_identified = is_identified;
    }

    public UserDocumentEntity getUserDocument() {
        return userDocument;
    }

    public void setUserDocument(UserDocumentEntity userDocument) {
        this.userDocument = userDocument;
    }

    public CountryEntity getCountry() {
        return country;
    }

    public void setCountry(CountryEntity country) {
        this.country = country;
    }
}

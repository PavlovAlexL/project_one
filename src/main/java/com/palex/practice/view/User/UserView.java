package com.palex.practice.view.User;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.palex.practice.model.CountryEntity;
import com.palex.practice.model.UserDocumentEntity;

import java.util.Date;


@JsonIgnoreProperties({"country", "userDocument"})
public class UserView {

    public Long id;
    public String firstName;
    public String lastName;
    public String middleName;
    public String position;
    public String phone;

    public String docName;
    public String docNumber;
    public Date docDate;

    public String citizenshipName;
    public String citizenshipCode;

    public Boolean isIdentified;

    public UserDocumentEntity userDocument;
    public CountryEntity country;

    public String getDocName() {
        return userDocument.getDocumentType().getName();
    }

    public String getDocNumber() {
        return userDocument.getDocNumber();
    }

    public Date getDocDate() {
        return userDocument.getDocDate();
    }

    public String getCitizenshipName() {
        return country.getName();
    }

    public String getCitizenshipCode() {
        return country.getCode();
    }
}

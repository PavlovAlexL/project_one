package com.palex.practice.view;

import com.palex.practice.model.CountryEntity;
import com.palex.practice.model.UserDocumentEntity;

import javax.validation.constraints.NotEmpty;

public class UserView {

    @NotEmpty
    Long id;

    @NotEmpty
    String first_Name;

    String second_Name;

    String middle_Name;

    @NotEmpty
    String position;

    String phone;

    Boolean is_identified;

    UserDocumentEntity userDocument;

    CountryEntity country;

}

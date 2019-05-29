package com.palex.practice.view;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CountryView {

    @JsonProperty("citizenshipName")
    public String name;

    @JsonProperty("citizenshipCode")
    public String code;

}

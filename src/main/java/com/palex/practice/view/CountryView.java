package com.palex.practice.view;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CountryView {

    @JsonProperty("citizenshipCode")
    public String code;

    @JsonProperty("citizenshipName")
    public String name;
}

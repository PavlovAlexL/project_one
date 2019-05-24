package com.palex.practice.view;

import com.fasterxml.jackson.annotation.JsonInclude;

import javax.validation.constraints.NotEmpty;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class CountryView {

    @NotEmpty
    public String code;

    @NotEmpty
    public String name;
}

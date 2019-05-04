package com.palex.practice.view;

import javax.validation.constraints.NotEmpty;

public class CountryView {

    @NotEmpty
    private String code;

    @NotEmpty
    private String name;

    @Override
    public String toString() {
        return "{code:" + code + ";name:" +name + "}";
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

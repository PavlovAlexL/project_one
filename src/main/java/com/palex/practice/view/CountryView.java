package com.palex.practice.view;

import javax.validation.constraints.NotEmpty;

public class CountryView {

    @NotEmpty
    private Long id;

    @NotEmpty
    private String code;

    @NotEmpty
    private String name;

    @Override
    public String toString() {
        return "{id:" + id + ";code:" + code + ";name:" +name + "}";
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

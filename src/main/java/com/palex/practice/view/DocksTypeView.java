package com.palex.practice.view;

import com.fasterxml.jackson.annotation.JsonRootName;

import javax.validation.constraints.NotEmpty;
public class DocksTypeView {

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

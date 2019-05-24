package com.palex.practice.view;

import javax.validation.constraints.NotEmpty;

public class DocksTypeView {

    @NotEmpty
    public String code;

    @NotEmpty
    public String name;
}

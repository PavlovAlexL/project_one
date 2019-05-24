package com.palex.practice.view;

import com.fasterxml.jackson.annotation.JsonInclude;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class OfficeView {

    @NotEmpty
    Long id;

    @NotEmpty
    String name;

    @NotEmpty
    String address;

    @NotNull
    String phone;

    @NotEmpty
    Boolean is_active;


}

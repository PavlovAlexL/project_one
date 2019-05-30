package com.palex.practice.view.Organisation;


import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class OrganisationSaveFilterView {

    @NotNull
    @NotBlank
    @Size(min = 2, max = 50)
    public String name;

    @NotNull
    @NotBlank
    @Size(min = 2, max = 50)
    public String fullName;

    @NotNull
    @NotBlank
    @Size(min = 10, max = 10)
    @Pattern(regexp = "[0-9]*")
    public String inn;

    @NotNull
    @NotBlank
    @Size(min = 9, max = 9)
    @Pattern(regexp = "[0-9]*")
    public String kpp;

    @NotNull
    @NotBlank
    @Size(min = 5, max = 200)
    public String address;

    @Size(max = 20)
    public String phone;

    public String isActive;

    public void setPhone(String phone) {
        if (phone.length() == 0) {
            this.phone = phone;
        } else if (phone.matches("^((8|\\+7)[\\- ]?)?(\\(?\\d{3}\\)?[\\- ]?)?[\\d\\- ]{7,10}$")) {
            this.phone = phone;
        } else throw new RuntimeException("Not valid phone string");
    }

}

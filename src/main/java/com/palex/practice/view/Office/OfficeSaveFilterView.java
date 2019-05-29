package com.palex.practice.view.Office;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class OfficeSaveFilterView {

    @NotNull
    @Min(1)
    public Long orgId;

    @NotNull
    @NotBlank
    @Size(max = 50)
    public String name;

    @Size(max = 200)
    public String address;

    @Size(max = 20)
    public String phone;

    public String isActive;

    public void setPhone(String phone) {
        System.out.println("Phone Lenght =" + phone.length() + phone);

        if (phone.length() == 0) {
            this.phone = phone;
        } else if (phone.matches("^((8|\\+7)[\\- ]?)?(\\(?\\d{3}\\)?[\\- ]?)?[\\d\\- ]{7,10}$")) {
            this.phone = phone;
        } else throw new RuntimeException("Not valid phone string");
    }

}

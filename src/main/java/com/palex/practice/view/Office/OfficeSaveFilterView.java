package com.palex.practice.view.Office;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class OfficeSaveFilterView {

    @NotNull
    public Long orgId;

    @Size(max = 50)
    public String name;

    @Size(max = 200)
    public String address;

    @Size(max = 20)
    public String phone;

    public String isActive;

}

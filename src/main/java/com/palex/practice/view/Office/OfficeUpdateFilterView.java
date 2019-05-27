package com.palex.practice.view.Office;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class OfficeUpdateFilterView {

    @NotNull
    public Long id;

    @NotEmpty
    @Size(max = 50)
    public String name;

    @NotEmpty
    @Size(max = 200)
    public String address;

    @Size(max = 20)
    public String phone;

    public String isActive;

}

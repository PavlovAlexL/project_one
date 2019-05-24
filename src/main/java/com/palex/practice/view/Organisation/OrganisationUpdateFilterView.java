package com.palex.practice.view.Organisation;

import javax.validation.constraints.*;

public class OrganisationUpdateFilterView {

    @NotEmpty
    @Min(1)
    public Long id;

    @NotEmpty
    @Size(min = 2, max = 50)
    public String name;

    @NotEmpty
    @Size(min = 2, max = 50)
    public String fullName;

    @NotEmpty
    @Size(min = 10, max = 10)
    public String inn;

    @NotEmpty
    @Size(min = 9, max = 9)
    public String kpp;

    @NotEmpty
    @Size(min = 5, max = 200)
    public String address;

    @Size(max = 20)
    @Pattern(regexp = "^\\s*(?:\\+?(\\d{1,3}))?([-. (]*(\\d{3})[-. )]*)?((\\d{3})[-. ]*(\\d{2,4})(?:[-.x ]*(\\d+))?)\\s*$")
    public String phone;

    @Pattern(regexp = "\b(true|false)")
    public String isActive;

}

package com.palex.practice.view.Organisation;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

public class OrganisationSaveFilterView {

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
    public String phone;

    public String isActive;

}

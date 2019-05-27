package com.palex.practice.view.Organisation;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

public class OrganisationListFilterView {

    @NotEmpty
    @Size(min = 2, max = 50)
    public String name;

    @Size(max = 10)
    public String inn;

    public String isActive;

}

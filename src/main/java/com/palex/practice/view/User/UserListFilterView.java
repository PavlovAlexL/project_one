package com.palex.practice.view.User;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class UserListFilterView {

    @NotNull
    public Long officeId;

    @Size(max = 50)
    public String firstName;

    @Size(max = 50)
    public String lastName;

    @Size(max = 50)
    public String middleName;

    @Size(max = 100)
    public String position;

    @Size(max = 10)
    public String docCode;

    @Size(max = 10)
    public String citizenshipCode;

}

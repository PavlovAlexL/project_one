package com.palex.practice.view.User;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class UserSaveFilterView {

    @NotNull
    public Long officeId;

    @NotEmpty
    @Size(max = 50)
    public String firstName;

    @Size(max = 50)
    public String lastName;

    @Size(max = 50)
    public String middleName;

    @NotEmpty
    @Size(max = 100)
    public String position;

    @Size(max = 20)
    public String phone;

    @Size(max = 10)
    public String docCode;

    @Size(max = 50)
    public String docName;

    @Size(max = 20)
    public String docNumber;

    @Size(max = 50)
    public String docDate;

    @Size(max = 10)
    public String citizenshipCode;

    public String isIdentified;

}

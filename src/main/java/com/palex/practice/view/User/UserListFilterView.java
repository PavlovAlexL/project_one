package com.palex.practice.view.User;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class UserListFilterView {

    @NotNull
    @Min(1)
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

    public void setDocCode(String docCode) {
        if (docCode.length() == 0) {
            this.docCode = docCode;
        } else if (docCode.matches("\\d")) {
            this.docCode = docCode;
        } else throw new RuntimeException("Not valid docCode");
    }

    public void setCitizenshipCode(String citizenshipCode) {
        if (citizenshipCode.length() == 0) {
            this.citizenshipCode = citizenshipCode;
        } else if (citizenshipCode.matches("\\d")) {
            this.citizenshipCode = citizenshipCode;
        } else throw new RuntimeException("Not valid CitizenshipCode");
    }

    @Override
    public String toString() {
        return "UserListFilterView{" +
                "officeId=" + officeId +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", middleName='" + middleName + '\'' +
                ", position='" + position + '\'' +
                ", docCode='" + docCode + '\'' +
                ", citizenshipCode='" + citizenshipCode + '\'' +
                '}';
    }
}

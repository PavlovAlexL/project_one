package com.palex.practice.view.User;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class UserUpdateFilterView {

    @NotNull
    @Min(1)
    public Long id;

    @Min(1)
    public Long officeId;

    @NotNull
    @NotBlank
    @Size(max = 50)
    public String firstName;

    @Size(max = 50)
    public String lastName;

    @Size(max = 50)
    public String middleName;

    @NotNull
    @NotBlank
    @Size(max = 100)
    public String position;

    @Size(max = 20)
    public String phone;

    @Size(max = 50)
    public String docName;

    @Size(max = 20)
    public String docNumber;

    @Size(max = 50)
    public String docDate;

    @Size(max = 10)
    public String citizenshipCode;

    public String isIdentified;

    public void setPhone(String phone) {
        if (phone.length() == 0) {
            this.phone = phone;
        } else if (phone.matches("^((8|\\+7)[\\- ]?)?(\\(?\\d{3}\\)?[\\- ]?)?[\\d\\- ]{7,10}$")) {
            this.phone = phone;
        } else throw new RuntimeException("Not valid phone string");
    }

    @Override
    public String toString() {
        return "UserUpdateFilterView{" +
                "id=" + id +
                ", officeId=" + officeId +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", middleName='" + middleName + '\'' +
                ", position='" + position + '\'' +
                ", phone='" + phone + '\'' +
                ", docName='" + docName + '\'' +
                ", docNumber='" + docNumber + '\'' +
                ", docDate='" + docDate + '\'' +
                ", citizenshipCode='" + citizenshipCode + '\'' +
                ", isIdentified='" + isIdentified + '\'' +
                '}';
    }
}

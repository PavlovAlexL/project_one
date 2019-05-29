package com.palex.practice.view.User;

import javax.validation.constraints.*;

public class UserSaveFilterView {

    @NotNull
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

    @Size(max = 10)
    public String docCode;

    @Size(max = 50)
    public String docName;

    @Size(max = 20)
    @Pattern(regexp = "\\d*")
    public String docNumber;

    @Size(max = 50)
    public String docDate;

    @Size(max = 10)

    public String citizenshipCode;

    public String isIdentified;

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        if (phone.length() == 0) {
            this.phone = phone;
        } else if (phone.matches("^((8|\\+7)[\\- ]?)?(\\(?\\d{3}\\)?[\\- ]?)?[\\d\\- ]{7,10}$")) {
            this.phone = phone;
        } else throw new RuntimeException("Not valid phone");
    }

    public void setDocDate(String docDate) {
        if (docDate.length() == 0) {
            this.docDate = docDate;
        } else if (docDate.matches("(0[1-9]|[12][0-9]|3[01])[- /.](0[1-9]|1[012])[- /.](19|20)\\d\\d")) {
            this.docDate = docDate;
        } else throw new RuntimeException("Not valid docDate");
    }

    @Override
    public String toString() {
        return "UserSaveFilterView{" +
                "officeId=" + officeId +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", middleName='" + middleName + '\'' +
                ", position='" + position + '\'' +
                ", phone='" + phone + '\'' +
                ", docCode='" + docCode + '\'' +
                ", docName='" + docName + '\'' +
                ", docNumber='" + docNumber + '\'' +
                ", docDate='" + docDate + '\'' +
                ", citizenshipCode='" + citizenshipCode + '\'' +
                ", isIdentified='" + isIdentified + '\'' +
                '}';
    }
}

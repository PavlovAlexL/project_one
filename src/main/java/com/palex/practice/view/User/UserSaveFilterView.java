package com.palex.practice.view.User;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

/**
 * View для валлидациии данных при сохранении пользователя.
 */
public class UserSaveFilterView {

    /**
     * Идентификатор оффиса.
     */
    @NotNull
    @Min(1)
    public Long officeId;

    /**
     * Имя
     */
    @NotNull
    @NotBlank
    @Size(max = 50)
    public String firstName;

    /**
     * Фамилия
     */
    @Size(max = 50)
    public String lastName;

    /**
     * Отчество
     */
    @Size(max = 50)
    public String middleName;

    /**
     * Должность.
     */
    @NotNull
    @NotBlank
    @Size(max = 100)
    public String position;

    /**
     * Телефон.
     */
    @Size(max = 20)
    public String phone;

    /**
     * Код документа.
     */
    @Size(max = 10)
    public String docCode;

    /**
     * Имя документа.
     */
    @Size(max = 50)
    public String docName;

    /**
     * Номер документа.
     */
    @Size(max = 20)
    @Pattern(regexp = "\\d*")
    public String docNumber;

    /**
     * Дата документа.
     */
    @Size(max = 50)
    public String docDate;

    /**
     * Код гражданства
     */
    @Size(max = 10)
    public String citizenshipCode;

    /**
     * Статус.
     */
    public String isIdentified;

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        if(lastName.length() == 0){
            this.lastName = null;
        } else {
            this.lastName = lastName;
        }
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        if(middleName.length() == 0){
            this.middleName = null;
        } else {
            this.middleName = middleName;
        }
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        if (phone.length() == 0) {
            this.phone = null;
        } else if (phone.matches("^((8|\\+7)[\\- ]?)?(\\(?\\d{3}\\)?[\\- ]?)?[\\d\\- ]{7,10}$")) {
            this.phone = phone;
        } else throw new RuntimeException("Not valid phone");
    }

    public String getDocCode() {
        return docCode;
    }

    public void setDocCode(String docCode) {
        if(docCode.length() == 0){
            this.docCode = null;
        } else {
            this.docCode = String.valueOf(Integer.parseInt(docCode));
        }
    }

    public String getDocName() {
        return docName;
    }

    public void setDocName(String docName) {
        if(docName.length() == 0){
            this.docName = null;
        } else {
            this.docName = docName;
        }
    }

    public String getDocNumber() {
        return docNumber;
    }

    public void setDocNumber(String docNumber) {
        if(docNumber.length() == 0){
            this.docNumber = null;
        } else {
            this.docNumber = docNumber;
        }
    }

    public String getDocDate() {
        return docDate;
    }

    public void setDocDate(String docDate) {
        if (docDate.length() == 0) {
            this.docDate = null;
        } else if (docDate.matches("(0[1-9]|[12][0-9]|3[01])[- /.](0[1-9]|1[012])[- /.](19|20)\\d\\d")) {
            this.docDate = docDate;
        } else throw new RuntimeException("Not valid docDate");
    }

    public String getCitizenshipCode() {
        return citizenshipCode;
    }

    public void setCitizenshipCode(String citizenshipCode) {
        if(citizenshipCode.length() == 0){
            this.citizenshipCode = null;
        } else {
            this.citizenshipCode = citizenshipCode;
        }
    }

    public String getIsIdentified() {
        return isIdentified;
    }

    public void setIsIdentified(String isIdentified) {
        if(isIdentified.length() == 0){
            this.isIdentified = null;
        } else {
            this.isIdentified = isIdentified;
        }
    }
}

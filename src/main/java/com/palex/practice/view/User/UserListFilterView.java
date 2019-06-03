package com.palex.practice.view.User;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * View для валлидации запроса на вывод списка пользователей.
 */
public class UserListFilterView {

    /**
     * Идентификатор офиса
     */
    @NotNull
    @Min(1)
    public Long officeId;

    /**
     * Имя.
     */
    @Size(max = 50)
    public String firstName;

    /**
     * Фамилия.
     */
    @Size(max = 50)
    public String lastName;

    /**
     * Отчество.
     */
    @Size(max = 50)
    public String middleName;

    /**
     * Должность.
     */
    @Size(max = 100)
    public String position;

    /**
     * Код документа.
     */
    @Size(max = 10)
    public String docCode;

    /**
     * Код гражданства.
     */
    @Size(max = 10)
    public String citizenshipCode;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        if(firstName.length() == 0){
            this.firstName = null;
        } else {
            this.firstName = firstName;
        }
    }

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

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        if(position.length() == 0) {
            this.position = null;
        } else {
            this.position = position;
        }
    }

    public String getDocCode() {
        return docCode;
    }

    public void setDocCode(String docCode) {
        if (docCode.length() == 0) {
            this.docCode = null;
        } else {
            this.docCode = docCode;
        }
    }

    public String getCitizenshipCode() {
        return citizenshipCode;
    }

    public void setCitizenshipCode(String citizenshipCode) {
        if (citizenshipCode.length() == 0) {
            this.citizenshipCode = null;
        } else {
            this.citizenshipCode = citizenshipCode;
        }
    }
}

package com.palex.practice.view.User;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.palex.practice.model.CountryEntity;
import com.palex.practice.model.UserDocumentEntity;

import java.util.Date;

/**
 * View для отправки позователя.
 */
@JsonIgnoreProperties({"country", "userDocument"})
public class UserView {

    /**
     * Идентификатор.
     */
    public Long id;

    /**
     * Имя.
     */
    public String firstName;

    /**
     * Фамилия.
     */
    public String lastName;

    /**
     * Отчество.
     */
    public String middleName;

    /**
     * Должность.
     */
    public String position;

    /**
     * Телефон.
     */
    public String phone;

    /**
     * Имя документа.
     */
    public String docName;

    /**
     * Номер документа.
     */
    public String docNumber;

    /**
     * Дата документа.
     */
    public Date docDate;

    /**
     * Гражданство.
     */
    public String citizenshipName;

    /**
     * Код гражданства.
     */
    public String citizenshipCode;

    /**
     * Статус.
     */
    public Boolean isIdentified;

    /**
     * Объект документа пользователя
     */
    public UserDocumentEntity userDocument;

    /**
     * Объект гражданства.
     */
    public CountryEntity country;

    /**
     *  Геттер имени документа.
     */
    public String getDocName() {
        if (userDocument != null){
            return userDocument.getDocumentType().getName();
        } else return null;
    }

    /**
     * Геттер номера документа.
     */
    public String getDocNumber() {
        if (userDocument != null){
            return userDocument.getDocNumber();
        } else return null;
    }

    /**
     * Геттер даты документа.
     */
    public Date getDocDate() {
        if (userDocument != null){
        return userDocument.getDocDate();
        } else return null;
    }

    /**
     * Геттер наименования гражданства.
     */
    public String getCitizenshipName() {
        if (country != null){
            return country.getName();
        } else return null;

    }

    /**
     * Геттер кода гражданства.
     */
    public String getCitizenshipCode() {
        if (country != null){
        return country.getCode();
        } else return null;
    }
}

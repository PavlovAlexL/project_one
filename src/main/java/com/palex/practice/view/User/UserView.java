package com.palex.practice.view.User;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.palex.practice.model.CountryEntity;
import com.palex.practice.model.UserDocumentEntity;

import java.util.Date;

/**
 * View для отправки результата.
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
     *
     */
    public CountryEntity country;

    /**
     *
     */
    public String getDocName() {
        return userDocument.getDocumentType().getName();
    }

    /**
     *
     */
    public String getDocNumber() {
        return userDocument.getDocNumber();
    }

    /**
     *
     */
    public Date getDocDate() {
        return userDocument.getDocDate();
    }

    /**
     *
     */
    public String getCitizenshipName() {
        return country.getName();
    }

    /**
     *
     */
    public String getCitizenshipCode() {
        return country.getCode();
    }
}

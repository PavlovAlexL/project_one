package com.palex.practice.view.User;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * View для валлидации обновления User.
 */
public class UserUpdateFilterView {

    /**
     * Идентификатор.
     */
    @NotNull
    @Min(1)
    public Long id;

    /**
     * Идентификатор оффиса.
     */
    @Min(1)
    public Long officeId;

    /**
     * Имя.
     */
    @NotNull
    @NotBlank
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
     * Имя документа.
     */
    @Size(max = 50)
    public String docName;

    /**
     * Номер документа.
     */
    @Size(max = 20)
    public String docNumber;

    /**
     * Дата документа.
     */
    @Size(max = 50)
    public String docDate;

    /**
     * Код гражданства.
     */
    @Size(max = 10)
    public String citizenshipCode;

    /**
     * Статус.
     */
    public String isIdentified;

    /**
     * Установка телефона с валлидацией.
     */
    public void setPhone(String phone) {
        if (phone.length() == 0) {
            this.phone = phone;
        } else if (phone.matches("^((8|\\+7)[\\- ]?)?(\\(?\\d{3}\\)?[\\- ]?)?[\\d\\- ]{7,10}$")) {
            this.phone = phone;
        } else throw new RuntimeException("Not valid phone string");
    }
}

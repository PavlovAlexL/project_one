package com.palex.practice.view.User;


import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

/**
 * View для валлидации создания User.
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

    /**
     * Устанвка телефона с валлидацией.
     *
     * @param phone
     */
    public void setPhone(String phone) {
        if (phone.length() == 0) {
            this.phone = phone;
        } else if (phone.matches("^((8|\\+7)[\\- ]?)?(\\(?\\d{3}\\)?[\\- ]?)?[\\d\\- ]{7,10}$")) {
            this.phone = phone;
        } else throw new RuntimeException("Not valid phone");
    }

    /**
     * Установка даты документа с валлидацией.
     * @param docDate
     */
    public void setDocDate(String docDate) {
        if (docDate.length() == 0) {
            this.docDate = docDate;
        } else if (docDate.matches("(0[1-9]|[12][0-9]|3[01])[- /.](0[1-9]|1[012])[- /.](19|20)\\d\\d")) {
            this.docDate = docDate;
        } else throw new RuntimeException("Not valid docDate");
    }
}

package com.palex.practice.view.Office;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * View для валлидации входных данных для обновления Office.
 */
public class OfficeUpdateFilterView {

    /**
     * Идентификатор.
     */
    @NotNull
    @Min(1)
    public Long id;

    /**
     * Наименование.
     */
    @NotNull
    @NotBlank
    @Size(max = 50)
    public String name;

    /**
     * Адрес.
     */
    @NotNull
    @NotBlank
    @Size(max = 200)
    public String address;

    /**
     * Телефон.
     */
    @Size(max = 20)
    public String phone;

    /**
     * Статус.
     */
    public String isActive;

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        if (phone.length() == 0) {
            this.phone = null;
        } else if (phone.matches("^((8|\\+7)[\\- ]?)?(\\(?\\d{3}\\)?[\\- ]?)?[\\d\\- ]{7,10}$")) {
            this.phone = phone;
        } else throw new RuntimeException("Not valid phone string");
    }

    public String getIsActive() {
        return isActive;
    }

    public void setIsActive(String isActive) {
        if (isActive.length() == 0){
            this.isActive = null;
        } else {
            this.isActive = isActive;
        }
    }
}

package com.palex.practice.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Version;

/**
 * Класс
 */
@Entity
@Table(name = "Office")
public class OfficeEntity {

    /**
     * Уникальный идентификатор
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    /**
     * Служебное поле Hibernate
     */
    @Version
    @Column (name="version", nullable = false)
    private Integer version;

    /**
     * Наименование
     */
    @Column(name = "name", length = 50)
    private String name;

    /**
     * Адрес
     */
    @Column(name="address", length = 200)
    private String address;

    /**
     * Телефон
     */
    @Column (name="phone", length = 20)
    private String phone;

    /**
     * Статус
     */
    @Column (name="isActive")
    private Boolean isActive;

    /**
     * Принадлежность к организации.
     */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "org_id", nullable = false)
    private OrganisationEntity organisation;

    /**
     * Конструктор для Hibernate.
     */
    public OfficeEntity() {
    }

    /**
     * Конструктор
     *
     * @param name         Имя.
     * @param address      адрес.
     * @param phone        телефон.
     * @param isActive     статус.
     * @param organisation принадлежность к организации.
     */
    public OfficeEntity(String name, String address, String phone, Boolean isActive, OrganisationEntity organisation) {
        this.name = name;
        this.address = address;
        this.phone = phone;
        this.isActive = isActive;
        this.organisation = organisation;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Boolean getIsActive() {
        return isActive;
    }

    public void setIsActive(Boolean isActive) {
        this.isActive = isActive;
    }

    public OrganisationEntity getOrganisation() {
        return organisation;
    }

    public void setOrganisation(OrganisationEntity organisation) {
        this.organisation = organisation;
    }

}

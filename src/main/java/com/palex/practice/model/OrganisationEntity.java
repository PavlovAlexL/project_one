package com.palex.practice.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Version;

@Entity
@Table(name="Organisation")
public class OrganisationEntity {

    /**
     * Уникальный идентификатор.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    /**
     * Служебное поле Hibernate.
     */
    @Version
    @Column (name="version", nullable = false)
    private Integer version;

    /**
     * Наименование организации.
     */
    @Column (name="name", nullable = false)
    private String name;

    /**
     * Полное наименование организации.
     */
    @Column(name="full_Name", nullable = false)
    private String fullName;

    /**
     * ИНН.
     */
    @Column(name="inn", nullable = false)
    private String inn;

    /**
     * КПП.
     */
    @Column(name="kpp", nullable = false)
    private String kpp;

    /**
     * Адрес.
     */
    @Column(nullable = false)
    private String address;

    /**
     * Телефон.
     */
    @Column(name="phone")
    private String phone;

    /**
     * Статус.
     */
    @Column(name="is_active")
    private Boolean isActive;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getInn() {
        return inn;
    }

    public void setInn(String inn) {
        this.inn = inn;
    }

    public String getKpp() {
        return kpp;
    }

    public void setKpp(String kpp) {
        this.kpp = kpp;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() { return phone; }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Boolean getIsActive() {
        return isActive;
    }

    public void setIsActive(Boolean isActive) {
        this.isActive = isActive;
    }


}

package com.palex.practice.model;

import org.aspectj.weaver.ast.Or;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name="Organisation")
public class OrganisationEntity {

    /**
     * Уникальный идентификатор
     */
    @Id
    @GeneratedValue
    @Column(name = "id", nullable = false)
    private Long id;

    /**
     * Служебное поле Hibernate
     */
    @Version
    private Integer version;

    /**
     * Название
     */
    @Column (name="name", nullable = false)
    private String name;

    /**
     * Полное название
     */
    @Column(name="fullName", nullable = false)
    private String fullName;

    /**
     * ИНН
     */
    @Column(name="inn", nullable = false)
    private String inn;

    /**
     * КПП
     */
    @Column(name="kpp", nullable = false)
    private String kpp;

    /**
     * Адресс
     */
    @Column(name="address", nullable = false)
    private String address;

    /**
     * Телефон
     */
    @Column(name="phone")
    private String phone;

    /**
     * Статус
     */
    @Column(name="isActive")
    private Boolean isActive;

    /**
     * Множество офисов, принадлежащих данной организации
     */
    private Set<OfficeEntity> offices;

    /**
     * Пустой конструктор для Hibernate
     */
    public OrganisationEntity() {
    }

    @OneToMany(mappedBy = "Organisation", cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name="org_id")
    public Set<OfficeEntity> getOffices(){
        if(offices == null){
            offices = new HashSet<>();
        }
        return this.offices;
    }

    public void setOffices(Set<OfficeEntity> offices){
        this.offices = offices;
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

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Boolean getActive() {
        return isActive;
    }

    public void setActive(Boolean active) {
        isActive = active;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof OrganisationEntity)) return false;
        OrganisationEntity that = (OrganisationEntity) o;
        return id.equals(that.id) &&
                version.equals(that.version) &&
                name.equals(that.name) &&
                fullName.equals(that.fullName) &&
                inn.equals(that.inn) &&
                kpp.equals(that.kpp) &&
                address.equals(that.address) &&
                Objects.equals(phone, that.phone) &&
                Objects.equals(isActive, that.isActive) &&
                Objects.equals(offices, that.offices);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, version, name, fullName, inn, kpp, address, phone, isActive, offices);
    }
}

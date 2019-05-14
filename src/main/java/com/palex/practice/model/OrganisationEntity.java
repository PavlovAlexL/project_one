package com.palex.practice.model;

import javax.persistence.*;
import java.util.Map;
import java.util.Set;

@Entity
@Table(name="Organisation")
public class OrganisationEntity {

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
     * Название
     */
    @Column (name="name", nullable = false)
    private String name;

    /**
     * Полное название
     */
    @Column(name="full_Name", nullable = false)
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
    @Column(nullable = false)
    private String address;

    /**
     * Телефон
     */
    @Column(name="phone")
    private String phone;

    /**
     * Статус
     */
    @Column(name="is_active")
    private Boolean isActive;

    /**
     * Множество офисов, принадлежащих данной организации
     */
    @OneToMany(mappedBy = "organisation", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<OfficeEntity> offices;

    public OrganisationEntity(){
    }

    public OrganisationEntity(Map<String, String> params){
                if(params.containsKey("id")) {
                    this.id = Long.parseLong(params.get("id"));
                }
                this.name = params.get("name");
                this.fullName = params.get("fullName");
                this.inn = params.get("inn");
                this.kpp = params.get("kpp");
                this.address = params.get("address");
                this.phone = params.get("phone");
                this.isActive = Boolean.parseBoolean(params.get("isActive"));
    }


    public Long getId() {
        return id;
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
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

    public void setOffices(Set<OfficeEntity> offices) {
        this.offices = offices;
    }

    public Set<OfficeEntity> getOffices() {
        return offices;
    }

}

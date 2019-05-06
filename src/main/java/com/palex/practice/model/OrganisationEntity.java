package com.palex.practice.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Map;
import java.util.Objects;
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
    private String full_Name;

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
    private Boolean is_active;

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
                this.full_Name = params.get("fullName");
                this.inn = params.get("inn");
                this.kpp = params.get("kpp");
                this.address = params.get("address");
                this.phone = params.get("phone");
                this.is_active = Boolean.parseBoolean(params.get("isActive"));
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

    public String getFull_Name() {
        return full_Name;
    }

    public void setFull_Name(String full_Name) {
        this.full_Name = full_Name;
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

    public Boolean getIs_active() {
        return is_active;
    }

    public void setIs_active(Boolean is_active) {
        this.is_active = is_active;
    }

    public void setOffices(Set<OfficeEntity> offices) {
        this.offices = offices;
    }

    public Set<OfficeEntity> getOffices() {
        return offices;
    }

    @Override
    public String toString() {
        return "OrganisationEntity{" +
                "id=" + id +
                ", version=" + version +
                ", name='" + name + '\'' +
                ", full_Name='" + full_Name + '\'' +
                ", inn='" + inn + '\'' +
                ", kpp='" + kpp + '\'' +
                ", address='" + address + '\'' +
                ", phone='" + phone + '\'' +
                ", is_active=" + is_active +
                ", offices=" + offices +
                '}';
    }
}

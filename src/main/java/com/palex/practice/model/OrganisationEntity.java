package com.palex.practice.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Column;
import javax.persistence.Version;
import javax.persistence.OneToMany;
import javax.persistence.JoinColumn;
import javax.persistence.CascadeType;
import javax.persistence.GenerationType;
import java.util.HashSet;
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
    @Column(nullable = false)
    private String address;

    /**
     * Телефон
     */
    private String phone;

    /**
     * Статус
     */
    private Boolean isActive;

    /**
     * Множество офисов, принадлежащих данной организации
     */
    @OneToMany(mappedBy = "organisation", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<OfficeEntity> offices;

    /**
     * Пустой конструктор для Hibernate
     */
    public OrganisationEntity() {
    }


    public Set<OfficeEntity> getOffices(){
        if(offices == null){
            offices = new HashSet<>();
        }
        return this.offices;
    }

}

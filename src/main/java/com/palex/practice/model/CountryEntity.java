package com.palex.practice.model;

import javax.persistence.*;

@Entity
@Table(name = "Country")
public class CountryEntity {

    /**
     * Уникальный идентификатор
     */
    @Id
    @Column(name="id",nullable = false)
    private Long id;

    /**
     * Код страны
     */
    @Column(name="code", length = 10)
    private String code;

    /**
     * Название страны
     */
    @Column(name="name", length = 50)
    private String name;

    /**
     * Принадлежность к сотруднику
     */
    @OneToOne(fetch = FetchType.LAZY)
    @MapsId
    @JoinColumn(name = "country")
    private UserEntity user;

    /**
     * Конструктор по умолчанию для Hibernate
     */
    public CountryEntity(){

    }

}

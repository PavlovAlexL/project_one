package com.palex.practice.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

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
     * Конструктор по умолчанию для Hibernate
     */

    public CountryEntity(){

    }

}

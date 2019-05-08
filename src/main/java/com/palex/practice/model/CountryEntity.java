package com.palex.practice.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Column;

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

    public Long getId() {
        return id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "CountryEntity{" +
                "id=" + id +
                ", code='" + code + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}

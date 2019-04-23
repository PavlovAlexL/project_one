package com.palex.practice.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Column;
import javax.persistence.OneToOne;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.MapsId;
import java.util.Objects;


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

    public UserEntity getUser() {
        return user;
    }

    public void setUser(UserEntity user) {
        this.user = user;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CountryEntity)) return false;
        CountryEntity that = (CountryEntity) o;
        return getCode().equals(that.getCode()) &&
                getName().equals(that.getName()) &&
                getUser().equals(that.getUser());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getCode(), getName(), getUser());
    }
}

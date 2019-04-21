package com.palex.practice.model;


import javax.persistence.*;
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
     * Связь с владельцем объекта
     */
    @OneToOne
    @MapsId
    @JoinColumn(name="citizenship_id")
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
        return id.equals(that.id) &&
                code.equals(that.code) &&
                name.equals(that.name) &&
                Objects.equals(user, that.user);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, code, name, user);
    }
}

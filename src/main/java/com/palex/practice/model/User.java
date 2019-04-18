package com.palex.practice.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Класс сотрудник.
 */

@Entity
@Table(name = "User")
public class User {
    /**
     * Identification
     */
    @Id
    @GeneratedValue
    private Long id;

    /**
     * Специальный класс Hibernate
     */
    @Version
    private Integer version;
    /**
     * Идентификатор офиса
     */
    @ManyToMany(mappedBy = "Office")
    private Set<Office> office_id;
    /**
     *Имя
     */
    @Column(name = "firstName", length = 50, nullable = false)
    private String firstName;
    /**
     * Фамилия
     */
    @Column(name = "secondName", length = 50)
    private String secondName;
    /**
     * Отчество
     */
    @Column(name = "middleName", length = 50)
    private String middleName;
    /**
     * Должность
     */
    @Column(name = "position", length = 100, nullable = false)
    private String position;
    /**
     * Телефон
     */
    @Column(name = "phone", length = 11)
    private String phone;
    /**
     * Идентификатор документа в таблице документов
     */
    @ManyToMany(mappedBy = "User_document")
    private Set<User_document> document_id;
    /**
     * Идентификатор гражданства
     */
    @ManyToMany(mappedBy = "Country")
    private Set<Country> citizenship_id;
    /**
     * Прошел ли сотрудник идентификацию
     */
    private Boolean is_Identified;

    public Long getId() {
        return id;
    }


    public Set<Office> getOffice_id() {
        if(office_id == null) {
            office_id = new HashSet<>();
        }
        return office_id;
    }

    public void setOffice_id(Set<Office> office_id) {
        this.office_id = office_id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Set<User_document> getDocument_id() {
        if(document_id == null){
            document_id = new HashSet<>();
        }
        return document_id;
    }

    public void setDocument_id(Set<User_document> document_id) {
        if(document_id == null){
            document_id = new HashSet<>();
            }
        this.document_id = document_id;
    }

    public Set<Country> getCitizenship_id() {
        return citizenship_id;
    }

    public void setCitizenship_id(Set<Country> citizenship_id) {
        this.citizenship_id = citizenship_id;
    }

    public Boolean getIs_Identified() {
        return is_Identified;
    }

    public void setIs_Identified(Boolean is_Identified) {
        this.is_Identified = is_Identified;
    }
}

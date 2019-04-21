package com.palex.practice.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/**
 * Класс сотрудник.
 */

@Entity
@Table(name = "User")
public class UserEntity {

    /**
     * Уникальный идентификатор
     */
    @Id
    @GeneratedValue
    @Column(name="id",nullable = false)
    private Long id;

    /**
     * Специальный поле Hibernate
     */
    @Version
    private Integer version;

    /**
     * Офис
     */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="office_id", nullable = false)
    private OfficeEntity officeEntity;

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
    //@ManyToOne(fetch = FetchType.LAZY)
    //@JoinColumn(name="document_id")
    @OneToOne(mappedBy = "User", cascade = CascadeType.ALL)
    private UserDocumentEntity userDocumentEntity;

    /**
     * Идентификатор гражданства
     */
    //@ManyToOne(fetch = FetchType.LAZY)
    //@JoinColumn(name="citizenship_id")
    @OneToOne(mappedBy = "User", cascade = CascadeType.ALL)
    private CountryEntity countryEntity;

    /**
     * Прошел ли сотрудник идентификацию
     */
    private Boolean is_Identified;


    /**
     * Конструктор поумолчанию дял Hibernate
     */
    public UserEntity(){

    }

    public Long getId() {
        return id;
    }

    public OfficeEntity getOfficeEntity() {
        return officeEntity;
    }

    public void setOfficeEntity(OfficeEntity officeEntity) {
        this.officeEntity = officeEntity;
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

    public UserDocumentEntity getUserDocumentEntity() {
        return userDocumentEntity;
    }

    public void setUserDocumentEntity(UserDocumentEntity userDocumentEntity) {
        this.userDocumentEntity = userDocumentEntity;
    }

    public CountryEntity getCountryEntity() {
        return countryEntity;
    }

    public void setCountryEntity(CountryEntity countryEntity) {
        this.countryEntity = countryEntity;
    }

    public Boolean getIs_Identified() {
        return is_Identified;
    }

    public void setIs_Identified(Boolean is_Identified) {
        this.is_Identified = is_Identified;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof UserEntity)) return false;
        UserEntity that = (UserEntity) o;
        return id.equals(that.id) &&
                Objects.equals(version, that.version) &&
                officeEntity.equals(that.officeEntity) &&
                firstName.equals(that.firstName) &&
                Objects.equals(secondName, that.secondName) &&
                Objects.equals(middleName, that.middleName) &&
                position.equals(that.position) &&
                Objects.equals(phone, that.phone) &&
                Objects.equals(userDocumentEntity, that.userDocumentEntity) &&
                Objects.equals(countryEntity, that.countryEntity) &&
                Objects.equals(is_Identified, that.is_Identified);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, version, officeEntity, firstName, secondName, middleName, position, phone, userDocumentEntity, countryEntity, is_Identified);
    }
}

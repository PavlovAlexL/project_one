package com.palex.practice.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Column;
import javax.persistence.Version;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;

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
    @Column (name="version", nullable = false)
    private Integer version;

    /**
     * Офис
     */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="office_id", nullable = false)
    private OfficeEntity office;

    /**
     *Имя
     */
    @Column(name = "first_Name", length = 50, nullable = false)
    private String first_Name;

    /**
     * Фамилия
     */
    @Column(name = "second_Name", length = 50)
    private String second_Name;

    /**
     * Отчество
     */
    @Column(name = "middle_Name", length = 50)
    private String middle_Name;

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
     * Прошел ли сотрудник идентификацию
     */
    @Column (name="is_identified")
    private Boolean is_identified;

    /**
     * Идентификатор документа в таблице документов
     */
    @OneToOne
    @JoinColumn(name="document_id")
    private UserDocumentEntity userDocument;

    /**
     * Идентификатор гражданства
     */
    @OneToOne
    @JoinColumn(name="itizenship_id")
    private CountryEntity country;

    public Long getId() {
        return id;
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    public OfficeEntity getOffice() {
        return office;
    }

    public void setOffice(OfficeEntity office) {
        this.office = office;
    }

    public String getFirstName() {
        return first_Name;
    }

    public void setFirstName(String firstName) {
        this.first_Name = firstName;
    }

    public String getSecondName() {
        return second_Name;
    }

    public void setSecondName(String secondName) {
        this.second_Name = secondName;
    }

    public String getMiddleName() {
        return middle_Name;
    }

    public void setMiddleName(String middleName) {
        this.middle_Name = middleName;
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

    public Boolean getIs_identified() {
        return is_identified;
    }

    public void setIs_identified(Boolean is_identified) {
        this.is_identified = is_identified;
    }

    public UserDocumentEntity getUserDocument() {
        return userDocument;
    }

    public void setUserDocument(UserDocumentEntity userDocument) {
        this.userDocument = userDocument;
    }

    public CountryEntity getCountry() {
        return country;
    }

    public void setCountry(CountryEntity country) {
        this.country = country;
    }

}

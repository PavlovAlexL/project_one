package com.palex.practice.model;

import javax.persistence.*;
import java.util.Map;

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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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
    private String firstName;

    /**
     * Фамилия
     */
    @Column(name = "last_Name", length = 50)
    private String lastName;

    /**
     * Отчество
     */
    @Column(name = "middle_Name", length = 50)
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
     * Прошел ли сотрудник идентификацию
     */
    @Column (name="is_identified")
    private Boolean isIdentified;

    /**
     * Идентификатор документа в таблице документов
     */
    @OneToOne(cascade = {CascadeType.ALL})
    @JoinColumn(name="document_id")
    private UserDocumentEntity userDocument;

    /**
     * Идентификатор гражданства
     */
    @ManyToOne(cascade = {CascadeType.ALL}, fetch = FetchType.LAZY)
    @JoinColumn(name="citizenship_id")
    private CountryEntity country;

    public UserEntity(){
    }


    public UserEntity(Map<String, String> params, OfficeEntity officeEntity, UserDocumentEntity userDocumentEntity, CountryEntity countryEntity){

        this.office = officeEntity;
        this.firstName = params.get("firstName");
        this.lastName = params.get("lastName");
        this.middleName = params.get("middleName");
        this.position = params.get("position");
        this.phone = params.get("phone");
        if(userDocumentEntity != null){
            System.out.println("one");
            this.userDocument = userDocumentEntity;
        }
        if(countryEntity != null){
            System.out.println("two");
            this.country = countryEntity;
        }
        this.isIdentified = Boolean.parseBoolean(params.get("isIdentified"));


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

    public OfficeEntity getOffice() {
        return office;
    }

    public void setOffice(OfficeEntity office) {
        this.office = office;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
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

    public Boolean getIsIdentified() {
        return isIdentified;
    }

    public void setIsIdentified(Boolean isIdentified) {
        this.isIdentified = isIdentified;
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

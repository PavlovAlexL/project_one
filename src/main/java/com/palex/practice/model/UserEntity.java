package com.palex.practice.model;

import com.palex.practice.service.DocksTypeService;

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
    @OneToOne(cascade = {CascadeType.ALL})
    @JoinColumn(name="document_id")
    private UserDocumentEntity userDocument;

    /**
     * Идентификатор гражданства
     */
    @OneToOne(cascade = {CascadeType.ALL})
    @JoinColumn(name="citizenship_id")
    private CountryEntity country;

    public UserEntity(){
    }


    public UserEntity(Map<String, String> params, OfficeEntity officeEntity, UserDocumentEntity userDocumentEntity, CountryEntity countryEntity){

        this.office = officeEntity;
        this.first_Name = params.get("firstName");
        this.second_Name = params.get("secondName");
        this.middle_Name = params.get("middleName");
        this.position = params.get("position");
        this.phone = params.get("phone");
        this.userDocument = userDocumentEntity;
        this.country = countryEntity;
        this.is_identified = Boolean.parseBoolean(params.get("isidentified"));

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

    @Override
    public String toString() {
        return "UserEntity{" +
                "id=" + id +
                ", version=" + version +
                ", office=" + office +
                ", first_Name='" + first_Name + '\'' +
                ", second_Name='" + second_Name + '\'' +
                ", middle_Name='" + middle_Name + '\'' +
                ", position='" + position + '\'' +
                ", phone='" + phone + '\'' +
                ", is_identified=" + is_identified +
                ", userDocument=" + userDocument +
                ", country=" + country +
                '}';
    }
}

package com.palex.practice.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Column;
import javax.persistence.Version;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.CascadeType;
import java.util.HashSet;
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
    ////@OneToOne(mappedBy = "User", cascade = CascadeType.ALL)
    //private UserDocumentEntity userDocumentEntity;

    /**
     * Идентификатор гражданства
     */
    //@ManyToOne(fetch = FetchType.LAZY)
    //@JoinColumn(name="citizenship_id")
    ////@OneToOne(mappedBy = "User", cascade = CascadeType.ALL)
    //private CountryEntity countryEntity;

    /**
     * Прошел ли сотрудник идентификацию
     */
    private Boolean is_Identified;


    /**
     * Конструктор поумолчанию дял Hibernate
     */
    public UserEntity(){

    }

}

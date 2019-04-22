package com.palex.practice.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Column;
import javax.persistence.Version;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.util.Date;


@Entity
@Table(name = "User_document")
public class UserDocumentEntity {

    /**
     * Уникальный идентификатор
     */
    @Id
    @GeneratedValue
    @Column(name="id",nullable = false)
    private Long id;

    /**
     * Специальный класс Hibernate
     */
    @Version
    private Integer version;

    /**
     * Тип документа
     */
    //@ManyToOne(fetch = FetchType.LAZY)
    //@JoinColumn (name="id")
    //@Column(name = "doc_type_id")
    //private Long doc_type_id;

    /**
     * Номер документа
     */
    @Column(name = "doc_Number", length = 20)
    private String doc_Number;

    /**
     * Дата документа
     */
    @Column(name="doc_Date")
    @Temporal(TemporalType.DATE)
    private Date doc_Date;

    /**
     * Владелец документа
     */
    //@OneToOne
    //@MapsId
    //@JoinColumn(name = "document_id")
    //@ManyToOne(fetch = FetchType.LAZY)
    //@JoinColumn (name="org_id", nullable = false)
    //private UserEntity user;

    /**
     * Связь с таблицей типов докумнетов
     */
    //@OneToOne(mappedBy = "User_document", cascade = CascadeType.ALL)
    //private DocumentTypeEntity documentTypeEntity;


    /**
     * Конструктор для Hibernate
     */
    public UserDocumentEntity() {
    }

}

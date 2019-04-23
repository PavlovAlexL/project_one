package com.palex.practice.model;

import javax.persistence.*;

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
     * Принадлежность к сструднику
     */
    @OneToOne
    @MapsId
    @JoinColumn(name = "userDocument")
    private UserEntity user;

    /**
     * Связь с таблицей типов докумнетов
     */
    @OneToOne(mappedBy = "userDocument", cascade = CascadeType.ALL)
    private DocumentTypeEntity documentType;

    /**
     * Конструктор для Hibernate
     */
    public UserDocumentEntity() {
    }

}

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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id",nullable = false)
    private Long id;

    /**
     * Специальный класс Hibernate
     */
    @Version
    @Column (name="version", nullable = false)
    private Integer version;

    /**
     * Номер документа
     */
    @Column(name = "doc_number", length = 20)
    private String doc_number;

    /**
     * Дата документа
     */
    @Column(name="doc_date")
    @Temporal(TemporalType.DATE)
    private Date doc_date;

    /**
     * Связь с таблицей типов докумнетов
     */
    @OneToOne
    @JoinColumn(name="doc_type_id", nullable = false)
    private DocumentTypeEntity documentType;


    public Long getId() {
        return id;
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    public String getDoc_number() {
        return doc_number;
    }

    public void setDoc_number(String doc_number) {
        this.doc_number = doc_number;
    }

    public Date getDoc_date() {
        return doc_date;
    }

    public void setDoc_date(Date doc_date) {
        this.doc_date = doc_date;
    }

    public DocumentTypeEntity getDocumentType() {
        return documentType;
    }

    public void setDocumentType(DocumentTypeEntity documentType) {
        this.documentType = documentType;
    }

}

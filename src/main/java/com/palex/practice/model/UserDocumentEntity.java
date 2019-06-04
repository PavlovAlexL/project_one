package com.palex.practice.model;


import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Version;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Класс, описывающий документы пользователя.
 */
@Entity
@Table(name = "User_document")
public class UserDocumentEntity {

    /**
     * Уникальный идентификатор.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id",nullable = false)
    //@MapsId
    private Long id;

    /**
     * Служебное поле Hibernate.
     */
    @Version
    @Column (name="version", nullable = false)
    private Integer version;

    /**
     * Номер документа.
     */
    @Column(name = "doc_number", length = 20)
    private String docNumber;

    /**
     * Дата документа.
     */
    @Column(name="doc_date")
    @Temporal(TemporalType.DATE)
    private Date docDate;

    /**
     * Связь с таблицей типов докумнетов.
     */
    @OneToOne(cascade = {CascadeType.ALL})
    @JoinColumn(name="doc_type_id", nullable = false)
    private DocumentTypeEntity documentType;

    /**
     * Конструктор поумолчанию, нужен для Hibernate.
     */
    public UserDocumentEntity() {
    }

    /**
     * Конструктор объекта.
     * @param docNumber Номер документа.
     * @param docDate Дата документа.
     * @param documentTypeEntity Тип документа.
     */
    public UserDocumentEntity(String docNumber, String docDate, DocumentTypeEntity documentTypeEntity) {

        this.documentType = documentTypeEntity;
        this.docNumber = docNumber;
        try {
            DateFormat format = new SimpleDateFormat("dd.MM.yy");
            this.docDate = format.parse(docDate);
        } catch (ParseException e){
            throw new RuntimeException(e);
        }
    }

    /**
     * Конструктор нужен для вывода списка пользователей по типу документа.
     * @param documentTypeEntity тип документа.
     */
    public UserDocumentEntity(DocumentTypeEntity documentTypeEntity) {
        this.documentType = documentTypeEntity;
    }

    public Long getId() {
        return id;
    }

    public String getDocNumber() {
        return docNumber;
    }

    public void setDocNumber(String docNumber) {
        this.docNumber = docNumber;
    }

    public Date getDocDate() {
        return docDate;
    }

    public void setDocDate(Date docDate) {
        this.docDate = docDate;
    }

    public void setDoc_date(String date) {
        DateFormat format = new SimpleDateFormat("dd.MM.yy");
        try {
            this.docDate = format.parse(date);
        } catch (ParseException e){
            throw new RuntimeException(e);
        }
    }

    public DocumentTypeEntity getDocumentType() {
        return documentType;
    }

    public void setDocumentType(DocumentTypeEntity documentType) {
        this.documentType = documentType;
    }

}

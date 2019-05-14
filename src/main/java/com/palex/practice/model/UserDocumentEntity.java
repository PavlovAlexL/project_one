package com.palex.practice.model;

import javax.persistence.*;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
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
    private String docNumber;

    /**
     * Дата документа
     */
    @Column(name="doc_date")
    @Temporal(TemporalType.DATE)
    private Date docDate;

    /**
     * Связь с таблицей типов докумнетов
     */
    @OneToOne(cascade = {CascadeType.ALL})
    @JoinColumn(name="doc_type_id", nullable = false)
    private DocumentTypeEntity documentType;

    public UserDocumentEntity(){
    }

    public UserDocumentEntity(String docNumber, String docDate, DocumentTypeEntity documentTypeEntity) {

        this.documentType = documentTypeEntity;
        this.docNumber = docNumber;
        try {
            DateFormat format = new SimpleDateFormat("dd.MM.yy");
            this.docDate = format.parse(docDate);
        } catch (ParseException e){
            e.printStackTrace();
        }
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
        }catch (ParseException e){
            e.getStackTrace();
        }
    }

    public DocumentTypeEntity getDocumentType() {
        return documentType;
    }

    public void setDocumentType(DocumentTypeEntity documentType) {
        this.documentType = documentType;
    }

}

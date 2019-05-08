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
    @OneToOne(cascade = {CascadeType.ALL})
    @JoinColumn(name="doc_type_id", nullable = false)
    private DocumentTypeEntity documentType;

    public UserDocumentEntity(){
    }

    public UserDocumentEntity(String docNumber, String docDate, DocumentTypeEntity documentTypeEntity) {

        this.documentType = documentTypeEntity;
        this.doc_number = docNumber;
        try {
            DateFormat format = new SimpleDateFormat("dd.MM.yy");
            this.doc_date = format.parse(docDate);
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

    public void setDoc_date(String date) {
        DateFormat format = new SimpleDateFormat("dd.MM.yy");
        try {
            this.doc_date = format.parse(date);
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

    @Override
    public String toString() {
        return "UserDocumentEntity{" +
                "id=" + id +
                ", version=" + version +
                ", doc_number='" + doc_number + '\'' +
                ", doc_date=" + doc_date +
                ", documentType=" + documentType +
                '}';
    }
}

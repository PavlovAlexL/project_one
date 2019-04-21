package com.palex.practice.model;

import javax.persistence.*;
import java.util.Date;
import java.util.Objects;

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
    @Column(name = "doc_type_id")
    private Long doc_type_id;

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
    @OneToOne
    @MapsId
    @JoinColumn(name = "document_id")
    private UserEntity user;

    /**
     * Связь с таблицей типов докумнетов
     */
    @OneToOne(mappedBy = "User_document", cascade = CascadeType.ALL)
    private DocumentTypeEntity documentTypeEntity;


    /**
     * Конструктор для Hibernate
     */
    public UserDocumentEntity() {
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

    public Long getDoc_type_id() {
        return doc_type_id;
    }

    public void setDoc_type_id(Long doc_type_id) {
        this.doc_type_id = doc_type_id;
    }

    public String getDoc_Number() {
        return doc_Number;
    }

    public void setDoc_Number(String doc_Number) {
        this.doc_Number = doc_Number;
    }

    public Date getDoc_Date() {
        return doc_Date;
    }

    public void setDoc_Date(Date doc_Date) {
        this.doc_Date = doc_Date;
    }

    public UserEntity getUser() {
        return user;
    }

    public void setUser(UserEntity user) {
        this.user = user;
    }

    public DocumentTypeEntity getDocumentTypeEntity() {
        return documentTypeEntity;
    }

    public void setDocumentTypeEntity(DocumentTypeEntity documentTypeEntity) {
        this.documentTypeEntity = documentTypeEntity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof UserDocumentEntity)) return false;
        UserDocumentEntity that = (UserDocumentEntity) o;
        return id.equals(that.id) &&
                version.equals(that.version) &&
                doc_type_id.equals(that.doc_type_id) &&
                doc_Number.equals(that.doc_Number) &&
                doc_Date.equals(that.doc_Date) &&
                Objects.equals(user, that.user) &&
                Objects.equals(documentTypeEntity, that.documentTypeEntity);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, version, doc_type_id, doc_Number, doc_Date, user, documentTypeEntity);
    }
}

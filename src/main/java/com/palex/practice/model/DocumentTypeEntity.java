package com.palex.practice.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Column;
import javax.persistence.OneToOne;
import javax.persistence.JoinColumn;
import javax.persistence.MapsId;
import java.util.Objects;


@Entity
@Table(name = "Document_type")
public class DocumentTypeEntity {

    /**
     * Уникальный идентификатор
     */
    @Id
    @Column(name="id",nullable = false)
    private Long id;

    /**
     * Doc code
     */
    @Column(name="code", length = 10, nullable = false)
    private String code;

    /**
     * Doc name
     */
    @Column(name="name", length = 100, nullable = false)
    private String name;

    /**
     * Принадлежность к типу документа
     */
    @OneToOne
    @MapsId
    @JoinColumn(name = "documentType")
    private UserDocumentEntity userDocument;

    /**
     * Конструктор по умолчанию для Hibernate
     */
    public DocumentTypeEntity(){

    }

    public Long getId() {
        return id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public UserDocumentEntity getUserDocument() {
        return userDocument;
    }

    public void setUserDocument(UserDocumentEntity userDocument) {
        this.userDocument = userDocument;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof DocumentTypeEntity)) return false;
        DocumentTypeEntity that = (DocumentTypeEntity) o;
        return getCode().equals(that.getCode()) &&
                getName().equals(that.getName()) &&
                getUserDocument().equals(that.getUserDocument());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getCode(), getName(), getUserDocument());
    }
}

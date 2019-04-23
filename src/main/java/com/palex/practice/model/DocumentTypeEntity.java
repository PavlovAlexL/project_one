package com.palex.practice.model;

import javax.persistence.*;

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


}

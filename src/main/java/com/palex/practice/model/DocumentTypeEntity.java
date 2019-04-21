package com.palex.practice.model;

import javax.persistence.*;
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
     * Связь с владельцем объекта
     */
    @OneToOne
    @MapsId
    @JoinColumn(name="doc_type_id")
    private UserDocumentEntity userDocumentEntity;

    /**
     * Конструктор по умолчанию для Hibernate
     */
    public DocumentTypeEntity(){

    }


}

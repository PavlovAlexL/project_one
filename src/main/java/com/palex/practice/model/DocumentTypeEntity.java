package com.palex.practice.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

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
     * Конструктор по умолчанию для Hibernate
     */
    public DocumentTypeEntity(){

    }


}

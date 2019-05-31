package com.palex.practice.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Column;

/**
 * Класс справочник, сопоставляющий наименование и код документа
 */
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
     * Код документа
     */
    @Column(name="code", length = 10, nullable = false)
    private String code;

    /**
     * Наименование документа
     */
    @Column(name="name", length = 100, nullable = false)
    private String name;

    /**
     * Конструктор по умолчанию, нужен для Hibernate
     */
    public DocumentTypeEntity(){
    }

    /**
     * Параметризированный конструктор
     * @param code Код документа
     * @param name Наименование докумнта
     */
    public DocumentTypeEntity(String code, String name) {
        this.code = code;
        this.name = name;
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

}

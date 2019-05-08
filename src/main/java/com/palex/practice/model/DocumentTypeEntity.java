package com.palex.practice.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Column;

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

    public DocumentTypeEntity(){
    }

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

    @Override
    public String toString() {
        return "DocumentTypeEntity{" +
                "id=" + id +
                ", code='" + code + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}

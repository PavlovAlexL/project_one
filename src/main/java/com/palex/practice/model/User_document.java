package com.palex.practice.model;

import javax.persistence.*;
import java.sql.Date;

public class User_document {

    /**
     * Identification
     */
    @Id
    @GeneratedValue
    private Long id;

    /**
     * Специальный класс Hibernate
     */
    @Version
    private Integer version;

    /**
     * id типа документа
     */
    private Long doc_type_id;

    /**
     * Номер документа
     */
    private String doc_Number;  //VARCHAR(20) ,

    /**
     * Дата документа
     */
    @Temporal(TemporalType.DATE)
    @Column(name="doc_Date")
    private Date doc_Date;

    public User_document() {
    }
}

package com.palex.practice.model;


import javax.persistence.Entity;

@Entity
public class Office {
    private Long id;            //          INTEGER AUTO_INCREMENT NOT NULL PRIMARY KEY,
    private Integer version;    //     INTEGER,
    private Long org_Id;        //      INTEGER NOT NULL REFERENCES Organization(id),
    private String name;        //        VARCHAR(50),
    private String address;     //     VARCHAR(200),
    private String phone;       //       VARCHAR(20),
    private Boolean isActive;   //    BOOLEAN
}

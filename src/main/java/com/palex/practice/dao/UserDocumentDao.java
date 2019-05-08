package com.palex.practice.dao;

import com.palex.practice.model.DocumentTypeEntity;
import com.palex.practice.model.UserDocumentEntity;

import java.sql.Date;

public interface UserDocumentDao {
    UserDocumentEntity getById(Long id);
    void save(String number, Date date, DocumentTypeEntity documentTypeEntity);
    void update (String number, String date, DocumentTypeEntity documentTypeEntity);
}

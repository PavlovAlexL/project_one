package com.palex.practice.dao;

import com.palex.practice.model.DocumentTypeEntity;

import java.util.List;

/**
 * DAO для доступа к типам документов
 */
public interface DocumentTypeDao {

    List<DocumentTypeEntity> getAll();

    DocumentTypeEntity getByCode(String code);

    DocumentTypeEntity getByName(String name);

}

package com.palex.practice.dao;

import com.palex.practice.model.DocumentTypeEntity;

import java.util.List;

/**
 * DAO для доступа к типам документов
 */
public interface DocumentTypeDao {

    /**
     * Получить список типов документов.
     *
     * @return объект.
     */
    List<DocumentTypeEntity> getAll();

    /**
     * Получить по коду документа.
     * @param code Код.
     * @return объект.
     */
    DocumentTypeEntity getByCode(String code);

    /**
     * Получить по имени документу.
     * @param name Иия.
     * @return объект.
     */
    DocumentTypeEntity getByName(String name);

}

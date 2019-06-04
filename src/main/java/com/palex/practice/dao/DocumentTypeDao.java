package com.palex.practice.dao;

import com.palex.practice.model.DocumentTypeEntity;

import java.util.List;

/**
 * DAO для доступа к типам документов
 */
public interface DocumentTypeDao {

    /**
     * Получить список типов документов.
     * @return Список типов документов.
     */
    List<DocumentTypeEntity> getAll();

    /**
     * Получить по коду документа.
     * @param code Код.
     * @return Документ.
     */
    DocumentTypeEntity getByCode(String code);

    /**
     * Получить по имени документа.
     * @param name Иия.
     * @return Документ.
     */
    DocumentTypeEntity getByName(String name);

}

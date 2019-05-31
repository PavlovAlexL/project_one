package com.palex.practice.dao;

import com.palex.practice.model.DocumentTypeEntity;
import com.palex.practice.model.UserDocumentEntity;

/**
 * DAO для работы с UserDocument
 */
public interface UserDocumentDao {

    /**
     * Запрос по id
     * @param id Идернтификатор
     * @return Объект UserDocumentEntity
     */
    UserDocumentEntity getById(Long id);

    /**
     * Сохранить документ пользователя
     * @param number Номер документа
     * @param date Дата документа
     * @param documentTypeEntity Объект UserDocumetnEntity
     */
    void save(String number, String date, DocumentTypeEntity documentTypeEntity);

    /**
     * Обновить документ пользователя
     * @param number
     * @param date
     * @param documentTypeEntity
     */
    void update(String number, String date, DocumentTypeEntity documentTypeEntity);
}

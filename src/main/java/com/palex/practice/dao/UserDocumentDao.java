package com.palex.practice.dao;

import com.palex.practice.model.UserDocumentEntity;

/**
 * DAO для работы с документом пользователя.
 */
public interface UserDocumentDao {

    /**
     * Запрос по идентификатору.
     * @param id Идентификатор.
     * @return Объект UserDocumentEntity.
     */
    UserDocumentEntity getById(Long id);

    /**
     * Сохранить документ пользователя
     * @param userDocumentEntity документ.
     */
    void save(UserDocumentEntity userDocumentEntity);

    /**
     * Обновить документ пользователя
     * @param userDocumentEntity документ.
     */
    void update(UserDocumentEntity userDocumentEntity);
}

package com.palex.practice.dao.impl;

import com.palex.practice.dao.UserDocumentDao;
import com.palex.practice.model.UserDocumentEntity;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;

/**
 * Реализация DAO для работы с UserDocument.
 */
@Repository
public class UserDocumentDaoImpl implements UserDocumentDao {

    private final EntityManager em;

    public UserDocumentDaoImpl(EntityManager em) {
        this.em = em;
    }

    /**
     * Запрос по идентификатору.
     * @param id Идентификатор.
     * @return Объект UserDocumentEntity.
     */
    @Override
    public UserDocumentEntity getById(Long id) {
        return em.find(UserDocumentEntity.class, id);
    }

    /**
     * Сохранить документ пользователя
     * @param userDocumentEntity документ.
     */
    @Override
    public void save(UserDocumentEntity userDocumentEntity) {
        em.persist(userDocumentEntity);
    }

    /**
     * Обновить документ пользователя
     * @param userDocumentEntity документ.
     */
    @Override
    public void update(UserDocumentEntity userDocumentEntity) {
        em.merge(userDocumentEntity);

    }
}

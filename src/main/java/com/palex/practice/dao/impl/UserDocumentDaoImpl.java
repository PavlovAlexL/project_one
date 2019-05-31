package com.palex.practice.dao.impl;

import com.palex.practice.dao.UserDocumentDao;
import com.palex.practice.model.DocumentTypeEntity;
import com.palex.practice.model.UserDocumentEntity;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.sql.Date;

/**
 * DAO для работы с UserDocument
 */
@Repository
public class UserDocumentDaoImpl implements UserDocumentDao {

    private final EntityManager em;

    public UserDocumentDaoImpl(EntityManager em) {
        this.em = em;
    }

    /**
     * Запрос по id
     * @param id
     * @return
     */
    @Override
    public UserDocumentEntity getById(Long id) {
        return em.find(UserDocumentEntity.class, id);
    }

    /**
     *
     * @param number
     * @param date
     * @param documentTypeEntity
     */
    @Override
    public void save(String number, String date, DocumentTypeEntity documentTypeEntity) {
        em.persist(new UserDocumentEntity(number, date, documentTypeEntity));
    }

    /**
     *
     * @param number
     * @param date
     * @param documentTypeEntity
     */
    @Override
    public void update(String number, String date, DocumentTypeEntity documentTypeEntity) {
        em.merge(new UserDocumentEntity(number, date, documentTypeEntity));

    }
}

package com.palex.practice.dao;

import com.palex.practice.model.DocumentTypeEntity;
import com.palex.practice.model.UserDocumentEntity;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.sql.Date;


@Repository
public class UserDocumentDaoImpl implements UserDocumentDao {

    private final EntityManager em;

    public UserDocumentDaoImpl(EntityManager em) {
        this.em = em;
    }

    @Transactional
    @Override
    public UserDocumentEntity getById(Long id) {
        return em.find(UserDocumentEntity.class, id);
    }

    @Transactional
    @Override
    public void save(String number, Date date, DocumentTypeEntity documentTypeEntity) {
        System.out.println("34");
    }

    @Transactional
    @Override
    public void update(String number, String date, DocumentTypeEntity documentTypeEntity) {
        em.persist(new UserDocumentEntity(number, date, documentTypeEntity));

    }
}

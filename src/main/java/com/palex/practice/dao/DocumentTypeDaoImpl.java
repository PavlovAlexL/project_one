package com.palex.practice.dao;

import com.palex.practice.model.DocumentTypeEntity;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class DocumentTypeDaoImpl implements DocumentTypeDao {

    private final EntityManager em;

    @Autowired
    public DocumentTypeDaoImpl(EntityManager em) {
        this.em = em;
    }

    @Override
    public List<DocumentTypeEntity> getAll() {
        TypedQuery<DocumentTypeEntity> query = (Query<DocumentTypeEntity>) em.createQuery("SELECT d FROM DocumentTypeEntity d", DocumentTypeEntity.class);
        return query.getResultList();
    }
}

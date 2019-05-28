package com.palex.practice.dao;

import com.palex.practice.model.DocumentTypeEntity;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class DocumentTypeDaoImpl implements DocumentTypeDao {

    private final EntityManager em;

    public DocumentTypeDaoImpl(EntityManager em) {
        this.em = em;
    }

    @Override
    public List<DocumentTypeEntity> getAll() {
        TypedQuery<DocumentTypeEntity> query = em.createQuery("SELECT d FROM DocumentTypeEntity d", DocumentTypeEntity.class);
        return query.getResultList();
    }

    @Override
    public DocumentTypeEntity getByCode(String code) {
        TypedQuery<DocumentTypeEntity> query = em.createQuery("SELECT d FROM DocumentTypeEntity d WHERE d.code = :code", DocumentTypeEntity.class);
        return query.setParameter("code", code).getSingleResult();
    }

    @Override
    public DocumentTypeEntity getByName(String name) {
        TypedQuery<DocumentTypeEntity> query = em.createQuery("SELECT d FROM DocumentTypeEntity d WHERE d.name = :name", DocumentTypeEntity.class);
        return query.setParameter("name", name).getSingleResult();
    }
}

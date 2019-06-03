package com.palex.practice.dao.impl;

import com.palex.practice.dao.DocumentTypeDao;
import com.palex.practice.model.DocumentTypeEntity;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

/**
 * Реализация DAO для доступа к типам документов.
 */
@Repository
public class DocumentTypeDaoImpl implements DocumentTypeDao {

    private final EntityManager em;

    public DocumentTypeDaoImpl(EntityManager em) {
        this.em = em;
    }

    /**
     * Получение коллекции объектов.
     *
     * @return
     */
    @Override
    public List<DocumentTypeEntity> getAll() {
        TypedQuery<DocumentTypeEntity> query = em.createQuery("SELECT d FROM DocumentTypeEntity d", DocumentTypeEntity.class);
        return query.getResultList();
    }

    /**
     * Получить по коду документа.
     * @param code Код.
     * @return объект.
     */
    @Override
    public DocumentTypeEntity getByCode(String code) {
        CriteriaQuery<DocumentTypeEntity> criteria = buildCriteria("code", code);
        TypedQuery<DocumentTypeEntity> query = em.createQuery(criteria);
        return query.getSingleResult();
    }

    /**
     * Получить по имени документу.
     * @param name Иия.
     * @return объект.
     */
    @Override
    public DocumentTypeEntity getByName(String name) {
        CriteriaQuery<DocumentTypeEntity> criteria = buildCriteria("name", name);
        TypedQuery<DocumentTypeEntity> query = em.createQuery(criteria);
        return query.getSingleResult();
    }

    private CriteriaQuery<DocumentTypeEntity> buildCriteria(String parametr, String data) {
        CriteriaBuilder builder = em.getCriteriaBuilder();
        CriteriaQuery<DocumentTypeEntity> criteria = builder.createQuery(DocumentTypeEntity.class);
        Root<DocumentTypeEntity> root = criteria.from(DocumentTypeEntity.class);
        criteria.where(builder.equal(root.get(parametr), data));
        return criteria;
    }


}
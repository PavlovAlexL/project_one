package com.palex.practice.dao.impl;

import com.palex.practice.dao.CountryDao;
import com.palex.practice.model.CountryEntity;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

/**
 * Реализация DAO для доступа к справочникам стран.
 */
@Repository
public class CountryDaoImpl implements CountryDao {

    private final EntityManager em;

    public CountryDaoImpl(EntityManager em) {
        this.em = em;
    }

    /**
     * Получить списоком.
     * @return коллекцию объектов.
     */
    @Override
    public List<CountryEntity> getAll() {
        TypedQuery<CountryEntity> query = em.createQuery("SELECT c FROM CountryEntity c", CountryEntity.class);
        return query.getResultList();
    }

    /**
     * Получить по коду.
     * @param code код.
     * @return объект
     */
    @Override
    public CountryEntity getByCode(String code) {
        TypedQuery<CountryEntity> query = em.createQuery("SELECT c FROM CountryEntity c where c.code = :code", CountryEntity.class);
        return query.setParameter("code", code).getSingleResult();
    }
}

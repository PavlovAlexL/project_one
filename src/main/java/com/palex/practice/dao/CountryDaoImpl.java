package com.palex.practice.dao;

import com.palex.practice.model.CountryEntity;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class CountryDaoImpl implements CountryDao {

    private final EntityManager em;

    public CountryDaoImpl(EntityManager em) {
        this.em = em;
    }

    @Override
    public List<CountryEntity> getAll() {
        TypedQuery<CountryEntity> query = em.createQuery("SELECT c FROM CountryEntity c", CountryEntity.class);
        return query.getResultList();
    }

    @Override
    public CountryEntity getByCode(String code) {
        TypedQuery<CountryEntity> query = em.createQuery("SELECT c FROM CountryEntity c where c.code = :code", CountryEntity.class);
        return query.setParameter("code", code).getSingleResult();
    }
}

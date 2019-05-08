package com.palex.practice.dao;

import com.palex.practice.model.CountryEntity;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.persistence.EntityManager;
import javax.persistence.Transient;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.List;

@Repository
public class CountryDaoImpl implements CountryDao {

    private final EntityManager em;

    public CountryDaoImpl(EntityManager em) {
        this.em = em;
    }

    @Transactional
    @Override
    public List<CountryEntity> getAll() {
        TypedQuery<CountryEntity> query = (Query<CountryEntity>) em.createQuery("SELECT c FROM CountryEntity c", CountryEntity.class);
        return query.getResultList();
    }

    @Transactional
    @Override
    public CountryEntity getByCode(String code) {
        TypedQuery<CountryEntity> query = em.createQuery("SELECT c FROM CountryEntity c where c.code = :code", CountryEntity.class);
        return query.setParameter("code", code).getSingleResult();
    }
}

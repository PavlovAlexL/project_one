package com.palex.practice.dao;

import com.palex.practice.model.OrganisationEntity;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.util.List;

@Repository
public class OrganisationDaoImpl implements OrganisationDao {

    private final EntityManager em;

    public OrganisationDaoImpl(EntityManager em) {
        this.em = em;
    }

    @Override
    public List<OrganisationEntity> getByParams(Object... params) {
        return null;
    }

    @Override
    public OrganisationEntity getById(Long id) {
        return null;
    }

    @Override
    public String update(String params) {
        return null;
    }

    @Override
    @Transactional
    public String save(OrganisationEntity organisationEntity) {
        System.out.println(organisationEntity.getFull_Name());
        em.persist(organisationEntity);
        return "save";
    }
}

package com.palex.practice.dao;

import com.palex.practice.model.OrganisationEntity;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Map;

@Repository
public class OrganisationDaoImpl implements OrganisationDao {

    private final EntityManager em;

    public OrganisationDaoImpl(EntityManager em) {
        this.em = em;
    }

    @Override
    @Transactional
    public List<OrganisationEntity> getByParams(String name) {
        TypedQuery<OrganisationEntity> query = em.createQuery("SELECT o FROM OrganisationEntity o where o.name = :name", OrganisationEntity.class);
        List<OrganisationEntity> result = query.setParameter("name", name).getResultList();
        return result;
    }

    @Override
    @Transactional
    public OrganisationEntity getById(Long id) {
         return em.find(OrganisationEntity.class, id);
    }

    @Override
    @Transactional
    public void update(Map<String, String> params) {
        OrganisationEntity organisationEntity = em.find(OrganisationEntity.class, Long.parseLong(params.get("id")));

        organisationEntity.setName(params.get("name"));
        organisationEntity.setFullName(params.get("fullName"));
        organisationEntity.setInn(params.get("inn"));
        organisationEntity.setKpp(params.get("kpp"));
        organisationEntity.setAddress(params.get("address"));
        if(params.containsKey("phone")){
            organisationEntity.setPhone(params.get("phone"));
        }
        if(params.containsKey("isActive")) {
            organisationEntity.setIsActive(Boolean.parseBoolean(params.get("isActive")));
        }
        em.merge(organisationEntity);

    }

    @Override
    @Transactional
    public void save(OrganisationEntity organisationEntity) {
        System.out.println(organisationEntity);
        em.persist(organisationEntity);
    }
}

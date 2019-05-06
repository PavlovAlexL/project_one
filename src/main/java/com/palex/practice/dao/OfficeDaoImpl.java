package com.palex.practice.dao;

import com.palex.practice.model.OfficeEntity;
import com.palex.practice.model.OrganisationEntity;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Repository
public class OfficeDaoImpl implements OfficeDao{

    private final EntityManager em;

    public OfficeDaoImpl(EntityManager entityManager) {
        this.em = entityManager;
    }

    @Override
    @Transactional
    public List<OfficeEntity> getByParams(OrganisationEntity organisationEntity) {
        TypedQuery<OfficeEntity> query = em.createQuery("SELECT o FROM OfficeEntity o where o.organisation = :organisation", OfficeEntity.class);
        return query.setParameter("organisation", organisationEntity).getResultList();
    }

    @Override
    @Transactional
    public OfficeEntity getById(Long id) {
        return em.find(OfficeEntity.class, id);
    }

    @Override
    @Transactional
    public void update(Map<String, String> params) {
        OfficeEntity officeEntity = em.find(OfficeEntity.class, Long.parseLong(params.get("id")));

        officeEntity.setName(params.get("name"));
        officeEntity.setAddress(params.get("address"));
        if(params.containsKey("phone")){
            officeEntity.setPhone(params.get("phone"));
        }
        if(params.containsKey("isActive")) {
            officeEntity.setIs_active(Boolean.parseBoolean(params.get("isActive")));
        }
        em.merge(officeEntity);
    }

    @Override
    @Transactional
    public void save(OfficeEntity officeEntity) {
        em.persist(officeEntity);
    }
}

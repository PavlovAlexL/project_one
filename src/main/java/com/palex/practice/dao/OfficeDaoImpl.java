package com.palex.practice.dao;

import com.palex.practice.model.OfficeEntity;
import com.palex.practice.model.OrganisationEntity;
import com.palex.practice.view.Office.OfficeListFilterView;
import com.palex.practice.view.Office.OfficeUpdateFilterView;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.List;

@Repository
public class OfficeDaoImpl implements OfficeDao{

    private final EntityManager em;

    public OfficeDaoImpl(EntityManager entityManager) {
        this.em = entityManager;
    }

    @Override
    public List<OfficeEntity> getByParams(OfficeListFilterView officeListFilterView) {
        Long orgId = officeListFilterView.orgId;
        OrganisationEntity organisationEntity = em.find(OrganisationEntity.class, orgId);
        String name = officeListFilterView.name;
        String phone = officeListFilterView.phone;
        String isActive = officeListFilterView.isActive;

        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<OfficeEntity> query = cb.createQuery(OfficeEntity.class);
        Root<OfficeEntity> officeEntityRoot = query.from(OfficeEntity.class);

        Predicate predicate = cb.conjunction();
        predicate = cb.and(predicate, cb.equal(officeEntityRoot.get("organisation"), organisationEntity));
        if (name.length() > 0) {
            predicate = cb.and(predicate, cb.equal(officeEntityRoot.get("name"), name));
        }
        if (phone.length() > 0) {
            predicate = cb.and(predicate, cb.equal(officeEntityRoot.get("phone"), phone));
        }
        if (isActive.length() > 0) {
            predicate = cb.and(predicate, cb.equal(officeEntityRoot.get("isActive"), isActive));
        }
        query.where(predicate);
        return em.createQuery(query).getResultList();
    }

    @Override
    public OfficeEntity getById(Long id) {
        return em.find(OfficeEntity.class, id);
    }

    @Override
    public void update(OfficeUpdateFilterView officeUpdateFilterView) {
        OfficeEntity officeEntity = em.find(OfficeEntity.class, officeUpdateFilterView.id);
        officeEntity.setName(officeUpdateFilterView.name);
        officeEntity.setAddress(officeUpdateFilterView.address);
        officeEntity.setPhone(officeUpdateFilterView.phone);
        officeEntity.setIsActive(Boolean.parseBoolean(officeUpdateFilterView.isActive));
        em.merge(officeEntity);
    }

    @Override
    public void save(OfficeEntity officeEntity) {
        em.persist(officeEntity);
    }

}

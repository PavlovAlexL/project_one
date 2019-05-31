package com.palex.practice.dao.impl;

import com.palex.practice.dao.OrganisationDao;
import com.palex.practice.model.OrganisationEntity;
import com.palex.practice.view.Organisation.OrganisationListFilterView;
import com.palex.practice.view.Organisation.OrganisationUpdateFilterView;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;
import java.util.List;

@Repository
public class OrganisationDaoImpl implements OrganisationDao {

    private final EntityManager em;

    public OrganisationDaoImpl(EntityManager em) {
        this.em = em;
    }

    @Override
    public List<OrganisationEntity> getByParams(OrganisationListFilterView organisationListFilterView) {
        String name = organisationListFilterView.name;
        String inn = organisationListFilterView.inn;
        String isActive = organisationListFilterView.isActive;

        System.out.println(name + inn + isActive);

        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<OrganisationEntity> query = cb.createQuery(OrganisationEntity.class);
        Root<OrganisationEntity> organisationEntityRoot = query.from(OrganisationEntity.class);
        Predicate predicate = cb.conjunction();
        predicate = cb.and(predicate, cb.equal(organisationEntityRoot.get("name"), name));
        if(inn.length() > 0){
            predicate = cb.and(predicate, cb.equal(organisationEntityRoot.get("inn"), inn));
        }
        if(isActive.length() > 0){
            predicate = cb.and(predicate, cb.equal(organisationEntityRoot.get("isActive"), Boolean.parseBoolean(isActive)));
        }
        query.where(predicate);
        return em.createQuery(query).getResultList();
    }

    @Override
    public OrganisationEntity getById(Long id) {
         return em.find(OrganisationEntity.class, id);
    }

    @Override
    public void update(OrganisationUpdateFilterView organisationUpdateFilterView) {

        OrganisationEntity organisationEntity = em.find(OrganisationEntity.class, organisationUpdateFilterView.id);
        organisationEntity.setName(organisationUpdateFilterView.name);
        organisationEntity.setFullName(organisationUpdateFilterView.fullName);
        organisationEntity.setInn(organisationUpdateFilterView.inn);
        organisationEntity.setKpp(organisationUpdateFilterView.kpp);
        organisationEntity.setAddress(organisationUpdateFilterView.address);
        organisationEntity.setPhone(organisationUpdateFilterView.phone);
        organisationEntity.setIsActive(Boolean.parseBoolean(organisationUpdateFilterView.isActive));
        em.merge(organisationEntity);
    }

    @Override
    @Transactional
    public void save(OrganisationEntity organisationEntity) {
        em.persist(organisationEntity);
    }

}

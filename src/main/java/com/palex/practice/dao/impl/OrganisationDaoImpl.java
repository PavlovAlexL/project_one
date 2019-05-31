package com.palex.practice.dao.impl;

import com.palex.practice.dao.OrganisationDao;
import com.palex.practice.model.OrganisationEntity;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;
import java.util.List;

/**
 * DAO для доступа к Organisation.
 */
@Repository
public class OrganisationDaoImpl implements OrganisationDao {

    private final EntityManager em;

    public OrganisationDaoImpl(EntityManager em) {
        this.em = em;
    }

    /**
     * Получение коллекции объектов по параметрам.
     *
     * @return
     */
    @Override
    public List<OrganisationEntity> getByParams(OrganisationEntity organisationEntity) {
        String name = organisationEntity.getName();
        String inn = organisationEntity.getInn();
        Boolean isActive = organisationEntity.getIsActive();

        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<OrganisationEntity> query = cb.createQuery(OrganisationEntity.class);
        Root<OrganisationEntity> organisationEntityRoot = query.from(OrganisationEntity.class);
        Predicate predicate = cb.conjunction();
        predicate = cb.and(predicate, cb.equal(organisationEntityRoot.get("name"), name));
        if (inn != null) {
            predicate = cb.and(predicate, cb.equal(organisationEntityRoot.get("inn"), inn));
        }
        if (isActive != null) {
            predicate = cb.and(predicate, cb.equal(organisationEntityRoot.get("isActive"), isActive));
        }
        query.where(predicate);
        return em.createQuery(query).getResultList();
    }

    /**
     * Получение объекта по ID.
     * @param id
     * @return
     */
    @Override
    public OrganisationEntity getById(Long id) {
        return em.find(OrganisationEntity.class, id);
    }

    /**
     * Изменить объект.
     * @param
     */
    @Override
    public void update(OrganisationEntity organisationEntity) {

        OrganisationEntity originalOrganisationEntity = em.find(OrganisationEntity.class, organisationEntity.getId());
        originalOrganisationEntity.setName(organisationEntity.getName());
        originalOrganisationEntity.setFullName(organisationEntity.getFullName());
        originalOrganisationEntity.setInn(organisationEntity.getInn());
        originalOrganisationEntity.setKpp(organisationEntity.getKpp());
        originalOrganisationEntity.setAddress(organisationEntity.getAddress());
        if (organisationEntity.getPhone() != null) {
            originalOrganisationEntity.setPhone(organisationEntity.getPhone());
        }
        if (organisationEntity.getIsActive() != null) {
            originalOrganisationEntity.setIsActive(organisationEntity.getIsActive());
        }
        em.merge(organisationEntity);
    }

    /**
     * Сохраненить объект.
     * @param
     */
    @Override
    @Transactional
    public void save(OrganisationEntity organisationEntity) {
        em.persist(organisationEntity);
    }

}

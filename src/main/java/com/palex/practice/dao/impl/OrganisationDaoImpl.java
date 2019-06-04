package com.palex.practice.dao.impl;

import com.palex.practice.dao.OrganisationDao;
import com.palex.practice.model.OrganisationEntity;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.List;

/**
 * Реализация DAO для доступа к организации.
 */
@Repository
public class OrganisationDaoImpl implements OrganisationDao {

    private final EntityManager em;

    public OrganisationDaoImpl(EntityManager em) {
        this.em = em;
    }

    /**
     * Получение коллекции объектов организаций.
     * @param organisationEntity Организация.
     * @return коллекция организаций.
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
     * Получение объекта по идентификатору.
     * @param id идентификатор.
     * @return организация.
     */
    @Override
    public OrganisationEntity getById(Long id) {
        return em.find(OrganisationEntity.class, id);
    }

    /**
     * Изменить организацию.
     * @param organisationEntity Организация.
     */
    @Override
    public void update(OrganisationEntity organisationEntity) {
        em.merge(organisationEntity);
    }

    /**
     * Сохранить организацию.
     * @param organisationEntity Организация.
     */
    @Override
    public void save(OrganisationEntity organisationEntity) {
        em.persist(organisationEntity);
    }

}

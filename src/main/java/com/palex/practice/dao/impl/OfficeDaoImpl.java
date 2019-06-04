package com.palex.practice.dao.impl;

import com.palex.practice.dao.OfficeDao;
import com.palex.practice.model.OfficeEntity;
import com.palex.practice.model.OrganisationEntity;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.List;

/**
 * Реализация DAO для доступа к Office.
 */
@Repository
public class OfficeDaoImpl implements OfficeDao {

    private final EntityManager em;

    public OfficeDaoImpl(EntityManager entityManager) {
        this.em = entityManager;
    }

    /**
     * Получение коллекции объектов типа офис по параметрам.
     * @param officeEntity офис
     * @return коллекция объектов типа офис.
     */
    @Override
    public List<OfficeEntity> getByParams(OfficeEntity officeEntity) {
        OrganisationEntity organisationEntity = officeEntity.getOrganisation();
        String name = officeEntity.getName();
        String phone = officeEntity.getPhone();
        Boolean isActive = officeEntity.getIsActive();

        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<OfficeEntity> query = cb.createQuery(OfficeEntity.class);
        Root<OfficeEntity> officeEntityRoot = query.from(OfficeEntity.class);

        Predicate predicate = cb.conjunction();
        predicate = cb.and(predicate, cb.equal(officeEntityRoot.get("organisation"), organisationEntity));
        if (name != null) {
            predicate = cb.and(predicate, cb.equal(officeEntityRoot.get("name"), name));
        }
        if (phone != null) {
            predicate = cb.and(predicate, cb.equal(officeEntityRoot.get("phone"), phone));
        }
        if (isActive != null) {
            predicate = cb.and(predicate, cb.equal(officeEntityRoot.get("isActive"), isActive));
        }
        query.where(predicate);
        return em.createQuery(query).getResultList();
    }

    /**
     * Получение объекта по идентификатору.
     * @param id идентификатор
     * @return офис.
     */
    @Override
    public OfficeEntity getById(Long id) {
        return em.find(OfficeEntity.class, id);
    }

    /**
     * Изменить офис.
     * @param officeEntity офис.
     */
    @Override
    public void update(OfficeEntity officeEntity) {
        em.merge(officeEntity);
    }

    /**
     * Сохраненить офис.
     * @param officeEntity офис.
     */
    @Override
    public void save(OfficeEntity officeEntity) {
        em.persist(officeEntity);
    }

}

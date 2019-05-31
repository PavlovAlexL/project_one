package com.palex.practice.dao.impl;

import com.palex.practice.dao.UserDao;
import com.palex.practice.model.CountryEntity;
import com.palex.practice.model.OfficeEntity;
import com.palex.practice.model.UserDocumentEntity;
import com.palex.practice.model.UserEntity;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.List;

/**
 * Реализация DAO для работы User.
 */
@Repository
public class UserDaoImpl implements UserDao {

    private final EntityManager em;

    public UserDaoImpl(EntityManager em) {
        this.em = em;
    }

    /**
     * Получение коллекции объектов по параметрам.
     *
     * @return
     */
    @Override
    public List<UserEntity> getByParams(UserEntity userEntity) {
        OfficeEntity officeEntity = userEntity.getOffice();
        String firstName = userEntity.getFirstName();
        String lastName = userEntity.getLastName();
        String middleName = userEntity.getMiddleName();
        String position = userEntity.getPosition();
        String docCode = userEntity.getUserDocument().getDocumentType().getCode();
        String citizenshipCode = userEntity.getCountry().getCode();

        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<UserEntity> query = cb.createQuery(UserEntity.class);
        Root<UserEntity> userEntityRoot = query.from(UserEntity.class);

        Predicate predicate = cb.conjunction();

        predicate = cb.and(predicate, cb.equal(userEntityRoot.get("office"), officeEntity));

        if (firstName != null) {
            predicate = cb.and(predicate, cb.equal(userEntityRoot.get("firstName"), firstName));
        }
        if (lastName != null) {
            predicate = cb.and(predicate, cb.equal(userEntityRoot.get("lastName"), lastName));
        }
        if (middleName != null) {
            predicate = cb.and(predicate, cb.equal(userEntityRoot.get("middleName"), middleName));
        }
        if (position != null) {
            predicate = cb.and(predicate, cb.equal(userEntityRoot.get("position"), position));
        }
        if (docCode != null) {
            predicate = cb.and(predicate, cb.equal(userEntityRoot.get("userDocument").get("documentType").get("code"), docCode));
        }
        if (citizenshipCode != null) {
            predicate = cb.and(predicate, cb.equal(userEntityRoot.get("country").get("code"), citizenshipCode));
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
    public UserEntity getById(Long id) {
        return em.find(UserEntity.class, id);
    }

    /**
     * Изменить объект.
     * @param
     */
    @Override
    public void update(UserEntity userEntity) {
        Long id = userEntity.getId();
        OfficeEntity officeEntity = userEntity.getOffice();
        String firstName = userEntity.getFirstName();
        String lastName = userEntity.getLastName();
        String middleName = userEntity.getMiddleName();
        String position = userEntity.getPosition();
        String phone = userEntity.getPhone();
        UserDocumentEntity userDocumentEntity = userEntity.getUserDocument();
        CountryEntity countryEntity = userEntity.getCountry();
        Boolean isIdentified = userEntity.getIsIdentified();

        UserEntity originalUserEntity = em.find(UserEntity.class, id);

        if (officeEntity != null) {
            originalUserEntity.setOffice(officeEntity);
        }

        originalUserEntity.setFirstName(firstName);

        if (lastName != null) {
            originalUserEntity.setLastName(lastName);
        }

        if (middleName != null) {
            originalUserEntity.setMiddleName(middleName);
        }

        originalUserEntity.setPosition(position);

        if (phone != null) {
            originalUserEntity.setPhone(phone);
        }

        if (userDocumentEntity != null) {
            originalUserEntity.setUserDocument(userDocumentEntity);
        }

        if (countryEntity != null) {
            originalUserEntity.setCountry(countryEntity);
        }

        if (isIdentified != null) {
            originalUserEntity.setIsIdentified(isIdentified);
        }

        em.merge(originalUserEntity);
    }

    /**
     * Сохраненить объект.
     * @param
     */
    @Override
    public void save(UserEntity userEntity) {
        em.persist(userEntity);
    }

}

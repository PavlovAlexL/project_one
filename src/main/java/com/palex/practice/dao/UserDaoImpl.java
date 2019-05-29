package com.palex.practice.dao;

import com.palex.practice.model.OfficeEntity;
import com.palex.practice.model.UserEntity;
import com.palex.practice.view.User.UserListFilterView;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.List;

@Repository
public class UserDaoImpl implements UserDao {

    private final EntityManager em;

    public UserDaoImpl(EntityManager em) {
        this.em = em;
    }

    @Override
    public List<UserEntity> getByParams(UserListFilterView userListFilterView) {

        Long officeId = userListFilterView.officeId;
        OfficeEntity officeEntity = em.find(OfficeEntity.class, officeId);
        String firstName = userListFilterView.firstName;
        String lastName = userListFilterView.lastName;
        String middleName = userListFilterView.middleName;
        String position = userListFilterView.middleName;
        String docCode = userListFilterView.docCode;
        String citizenshipCode = userListFilterView.citizenshipCode;

        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<UserEntity> query = cb.createQuery(UserEntity.class);
        Root<UserEntity> userEntityRoot = query.from(UserEntity.class);

        Predicate predicate = cb.conjunction();

        predicate = cb.and(predicate, cb.equal(userEntityRoot.get("office"), officeEntity));

        if (firstName.length() > 0) {
            predicate = cb.and(predicate, cb.equal(userEntityRoot.get("firstName"), firstName));
        }
        if (lastName.length() > 0) {
            predicate = cb.and(predicate, cb.equal(userEntityRoot.get("lastName"), lastName));
        }
        if (middleName.length() > 0) {
            predicate = cb.and(predicate, cb.equal(userEntityRoot.get("middleName"), middleName));
        }
        if (position.length() > 0) {
            predicate = cb.and(predicate, cb.equal(userEntityRoot.get("position"), position));
        }
        if (docCode.length() > 0) {
            predicate = cb.and(predicate, cb.equal(userEntityRoot.get("userDocument").get("documentType").get("code"), docCode));
        }
        if (citizenshipCode.length() > 0) {
            predicate = cb.and(predicate, cb.equal(userEntityRoot.get("country").get("code"), citizenshipCode));
        }

        query.where(predicate);

        return em.createQuery(query).getResultList();
    }

    @Override
    public UserEntity getById(Long id) {
        return em.find(UserEntity.class, id);
    }

    @Override
    public void update(UserEntity userEntity) {
        em.merge(userEntity);
    }

    @Override
    public void save(UserEntity userEntity) {
        em.persist(userEntity);
    }
}

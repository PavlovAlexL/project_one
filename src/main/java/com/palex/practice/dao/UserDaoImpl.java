package com.palex.practice.dao;

import com.palex.practice.model.OfficeEntity;
import com.palex.practice.model.UserEntity;
import org.springframework.stereotype.Repository;

import javax.jws.soap.SOAPBinding;
import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Repository
public class UserDaoImpl implements UserDao {

    private final EntityManager em;

    public UserDaoImpl(EntityManager em) {
        this.em = em;
    }

    @Transactional
    @Override
    public List<UserEntity> getByParams(Map<String, String> params) {
        String officeId = params.get("officeId");
        String firstName = params.get("firstName");
        String lastName = params.get("lastName");
        String middleName = params.get("middleName");
        String position = params.get("position");
        String docCode = params.get("docCode");
        String citizenshipCode = params.get("citizenshipCode");

        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<UserEntity> userEntityCriteriaQuery = cb.createQuery(UserEntity.class);
        Root<UserEntity> userEntityRoot = userEntityCriteriaQuery.from(UserEntity.class);

        userEntityCriteriaQuery.select(userEntityRoot);
        userEntityCriteriaQuery.where(cb.equal(userEntityRoot.get("office").get("id"), officeId));
        if(firstName != null) {
            userEntityCriteriaQuery.where(cb.equal(userEntityRoot.get("first_Name"), firstName));
        }
        if(lastName != null){
            userEntityCriteriaQuery.where(cb.equal(userEntityRoot.get("last_Name"), lastName));
        }
        if(middleName != null){
            userEntityCriteriaQuery.where(cb.equal(userEntityRoot.get("middle_Name"), middleName));
        }
        if(position != null){
            userEntityCriteriaQuery.where(cb.equal(userEntityRoot.get("position"), position));
        }
        if(docCode != null){
            userEntityCriteriaQuery.where(cb.equal(userEntityRoot.get("userDocument").get("documentType").get("code"), docCode));
        }
        if(citizenshipCode != null){
            userEntityCriteriaQuery.where(cb.equal(userEntityRoot.get("country").get("code"), citizenshipCode));
        }

        return em.createQuery(userEntityCriteriaQuery).getResultList();






        //return new ArrayList<UserEntity>();
    }

    @Transactional
    @Override
    public UserEntity getById(Long id) {
        return em.find(UserEntity.class, id);
    }

    @Transactional
    @Override
    public void update(UserEntity userEntity) {
        em.merge(userEntity);
    }

    @Transactional
    @Override
    public void save(UserEntity userEntity) {
        em.persist(userEntity);
    }
}

package com.palex.practice.dao;

import com.palex.practice.model.OfficeEntity;
import com.palex.practice.model.UserEntity;
import org.springframework.stereotype.Repository;

import javax.jws.soap.SOAPBinding;
import javax.persistence.EntityManager;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Repository
public class UserDaoImpl implements UserDao {

    private final EntityManager em;

    public UserDaoImpl(EntityManager em) {
        this.em = em;
    }

    @Override
    public List<UserEntity> getByParams(Map<String, String> params) {
        return new ArrayList<UserEntity>();
    }

    @Override
    public UserEntity getById(Long id) {
        return em.find(UserEntity.class, id);
    }

    @Override
    public void update(Map<String, String> params, OfficeEntity officeEntity) {
        UserEntity userEntity = em.find(UserEntity.class, Long.parseLong(params.get("id")));

        userEntity.setFirstName(params.get("firstName"));
        userEntity.setPosition(params.get("position"));

        if(officeEntity != null) {
            userEntity.setOffice(officeEntity);
        }
        if(params.containsKey("secondName")){
            userEntity.setSecondName(params.get("secondName"));
        }
        if(params.containsKey("middleName")){
            userEntity.setMiddleName(params.get("middleName"));
        }
        if(params.containsKey("phone")){
            userEntity.setPhone(params.get("phone"));
        }
        em.merge(userEntity);

    }

    @Override
    public void save(UserEntity userEntity) {
        em.persist(userEntity);
    }
}

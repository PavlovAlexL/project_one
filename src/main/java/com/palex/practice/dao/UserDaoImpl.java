package com.palex.practice.dao;

import com.palex.practice.model.OfficeEntity;
import com.palex.practice.model.UserEntity;
import org.springframework.stereotype.Repository;

import javax.jws.soap.SOAPBinding;
import javax.persistence.EntityManager;
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
        return null;
    }

    @Override
    public UserEntity getById(Long id) {
        return em.find(UserEntity.class, id);
    }

    @Override
    public void update(Map<String, String> params) {
        UserEntity userEntity = em.find(UserEntity.class, Long.parseLong(params.get("officeId")));

        userEntity.
    }

    @Override
    public void save(UserEntity userEntity) {

    }
}

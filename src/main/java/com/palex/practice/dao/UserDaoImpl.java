package com.palex.practice.dao;

import com.palex.practice.model.OfficeEntity;
import com.palex.practice.model.UserEntity;
import org.springframework.stereotype.Repository;

import javax.jws.soap.SOAPBinding;
import javax.persistence.EntityManager;
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
        return new ArrayList<UserEntity>();
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

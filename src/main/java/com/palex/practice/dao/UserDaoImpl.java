package com.palex.practice.dao;

import com.palex.practice.model.UserEntity;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public class UserDaoImpl implements UserDao {

    @Override
    public List<UserEntity> getByParams(Map<String, String> params) {
        return null;
    }

    @Override
    public UserEntity getById(Long id) {
        return null;
    }

    @Override
    public void save(Map<String, String> params) {

    }

    @Override
    public void update(Map<String, String> params) {

    }
}

package com.palex.practice.service;

import com.palex.practice.dao.UserDao;
import com.palex.practice.model.mapper.MapperFacade;
import com.palex.practice.view.UserView;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class UserServiceImpl implements UserService{

    private final UserDao userDao;
    private final MapperFacade mapperFacade;

    public UserServiceImpl(UserDao userDao, MapperFacade mapperFacade) {
        this.userDao = userDao;
        this.mapperFacade = mapperFacade;
    }

    @Override
    public List<UserView> list(Map<String,String> params) {

        return null;
    }

    @Override
    public UserView getById(Long id) {
        return null;
    }

    @Override
    public void update(Map<String, String> params) {

    }

    @Override
    public void save(Map<String, String> params) {

    }
}

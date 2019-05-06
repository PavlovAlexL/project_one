package com.palex.practice.service;

import com.palex.practice.dao.OfficeDao;
import com.palex.practice.dao.UserDao;
import com.palex.practice.model.OfficeEntity;
import com.palex.practice.model.UserEntity;
import com.palex.practice.model.mapper.MapperFacade;
import com.palex.practice.view.UserView;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import javax.jws.soap.SOAPBinding;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class UserServiceImpl implements UserService{

    private final UserDao userDao;
    private final OfficeDao officeDao;
    private final MapperFacade mapperFacade;

    public UserServiceImpl(UserDao userDao, MapperFacade mapperFacade) {
        this.userDao = userDao;
        this.officeDao = officeDao;
        this.mapperFacade = mapperFacade;
    }

    @Override
    public List<UserView> list(Map<String,String> params) {
        return new ArrayList<UserView>();
    }

    @Override
    public UserView getById(Long id) {
        UserEntity result = userDao.getById(id);
        return mapperFacade.map(result, UserView.class);
    }

    @Override
    public void update(Map<String, String> params) {
        userDao.update(params);
    }

    @Override
    public void save(Map<String, String> params) {
        OfficeEntity officeEntity = officeDao.getById(Long.parseLong(params.get("officeId")));
        UserEntity userEntity = new UserEntity(params, officeEntity);
        userDao.save(userEntity);

    }
}

package com.palex.practice.service;

import com.palex.practice.dao.*;
import com.palex.practice.model.*;
import com.palex.practice.model.mapper.MapperFacade;
import com.palex.practice.view.UserView;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class UserServiceImpl implements UserService{

    private final UserDao userDao;
    private final OfficeDao officeDao;
    private final CountryDao countryDao;
    private final MapperFacade mapperFacade;
    private final DocumentTypeDao documentTypeDao;

    public UserServiceImpl(UserDao userDao, OfficeDao officeDao, CountryDao countryDao, DocumentTypeDao documentTypeDao, MapperFacade mapperFacade) {
        this.userDao = userDao;
        this.officeDao = officeDao;
        this.countryDao = countryDao;
        this.mapperFacade = mapperFacade;
        this.documentTypeDao = documentTypeDao;
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
        OfficeEntity officeEntity = null;
        Long id = Long.parseLong(params.get("OfficeId"));
        if(id != null){
            officeEntity = officeDao.getById(id);
        }
        userDao.update(params, officeEntity);
    }

    @Override
    public void save(Map<String, String> params) {
        OfficeEntity officeEntity = officeDao.getById(Long.parseLong(params.get("officeId")));
        CountryEntity countryEntity = countryDao.getByCode(params.get("citizenshipCode"));

        if(params.get("docCode") != null | params.get("docName") != null | params.get("docNumber") != null | params.get("docDate") != null){
            UserDocumentEntity userDocumentEntity = new UserDocumentEntity(params.get("docCode"), params.get("docName"), params.get("docNumber"), params.get("docDate"));
        }



        UserDocumentEntity userDocumentEntity = new UserDocumentEntity(params.get("docCode"), params.get("docNumber"), params.get("docDate"), documentTypeEntity);





        UserDocumentEntity userDocumentEntity = new UserDocumentEntity()
        UserEntity userEntity = new UserEntity(params, officeEntity, countryEntity);
        userDao.save(userEntity);

    }
}

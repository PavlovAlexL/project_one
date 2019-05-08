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
        UserEntity userEntity = userDao.getById(Long.parseLong(params.get("id")));

        if(params.containsKey("officeId") & params.get("officeId") != null ){
            userEntity.setOffice(officeDao.getById(Long.parseLong(params.get("officeId"))));
        }

        userEntity.setFirstName(params.get("firstName"));

        if(params.containsKey("secondName")){
            userEntity.setSecondName(params.get("secondName"));
        }
        if(params.containsKey("middleName")){
            userEntity.setMiddleName(params.get("middleName"));
        }
        userEntity.setPosition(params.get("position"));
        if(params.containsKey("phone")){
            userEntity.setPhone(params.get("phone"));
        }
        if(params.containsKey("isIdentified")){
            userEntity.setMiddleName(params.get("isIdentified"));
        }

        if(params.containsKey("docName")){
            userEntity.getUserDocument().setDocumentType(documentTypeDao.getByName(params.get("docName")));
        }
        if(params.containsKey("docNumber")){
            userEntity.getUserDocument().setDoc_number(params.get("docNumber"));
        }
        if(params.containsKey("docDate")){
            userEntity.getUserDocument().setDoc_date(params.get("docDate"));
        }
        
        userDao.update(userEntity);
    }

    @Override
    public void save(Map<String, String> params) {
        Long id = Long.parseLong(params.get("officeId"));
        OfficeEntity officeEntity = officeDao.getById(id);
        UserDocumentEntity userDocumentEntity = new UserDocumentEntity();

        if(params.get("docCode") != null | params.get("docNumber") != null | params.get("docDate") != null){
            DocumentTypeEntity documentTypeEntity = documentTypeDao.getByCode(params.get("docCode"));
            userDocumentEntity = new UserDocumentEntity(params.get("docNumber"), params.get("docDate"), documentTypeEntity);
        }
        CountryEntity countryEntity = countryDao.getByCode(params.get("citizenshipCode"));
        UserEntity userEntity = new UserEntity(params, officeEntity, userDocumentEntity, countryEntity);
        userDao.save(userEntity);

    }
}

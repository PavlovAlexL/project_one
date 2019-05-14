package com.palex.practice.service.impl;

import com.palex.practice.dao.*;
import com.palex.practice.model.*;
import com.palex.practice.model.mapper.MapperFacade;
import com.palex.practice.service.UserService;
import com.palex.practice.view.UserView;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class UserServiceImpl implements UserService {

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
        List<UserEntity> result = userDao.getByParams(params);
        if(result.size() == 0){
            throw new RuntimeException("No user available");
        }
        return mapperFacade.mapAsList(result, UserView.class);
    }

    @Override
    public UserView getById(Long id) {
        UserEntity result = userDao.getById(id);
        return mapperFacade.map(result, UserView.class);
    }

    @Override
    public void update(Map<String, String> params) {
        UserEntity userEntity = userDao.getById(Long.parseLong(params.get("id")));

        if(params.containsKey("officeId")){
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

        if(params.get("docNumber") != null || params.get("docDate") != null || params.get("docName") != null){
            DocumentTypeEntity documentTypeEntity;
            String docNumber;
            String docDate;
            if(params.get("docNumber") != null){
                docNumber = params.get("docNumber");
            } else throw new RuntimeException("docNumber cannot be NULL");
            if(params.get("docDate") != null){
                docDate = params.get("docDate");
            } else throw new RuntimeException("docDate cannot be NULL");
            if(params.get("docName") != null){
                documentTypeEntity = documentTypeDao.getByName(params.get("docName"));
            } else throw new RuntimeException("docName not be NULL");
            userEntity.setUserDocument(new UserDocumentEntity(docNumber, docDate, documentTypeEntity));
        }

        if(params.containsKey("citizenshipCode")){
            userEntity.setCountry(countryDao.getByCode(params.get("citizenshipCode")));
        }

        userDao.update(userEntity);
    }

    @Override
    public void save(Map<String, String> params) {
        Long id = Long.parseLong(params.get("officeId"));
        OfficeEntity officeEntity = officeDao.getById(id);
        UserDocumentEntity userDocumentEntity = null;
        DocumentTypeEntity documentTypeEntity = null;
        CountryEntity countryEntity = null;
        String docNumber;
        String docDate;

        if((params.get("docNumber") != null & params.get("docDate") != null)){
            docNumber = params.get("docNumber");
            docDate = params.get("docDate");
            if(params.get("docCode") != null){
                documentTypeEntity = documentTypeDao.getByCode(params.get("docCode"));
            } else if(params.get("docName") != null){
                    documentTypeEntity = documentTypeDao.getByName(params.get("docName"));
                }
            } else throw new RuntimeException("docCode or docName cannot be NULL");
            userDocumentEntity = new UserDocumentEntity(docNumber, docDate, documentTypeEntity);



        if(params.containsKey("citizenshipCode")){
            countryEntity = countryDao.getByCode(params.get("citizenshipCode"));
        }

        UserEntity userEntity = new UserEntity(params, officeEntity, userDocumentEntity, countryEntity);
        userDao.save(userEntity);

    }
}

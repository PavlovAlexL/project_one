package com.palex.practice.service.impl;

import com.palex.practice.dao.CountryDao;
import com.palex.practice.dao.DocumentTypeDao;
import com.palex.practice.dao.OfficeDao;
import com.palex.practice.dao.UserDao;
import com.palex.practice.dao.UserDocumentDao;
import com.palex.practice.model.CountryEntity;
import com.palex.practice.model.DocumentTypeEntity;
import com.palex.practice.model.OfficeEntity;
import com.palex.practice.model.UserDocumentEntity;
import com.palex.practice.model.UserEntity;
import com.palex.practice.model.mapper.MapperFacade;
import com.palex.practice.service.UserService;
import com.palex.practice.view.User.UserListFilterView;
import com.palex.practice.view.User.UserListView;
import com.palex.practice.view.User.UserSaveFilterView;
import com.palex.practice.view.User.UserUpdateFilterView;
import com.palex.practice.view.User.UserView;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

/**
 * Реализация сервиса
 */
@Service
public class UserServiceImpl implements UserService {


    private final UserDao userDao;
    private final OfficeDao officeDao;
    private final CountryDao countryDao;
    private final MapperFacade mapperFacade;
    private final DocumentTypeDao documentTypeDao;
    private final UserDocumentDao userDocumentDao;

    public UserServiceImpl(UserDao userDao, OfficeDao officeDao, CountryDao countryDao, DocumentTypeDao documentTypeDao, MapperFacade mapperFacade, UserDocumentDao userDocumentDao) {
        this.userDao = userDao;
        this.officeDao = officeDao;
        this.countryDao = countryDao;
        this.mapperFacade = mapperFacade;
        this.documentTypeDao = documentTypeDao;
        this.userDocumentDao = userDocumentDao;
    }

    /**
     * Отобразить объекты с параметрами.
     */
    @Transactional
    @Override
    public List<UserListView> list(UserListFilterView userListFilterView) {
        UserEntity userEntity = mapperFacade.map(userListFilterView, UserEntity.class);
        OfficeEntity officeEntity = officeDao.getById(userListFilterView.officeId);
        userEntity.setOffice(officeEntity);
        if (userListFilterView.docCode != null) {
            DocumentTypeEntity documentTypeEntity = documentTypeDao.getByCode(userListFilterView.docCode);
            UserDocumentEntity userDocumentEntity = new UserDocumentEntity(documentTypeEntity);
            userEntity.setUserDocument(userDocumentEntity);
        }
        if (userListFilterView.citizenshipCode != null) {
            CountryEntity countryEntity = countryDao.getByCode(userListFilterView.citizenshipCode);
            userEntity.setCountry(countryEntity);
        }
        List<UserEntity> userEntities = userDao.getByParams(userEntity);
        return mapperFacade.mapAsList(userEntities, UserListView.class);
    }

    /**
     *  Отобразить объект по Id.
     */
    @Transactional
    @Override
    public UserView getById(Long id) {
        UserEntity result = userDao.getById(id);
        return mapperFacade.map(result, UserView.class);
    }

    /**
     * Изменить объект.
     */
    @Transactional
    @Override
    public void update(UserUpdateFilterView userUpdateFilterView) {
        UserEntity userEntity = mapperFacade.map(userUpdateFilterView, UserEntity.class);
        if (userUpdateFilterView.officeId != null) {
            OfficeEntity officeEntity = officeDao.getById(userUpdateFilterView.officeId);
            userEntity.setOffice(officeEntity);
        }
        if (userUpdateFilterView.docNumber != null || userUpdateFilterView.docDate != null || userUpdateFilterView.docName != null) {
            if (userUpdateFilterView.docNumber != null & userUpdateFilterView.docDate != null & userUpdateFilterView.docName != null) {
                DocumentTypeEntity documentTypeEntity = documentTypeDao.getByName(userUpdateFilterView.docName);
                UserDocumentEntity userDocumentEntity = new UserDocumentEntity(userUpdateFilterView.docNumber, userUpdateFilterView.docDate, documentTypeEntity);
                userEntity.setUserDocument(userDocumentEntity);
            } else throw new RuntimeException("for update document must needs enter all document fields");
        }
        if (userUpdateFilterView.citizenshipCode != null) {
            CountryEntity countryEntity = countryDao.getByCode(userUpdateFilterView.citizenshipCode);
            userEntity.setCountry(countryEntity);
        }
        userDao.update(userEntity);
    }

    /**
     * Создать объект.
     */
    @Transactional
    @Override
    public void save(UserSaveFilterView userSaveFilterView) {
        UserEntity userEntity = mapperFacade.map(userSaveFilterView, UserEntity.class);
        OfficeEntity officeEntity = officeDao.getById(userSaveFilterView.officeId);
        userEntity.setOffice(officeEntity);
        if (userSaveFilterView.docCode != null || userSaveFilterView.docNumber != null || userSaveFilterView.docDate != null || userSaveFilterView.docName != null) {
            DocumentTypeEntity documentTypeEntity;
            if (userSaveFilterView.docCode != null) {
                documentTypeEntity = documentTypeDao.getByCode(userSaveFilterView.docCode);
            } else if (userSaveFilterView.docName != null) {
                documentTypeEntity = documentTypeDao.getByName(userSaveFilterView.docName);
            } else throw new RuntimeException("for saving document must needs docName or docCode");
            if (userSaveFilterView.docNumber != null & userSaveFilterView.docDate != null) {
                UserDocumentEntity userDocumentEntity = new UserDocumentEntity(userSaveFilterView.docNumber, userSaveFilterView.docDate, documentTypeEntity);
                userEntity.setUserDocument(userDocumentEntity);
            } else throw new RuntimeException("for saving document must needs enter docNumber and docDate");
        }
        if (userSaveFilterView.citizenshipCode != null) {
            CountryEntity countryEntity = countryDao.getByCode(userSaveFilterView.citizenshipCode);
            userEntity.setCountry(countryEntity);
        }
        userDao.save(userEntity);
    }
}

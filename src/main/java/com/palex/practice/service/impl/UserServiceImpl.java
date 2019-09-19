package com.palex.practice.service.impl;

import com.palex.practice.dao.CountryDao;
import com.palex.practice.dao.DocumentTypeDao;
import com.palex.practice.dao.OfficeDao;
import com.palex.practice.dao.UserDao;
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
 * Реализация сервиса для работы с объектами пользователь.
 */
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

    /**
     * Отобразить пользователей по параметрам.
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
     *  Отобразить пользователя по идентификатору.
     */
    @Transactional
    @Override
    public UserView getById(Long id) {
        UserEntity result = userDao.getById(id);
        return mapperFacade.map(result, UserView.class);
    }

    /**
     * Изменить пользователя.
     */
    @Transactional
    @Override
    public void update(UserUpdateFilterView userUpdateFilterView) {

        Long id = userUpdateFilterView.id;
        Long officeId = userUpdateFilterView.officeId;
        String firstName = userUpdateFilterView.firstName;
        String lastName = userUpdateFilterView.lastName;
        String middleName = userUpdateFilterView.middleName;
        String position = userUpdateFilterView.position;
        String phone = userUpdateFilterView.phone;
        String docName = userUpdateFilterView.docName;
        String docNumber = userUpdateFilterView.docNumber;
        String docDate = userUpdateFilterView.docDate;
        String citizenshipCode = userUpdateFilterView.citizenshipCode;
        Boolean isIdentified = Boolean.parseBoolean(userUpdateFilterView.isIdentified);

        UserEntity userEntity = userDao.getById(id);

        if (officeId != null) {
            OfficeEntity officeEntity = officeDao.getById(officeId);
            userEntity.setOffice(officeEntity);
        }

        if (firstName != null) {
            userEntity.setFirstName(firstName);
        }

        if (lastName != null) {
            userEntity.setLastName(lastName);
        }

        if (middleName != null) {
            userEntity.setMiddleName(middleName);
        }

        userEntity.setPosition(position);

        if (phone != null) {
            userEntity.setPhone(phone);
        }

        if (docNumber != null & docDate != null & docName != null) {
            UserDocumentEntity userDocumentEntity;
            if (userEntity.getUserDocument() != null) {
                userDocumentEntity = userEntity.getUserDocument();
            } else {
                userDocumentEntity = new UserDocumentEntity();
            }

            DocumentTypeEntity documentTypeEntity = documentTypeDao.getByName(docName);
            userDocumentEntity.setDocumentType(documentTypeEntity);
            userDocumentEntity.setDocNumber(docNumber);
            userDocumentEntity.setDoc_date(docDate);
        } else throw new RuntimeException("for update document must needs enter all document fields");

        if (citizenshipCode != null) {
            CountryEntity countryEntity = countryDao.getByCode(userUpdateFilterView.citizenshipCode);
            userEntity.setCountry(countryEntity);
        }

        if (isIdentified != null) {
            userEntity.setIsIdentified(isIdentified);
        }

        userDao.update(userEntity);
    }

    /**
     * Создать пользователя.
     */
    @Transactional
    @Override
    public void save(UserSaveFilterView userSaveFilterView) {

        Long officeId = userSaveFilterView.officeId;
        String firstName = userSaveFilterView.firstName;
        String lastName = userSaveFilterView.lastName;
        String middleName = userSaveFilterView.middleName;
        String position = userSaveFilterView.position;
        String phone = userSaveFilterView.phone;
        String docCode = userSaveFilterView.docCode;
        String docName = userSaveFilterView.docName;
        String docNumber = userSaveFilterView.docNumber;
        String docDate = userSaveFilterView.docDate;
        String citizenshipCode = userSaveFilterView.citizenshipCode;
        Boolean isIdentified = Boolean.parseBoolean(userSaveFilterView.isIdentified);

        OfficeEntity officeEntity = null;
        if (officeId != null) {
            officeEntity = officeDao.getById(officeId);
        }

        UserDocumentEntity userDocumentEntity = null;
        if (docCode != null || docNumber != null || docDate != null || docName != null) {
            DocumentTypeEntity documentTypeEntity;
            if (userSaveFilterView.docCode != null) {
                documentTypeEntity = documentTypeDao.getByCode(userSaveFilterView.docCode);
            } else if (userSaveFilterView.docName != null) {
                documentTypeEntity = documentTypeDao.getByName(userSaveFilterView.docName);
            } else throw new RuntimeException("for saving document must needs docName or docCode");

            if (docNumber != null & docDate != null & documentTypeEntity != null) {
                userDocumentEntity = new UserDocumentEntity(docNumber, docDate, documentTypeEntity);
            } else throw new RuntimeException("for saving document must needs enter docNumber and docDate");
        }

        CountryEntity countryEntity = null;
        if (citizenshipCode != null) {
            countryEntity = countryDao.getByCode(citizenshipCode);
        }

        UserEntity userEntity = new UserEntity(officeEntity, firstName, lastName, middleName, position, phone, isIdentified, userDocumentEntity, countryEntity);

        userDao.save(userEntity);
    }
}

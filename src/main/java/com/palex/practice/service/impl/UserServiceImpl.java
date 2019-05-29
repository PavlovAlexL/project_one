package com.palex.practice.service.impl;

import com.palex.practice.dao.CountryDao;
import com.palex.practice.dao.DocumentTypeDao;
import com.palex.practice.dao.OfficeDao;
import com.palex.practice.dao.UserDao;
import com.palex.practice.model.*;
import com.palex.practice.model.mapper.MapperFacade;
import com.palex.practice.service.UserService;
import com.palex.practice.view.User.*;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

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

    @Transactional
    @Override
    public List<UserListView> list(UserListFilterView userListFilterView) {
        System.out.println(userListFilterView);
        return mapperFacade.mapAsList(userDao.getByParams(userListFilterView), UserListView.class);
    }

    @Transactional
    @Override
    public UserView getById(Long id) {

        UserEntity result = userDao.getById(id);
        return mapperFacade.map(result, UserView.class);

    }

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
        String isIdentified = userUpdateFilterView.isIdentified;

        UserEntity userEntity = userDao.getById(id);

        if (officeId != null) {
            userEntity.setOffice(
                    officeDao.getById(officeId));
        }

        userEntity.setFirstName(firstName);

        if (lastName.length() > 0) {
            userEntity.setLastName(lastName);
        }

        if (middleName.length() > 0) {
            userEntity.setMiddleName(middleName);
        }

        userEntity.setPosition(position);

        if (phone.length() > 0) {
            userEntity.setPhone(phone);
        }

        if (isIdentified.length() > 0) {
            userEntity.setIsIdentified(Boolean.parseBoolean(isIdentified));
        }

        if (docNumber.length() > 0 || docDate.length() > 0 || docName.length() > 0) {
            if (docNumber.length() > 0 & docDate.length() > 0 & docName.length() > 0) {
                userEntity.setUserDocument(
                        new UserDocumentEntity(
                                docNumber,
                                docDate,
                                documentTypeDao.getByName(docName)));
            } else throw new RuntimeException("for update document must needs enter all document fields");
        }

        if (citizenshipCode.length() > 0) {
            userEntity.setCountry(countryDao.getByCode(citizenshipCode));
        }
        userDao.update(userEntity);
    }

    @Transactional
    @Override
    public void save(UserSaveFilterView userSaveFilterView) {

        UserEntity userEntity = mapperFacade.map(userSaveFilterView, UserEntity.class);

        OfficeEntity officeEntity = officeDao.getById(userSaveFilterView.officeId);
        userEntity.setOffice(officeEntity);

        DocumentTypeEntity documentTypeEntity = null;
        UserDocumentEntity userDocumentEntity;
        CountryEntity countryEntity;

        String docCode = userSaveFilterView.docCode;
        String docName = userSaveFilterView.docName;
        String docNumber = userSaveFilterView.docNumber;
        String docDate = userSaveFilterView.docDate;
        String citizenshipCode = userSaveFilterView.citizenshipCode;

        if (docCode.length() > 0 || docName.length() > 0 || docDate.length() > 0 || docNumber.length() > 0) {
            if (docCode.length() > 0) {
                documentTypeEntity = documentTypeDao.getByCode(docCode);
            } else if (docName.length() > 0) {
                documentTypeEntity = documentTypeDao.getByName(docName);
            } else throw new RuntimeException("for saving document must needs docName or docCode");

            if (documentTypeEntity != null & docNumber.length() > 0 & docDate.length() > 0) {
                userDocumentEntity = new UserDocumentEntity(docNumber, docDate, documentTypeEntity);
                userEntity.setUserDocument(userDocumentEntity);
            } else throw new RuntimeException("for saving document must needs enter docNumber and docDate");
        }

        if (citizenshipCode.length() > 0) {
            countryEntity = countryDao.getByCode(citizenshipCode);
            userEntity.setCountry(countryEntity);
        }

        userDao.save(userEntity);
    }
}

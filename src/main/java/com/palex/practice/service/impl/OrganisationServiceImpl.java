package com.palex.practice.service.impl;

import com.palex.practice.dao.OrganisationDao;
import com.palex.practice.model.OrganisationEntity;
import com.palex.practice.model.mapper.MapperFacade;
import com.palex.practice.service.OrganisationService;
import com.palex.practice.view.Organisation.OrganisationListFilterView;
import com.palex.practice.view.Organisation.OrganisationListView;
import com.palex.practice.view.Organisation.OrganisationSaveFilterView;
import com.palex.practice.view.Organisation.OrganisationUpdateFilterView;
import com.palex.practice.view.Organisation.OrganisationView;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

/**
 * Реализация сервиса Организации.
 */
@Service
public class OrganisationServiceImpl implements OrganisationService {

    private final OrganisationDao organisationDao;
    private final MapperFacade mapperFacade;

    public OrganisationServiceImpl(OrganisationDao organisationDao, MapperFacade mapperFacade) {
        this.organisationDao = organisationDao;
        this.mapperFacade = mapperFacade;
    }

    /**
     * Отобразить объекты организаци по параметрам.
     */
    @Override
    @Transactional
    public List<OrganisationListView> list(OrganisationListFilterView organisationListFilterView) {
        OrganisationEntity organisationEntity = mapperFacade.map(organisationListFilterView, OrganisationEntity.class);
        List<OrganisationEntity> organisationEntities = organisationDao.getByParams(organisationEntity);
        return mapperFacade.mapAsList(organisationEntities, OrganisationListView.class);
    }

    /**
     *  Отобразить объект организации по идентификатору.
     */
    @Override
    @Transactional
    public OrganisationView getById(Long id) {
        OrganisationEntity organisationEntity = organisationDao.getById(id);
        return mapperFacade.map(organisationEntity, OrganisationView.class);
    }

    /**
     * Изменить объект организации в БД.
     */
    @Override
    @Transactional
    public void update(OrganisationUpdateFilterView organisationUpdateFilterView) {
        Long id = organisationUpdateFilterView.id;
        OrganisationEntity organisationEntity = organisationDao.getById(id);

        organisationEntity.setName(organisationUpdateFilterView.name);
        organisationEntity.setFullName(organisationUpdateFilterView.fullName);
        organisationEntity.setInn(organisationUpdateFilterView.inn);
        organisationEntity.setKpp(organisationUpdateFilterView.kpp);
        organisationEntity.setAddress(organisationUpdateFilterView.address);

        if (organisationUpdateFilterView.phone != null) {
            organisationEntity.setPhone(organisationUpdateFilterView.phone);
        }
        if (organisationUpdateFilterView.isActive != null) {
            organisationEntity.setIsActive(Boolean.parseBoolean(organisationUpdateFilterView.isActive));
        }
        organisationDao.update(organisationEntity);
    }

    /**
     * Создать объект организации и сохранить в БД.
     */
    @Override
    @Transactional
    public void save(OrganisationSaveFilterView organisationSaveFilterView) {
        String name = organisationSaveFilterView.name;
        String fullName = organisationSaveFilterView.fullName;
        String inn = organisationSaveFilterView.inn;
        String kpp = organisationSaveFilterView.kpp;
        String address = organisationSaveFilterView.address;
        String phone = organisationSaveFilterView.phone;
        Boolean isActive = Boolean.parseBoolean(organisationSaveFilterView.isActive);
        OrganisationEntity organisationEntity = new OrganisationEntity(name, fullName, inn, kpp, address, phone, isActive);
        organisationDao.save(organisationEntity);
    }
}


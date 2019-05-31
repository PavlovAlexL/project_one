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
 * Реализация сервиса
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
     * Отобразить объекты по параметрам.
     */
    @Override
    @Transactional
    public List<OrganisationListView> list(OrganisationListFilterView organisationListFilterView) {
        OrganisationEntity organisationEntity = mapperFacade.map(organisationListFilterView, OrganisationEntity.class);
        List<OrganisationEntity> organisationEntities = organisationDao.getByParams(organisationEntity);
        return mapperFacade.mapAsList(organisationEntities, OrganisationListView.class);
    }

    /**
     *  Отобразить объект по Id.
     */
    @Override
    @Transactional
    public OrganisationView getById(Long id) {
        OrganisationEntity organisationEntity = organisationDao.getById(id);
        return mapperFacade.map(organisationEntity, OrganisationView.class);
    }

    /**
     * Изменить объект.
     */
    @Override
    @Transactional
    public void update(OrganisationUpdateFilterView organisationUpdateFilterView) {
        OrganisationEntity organisationEntity = mapperFacade.map(organisationUpdateFilterView, OrganisationEntity.class);
        organisationDao.update(organisationEntity);
    }

    /**
     * Создать объект.
     */
    @Override
    @Transactional
    public void save(OrganisationSaveFilterView organisationSaveFilterView) {
        OrganisationEntity organisationEntity = mapperFacade.map(organisationSaveFilterView, OrganisationEntity.class);
        organisationDao.save(organisationEntity);
    }

}


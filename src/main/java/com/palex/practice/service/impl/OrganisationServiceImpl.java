package com.palex.practice.service.impl;

import com.palex.practice.dao.OrganisationDao;
import com.palex.practice.model.mapper.MapperFacade;
import com.palex.practice.service.OrganisationService;
import com.palex.practice.view.Organisation.*;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class OrganisationServiceImpl implements OrganisationService {

    private final OrganisationDao organisationDao;
    private final MapperFacade mapperFacade;

    public OrganisationServiceImpl(OrganisationDao organisationDao, MapperFacade mapperFacade) {
        this.organisationDao = organisationDao;
        this.mapperFacade = mapperFacade;
    }

    @Override
    @Transactional
    public List<OrganisationListView> list(OrganisationListFilterView organisationListFilterView) {
        return mapperFacade.mapAsList(organisationDao.getByParams(organisationListFilterView), OrganisationListView.class);
    }

    @Override
    @Transactional
    public OrganisationView getById(Long id) {
        return mapperFacade.map(organisationDao.getById(id), OrganisationView.class);
    }

    @Override
    @Transactional
    public void update(OrganisationUpdateFilterView organisationUpdateFilterView) {
        organisationDao.update(organisationUpdateFilterView);
    }

    @Override
    @Transactional
    public void save(OrganisationSaveFilterView organisationSaveFilterView) {
        organisationDao.save(organisationSaveFilterView);
    }

}


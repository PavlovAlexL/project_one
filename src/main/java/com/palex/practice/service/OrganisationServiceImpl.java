package com.palex.practice.service;

import com.palex.practice.dao.OrganisationDao;
import com.palex.practice.model.OrganisationEntity;
import com.palex.practice.model.mapper.MapperFacade;
import com.palex.practice.view.OrganisationView;
import org.springframework.stereotype.Service;

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
    public List<OrganisationView> list(String params) {
        List<OrganisationEntity> result = organisationDao.getByParams(params);
        return mapperFacade.mapAsList(result, OrganisationView.class);
    }

    @Override
    public OrganisationView getById(Long id) {
        OrganisationEntity result = organisationDao.getById(id);
        return mapperFacade.map(result, OrganisationView.class);
    }

    @Override
    public String update(String params) {
        return organisationDao.update(params);
    }

    @Override
    public String save(OrganisationEntity organisation) {
        return organisationDao.save(organisation);

    }
}

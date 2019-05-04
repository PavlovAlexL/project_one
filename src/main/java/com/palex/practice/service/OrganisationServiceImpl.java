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
    public List<OrganisationView> list(String organisationName,
                                       String organisationInn,
                                       Boolean organisationStatus) {
        List<OrganisationEntity> result = organisationDao.getByParams(organisationName, organisationInn, organisationStatus);
        return mapperFacade.mapAsList(result, OrganisationView.class);
    }

    @Override
    public OrganisationView getById(Long id) {
        OrganisationEntity result = organisationDao.getById(id);
        return mapperFacade.map(result, OrganisationView.class);
    }

    @Override
    public String update(Long organisationId,
                         String organisationName,
                         String organisationFullName,
                         String organisationInn,
                         String organisationKpp,
                         String organisationAddress,
                         String organisationPhone,
                         Boolean organisationStatus) {
        return organisationDao.update(
                organisationId,
                organisationName,
                organisationFullName,
                organisationInn,
                organisationKpp,
                organisationAddress,
                organisationPhone,
                organisationStatus);
    }

    @Override
    public String save(String organisationName, String organisationFullName, String organisationInn, String organisationKpp,String organisationAddress, String organisationPhone, Boolean organisationStatus){
        OrganisationEntity oe = new OrganisationEntity(organisationName, organisationFullName, organisationInn, organisationKpp, organisationAddress, organisationPhone, organisationStatus);
        return organisationDao.save(oe);
    }
}


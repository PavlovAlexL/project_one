package com.palex.practice.service.impl;

import com.palex.practice.dao.OrganisationDao;
import com.palex.practice.model.OrganisationEntity;
import com.palex.practice.model.mapper.MapperFacade;
import com.palex.practice.service.OrganisationService;
import com.palex.practice.view.OrganisationView;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class OrganisationServiceImpl implements OrganisationService {

    private final OrganisationDao organisationDao;
    private final MapperFacade mapperFacade;

    public OrganisationServiceImpl(OrganisationDao organisationDao, MapperFacade mapperFacade) {
        this.organisationDao = organisationDao;
        this.mapperFacade = mapperFacade;
    }

    @Override
    public List<OrganisationView> list(Map<String, String> params) {
        List<OrganisationEntity> result = organisationDao.getByParams(params.get("name"));

        if(params.containsKey("inn")&params.get("inn") != null){
            List<OrganisationEntity> temp = new ArrayList<>();
            String inn = params.get("inn");
            for(OrganisationEntity oe : result){
                if(oe.getInn().equals(inn)){
                    temp.add(oe);
                }
            }
            result = temp;
        }

        if(params.containsKey("isActive")&params.get("isActive") != null){
            List<OrganisationEntity> temp = new ArrayList<>();
            Boolean status = Boolean.parseBoolean(params.get("isActive"));
            for(OrganisationEntity oe : result){
                if(oe.getIsActive().equals(status)){
                    temp.add(oe);
                }
            }
            result = temp;
        }

        return mapperFacade.mapAsList(result, OrganisationView.class);
    }

    @Override
    public OrganisationView getById(Long id) {
        OrganisationEntity result = organisationDao.getById(id);
        return mapperFacade.map(result, OrganisationView.class);
    }

    @Override
    public void update(Map<String, String> params) {
        organisationDao.update(params);
    }

    @Override
    public void save(Map<String, String> params){
        OrganisationEntity oe = new OrganisationEntity(params);
        organisationDao.save(oe);
    }

}


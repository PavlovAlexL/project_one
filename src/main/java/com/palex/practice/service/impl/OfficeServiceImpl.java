package com.palex.practice.service.impl;

import com.palex.practice.dao.OfficeDao;
import com.palex.practice.dao.OrganisationDao;
import com.palex.practice.model.OfficeEntity;
import com.palex.practice.model.OrganisationEntity;
import com.palex.practice.model.mapper.MapperFacade;
import com.palex.practice.service.OfficeService;
import com.palex.practice.view.OfficeView;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class OfficeServiceImpl implements OfficeService {

    private final OfficeDao officeDao;
    private final OrganisationDao organisationDao;
    private final MapperFacade mapperFacade;

    public OfficeServiceImpl(OfficeDao officeDao, OrganisationDao organisationDao, MapperFacade mapperFacade) {
        this.officeDao = officeDao;
        this.organisationDao = organisationDao;
        this.mapperFacade = mapperFacade;
    }

    @Override
    public List<OfficeView> list(Map<String, String> params) {
        OrganisationEntity organisationEntity = organisationDao.getById(Long.parseLong(params.get("orgId")));
        List<OfficeEntity> result = officeDao.getByParams(organisationEntity);

        if(params.containsKey("name")&params.get("name") != null){
            List<OfficeEntity> temp = new ArrayList<>();
            String name = params.get("name");
            for(OfficeEntity oe : result){
                if(oe.getName().equals(name)){
                    temp.add(oe);
                }
            }
            result = temp;
        }
        if(params.containsKey("phone")&params.get("phone") != null){
            List<OfficeEntity> temp = new ArrayList<>();
            String phone = params.get("phone");
            for(OfficeEntity oe : result){
                if(oe.getPhone().equals(phone)){
                    temp.add(oe);
                }
            }
            result = temp;
        }
        if(params.containsKey("isActive")&params.get("isActive") != null){
            List<OfficeEntity> temp = new ArrayList<>();
            Boolean status = Boolean.parseBoolean(params.get("phone"));
            for(OfficeEntity oe : result){
                if(oe.getIsActive().equals(status)){
                    temp.add(oe);
                }
            }
            result = temp;
        }
        return mapperFacade.mapAsList(result, OfficeView.class);
    }

    @Override
    public OfficeView getById(Long id) {
        OfficeEntity result = officeDao.getById(id);
        return mapperFacade.map(result, OfficeView.class);
    }

    @Override
    public void update(Map<String, String> params) {
        officeDao.update(params);
    }

    @Override
    public void save(Map<String, String> params) {
        OrganisationEntity organisationEntity = organisationDao.getById(Long.parseLong(params.get("orgId")));
        OfficeEntity officeEntity = new OfficeEntity(params, organisationEntity);
        officeDao.save(officeEntity);
    }

}

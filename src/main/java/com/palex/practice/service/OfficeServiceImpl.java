package com.palex.practice.service;

import com.palex.practice.dao.OfficeDao;
import com.palex.practice.model.OfficeEntity;
import com.palex.practice.model.mapper.MapperFacade;
import com.palex.practice.view.OfficeView;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class OfficeServiceImpl implements OfficeService {

    private final OfficeDao officeDao;
    private final MapperFacade mapperFacade;

    public OfficeServiceImpl(OfficeDao officeDao, MapperFacade mapperFacade) {
        this.officeDao = officeDao;
        this.mapperFacade = mapperFacade;
    }

    @Override
    public List<OfficeView> list(Map<String, String> params) {
        List<OfficeEntity> offices = officeDao.getByParams(params);
        return mapperFacade.mapAsList(offices, OfficeView.class);
    }

    @Override
    public OfficeView getById(Long id) {
        OfficeEntity office = officeDao.getById(id);
        return mapperFacade.map(office, OfficeView.class);
    }

    @Override
    public String update(Map<String, String> params) {
        officeDao.update(params);
        return null;
    }

    @Override
    public String save(Map<String, String> params) {
        officeDao.save(params);
        return null;
    }
}

package com.palex.practice.service.impl;

import com.palex.practice.dao.OfficeDao;
import com.palex.practice.dao.OrganisationDao;
import com.palex.practice.model.OfficeEntity;
import com.palex.practice.model.OrganisationEntity;
import com.palex.practice.model.mapper.MapperFacade;
import com.palex.practice.service.OfficeService;
import com.palex.practice.view.Office.*;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

/**
 * Реализация сервиса
 */
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

    /**
     * Отобразить объекты с параметрами.
     */
    @Override
    @Transactional
    public List<OfficeListView> list(OfficeListFilterView officeListFilterView) {
        return mapperFacade.mapAsList(
                officeDao.getByParams(officeListFilterView), OfficeListView.class);
    }

    /**
     *  Отобразить объект по Id.
     */
    @Override
    @Transactional
    public OfficeView getById(Long id) {
        return mapperFacade.map(officeDao.getById(id), OfficeView.class);
    }

    /**
     * Изменить объект.
     */
    @Override
    @Transactional
    public void update(OfficeUpdateFilterView officeUpdateFilterView) {
        officeDao.update(officeUpdateFilterView);
    }

    /**
     * Создать объект.
     */
    @Override
    @Transactional
    public void save(OfficeSaveFilterView officeSaveFilterView) {
        OfficeEntity officeEntity = mapperFacade.map(officeSaveFilterView, OfficeEntity.class);
        OrganisationEntity organisationEntity = organisationDao.getById(officeSaveFilterView.orgId);
        officeEntity.setOrganisation(organisationEntity);
        officeDao.save(officeEntity);
    }

}

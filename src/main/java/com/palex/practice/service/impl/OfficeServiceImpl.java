package com.palex.practice.service.impl;

import com.palex.practice.dao.OfficeDao;
import com.palex.practice.dao.OrganisationDao;
import com.palex.practice.model.OfficeEntity;
import com.palex.practice.model.OrganisationEntity;
import com.palex.practice.model.mapper.MapperFacade;
import com.palex.practice.service.OfficeService;
import com.palex.practice.view.Office.OfficeListFilterView;
import com.palex.practice.view.Office.OfficeListView;
import com.palex.practice.view.Office.OfficeSaveFilterView;
import com.palex.practice.view.Office.OfficeUpdateFilterView;
import com.palex.practice.view.Office.OfficeView;
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
        OfficeEntity officeEntity = mapperFacade.map(officeListFilterView, OfficeEntity.class);
        if (officeListFilterView.orgId != null) {
            officeEntity.setOrganisation(organisationDao.getById(officeListFilterView.orgId));
        }
        List<OfficeEntity> officeEntities = officeDao.getByParams(officeEntity);
        return mapperFacade.mapAsList(officeEntities, OfficeListView.class);
    }

    /**
     *  Отобразить объект по Id.
     */
    @Override
    @Transactional
    public OfficeView getById(Long id) {
        OfficeEntity officeEntity = officeDao.getById(id);
        return mapperFacade.map(officeEntity, OfficeView.class);
    }

    /**
     * Изменить объект.
     */
    @Override
    @Transactional
    public void update(OfficeUpdateFilterView officeUpdateFilterView) {
        OfficeEntity officeEntity = mapperFacade.map(officeUpdateFilterView, OfficeEntity.class);
        officeDao.update(officeEntity);
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

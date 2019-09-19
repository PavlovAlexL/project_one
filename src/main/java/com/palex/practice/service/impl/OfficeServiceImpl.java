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
 * Реализация сервиса для работы с объектами типа офис.
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
     * Отобразить объекты офис по параметрам.
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
     *  Отобразить офис по идентификатору.
     */
    @Override
    @Transactional
    public OfficeView getById(Long id) {
        OfficeEntity officeEntity = officeDao.getById(id);
        return mapperFacade.map(officeEntity, OfficeView.class);
    }

    /**
     * Изменить офис.
     */
    @Override
    @Transactional
    public void update(OfficeUpdateFilterView officeUpdateFilterView) {
        Long id = officeUpdateFilterView.id;
        OfficeEntity officeEntity = officeDao.getById(id);

        officeEntity.setName(officeUpdateFilterView.name);
        officeEntity.setAddress(officeUpdateFilterView.address);

        if (officeUpdateFilterView.phone != null) {
            officeEntity.setPhone(officeUpdateFilterView.phone);
        }
        if (officeUpdateFilterView.isActive != null) {
            officeEntity.setIsActive(Boolean.parseBoolean(officeUpdateFilterView.isActive));
        }
        officeDao.update(officeEntity);
    }

    /**
     * Создать офис.
     */
    @Override
    @Transactional
    public void save(OfficeSaveFilterView officeSaveFilterView) {
        //OfficeEntity officeEntity = mapperFacade.map(officeSaveFilterView, OfficeEntity.class);
        Long orgId = officeSaveFilterView.orgId;
        String name = officeSaveFilterView.name;
        String address = officeSaveFilterView.address;
        String phone = officeSaveFilterView.phone;
        Boolean isActive = Boolean.parseBoolean(officeSaveFilterView.isActive);
        OrganisationEntity organisationEntity = organisationDao.getById(orgId);
        OfficeEntity officeEntity = new OfficeEntity(name, address, phone, isActive, organisationEntity);
        officeDao.save(officeEntity);
    }
}

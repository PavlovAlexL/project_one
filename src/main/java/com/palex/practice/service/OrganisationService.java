package com.palex.practice.service;

import com.palex.practice.view.Organisation.OrganisationListFilterView;
import com.palex.practice.view.Organisation.OrganisationListView;
import com.palex.practice.view.Organisation.OrganisationSaveFilterView;
import com.palex.practice.view.Organisation.OrganisationUpdateFilterView;
import com.palex.practice.view.Organisation.OrganisationView;

import java.util.List;

/**
 * Сервис для работы с объектами типа организация.
 */
public interface OrganisationService {

    /**
     * Отобразить организации по параметрам.
     */
    List<OrganisationListView> list(OrganisationListFilterView organisationListFilterView);

    /**
     *  Отобразить организацию по идентификатору.
     */
    OrganisationView getById(Long id);

    /**
     * Изменить организацию.
     */
    void update(OrganisationUpdateFilterView organisationUpdateFilterView);

    /**
     * Создать организацию.
     */
    void save(OrganisationSaveFilterView organisationSaveFilterView);
}

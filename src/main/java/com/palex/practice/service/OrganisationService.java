package com.palex.practice.service;

import com.palex.practice.view.Organisation.OrganisationListFilterView;
import com.palex.practice.view.Organisation.OrganisationListView;
import com.palex.practice.view.Organisation.OrganisationSaveFilterView;
import com.palex.practice.view.Organisation.OrganisationUpdateFilterView;
import com.palex.practice.view.Organisation.OrganisationView;

import java.util.List;

/**
 * Сервис
 */
public interface OrganisationService {

    /**
     * Отобразить объекты по параметрам.
     */
    List<OrganisationListView> list(OrganisationListFilterView organisationListFilterView);

    /**
     *  Отобразить объект по Id.
     */
    OrganisationView getById(Long id);

    /**
     * Изменить объект.
     */
    void update(OrganisationUpdateFilterView organisationUpdateFilterView);

    /**
     * Создать объект.
     */
    void save(OrganisationSaveFilterView organisationSaveFilterView);

}

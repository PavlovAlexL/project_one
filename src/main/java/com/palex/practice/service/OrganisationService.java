package com.palex.practice.service;

import com.palex.practice.view.Organisation.*;

import java.util.List;

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

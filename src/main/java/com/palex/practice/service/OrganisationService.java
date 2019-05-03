package com.palex.practice.service;

import com.palex.practice.model.OrganisationEntity;
import com.palex.practice.view.OrganisationView;

import java.util.List;

public interface OrganisationService {

    /**
     * Отобразить объекты по параметрам.
     */
    List<OrganisationView> list(String params);

    /**
     *  Отобразить объект по Id.
     */
    OrganisationView getById(Long id);

    /**
     * Изменить объект.
     */
    String update(String params);

    /**
     * Создать объект.
     */
    String save(OrganisationEntity organisationEntity);

}

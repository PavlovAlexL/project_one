package com.palex.practice.service;

import com.palex.practice.view.OrganisationView;

import java.util.List;
import java.util.Map;

public interface OrganisationService {

    /**
     * Отобразить объекты по параметрам.
     */
    List<OrganisationView> list(Map<String, String> params);

    /**
     *  Отобразить объект по Id.
     */
    OrganisationView getById(Long id);

    /**
     * Изменить объект.
     */
    void update(Map<String, String> params);

    /**
     * Создать объект.
     */
    void save(Map<String, String> params);

}

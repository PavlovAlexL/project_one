package com.palex.practice.service;

import com.palex.practice.model.OrganisationEntity;

public interface OrganisationService {

    /**
     * Отобразить объекта с параметрами.
     */
    void list(Object ... parametr);

    /**
     *  Отобразить объект по Id.
     */
    void getById(Integer id);

    /**
     * Изменить объект.
     */
    void update(OrganisationEntity organisation);

    /**
     * Создать объект.
     */
    void save(OrganisationEntity organisation);

}

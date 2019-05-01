package com.palex.practice.dao;

import com.palex.practice.model.OrganisationEntity;

import java.util.List;

/**
 * DAO для доступа к организации.
 */
public interface OrganisationDao {

    /**
     * Получение коллекции объектов по id.
     * @param name
     * @return
     */
    List<OrganisationEntity> getByName(String name);

    /**
     * Получение коллекции по параметрам.
     * @param param
     * @return
     */
    List<OrganisationEntity> getByParams(Object ... param);

    /**
     * Получение объекта по ID.
     * @param id
     * @return
     */
    OrganisationEntity getById (Long id);

    /**
     * Сохранить объект office.
     * @param organisationEntity
     */
    void save (OrganisationEntity organisationEntity);

    /**
     * Изменить объект office.
     * @param organisationEntity
     */
    void update (OrganisationEntity organisationEntity);
}


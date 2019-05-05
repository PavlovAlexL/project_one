package com.palex.practice.dao;

import com.palex.practice.model.OrganisationEntity;

import java.util.List;
import java.util.Map;

/**
 * DAO для доступа к таблице организация.
 */
public interface OrganisationDao {

    /**
     * Получение коллекции объектов по параметрам.
     * @param name
     * @return
     */
    List<OrganisationEntity> getByParams(String name);

    /**
     * Получение объекта по ID.
     * @param id
     * @return
     */
    OrganisationEntity getById (Long id);

    /**
     * Изменить объект.
     * @param
     */
    void update (Map<String, String> params);

    /**
     * Сохраненить объект.
     * @param organisationEntity
     */
    void save (OrganisationEntity organisationEntity);

}


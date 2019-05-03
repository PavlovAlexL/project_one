package com.palex.practice.dao;

import com.palex.practice.model.OrganisationEntity;

import java.util.List;

/**
 * DAO для доступа к организации.
 */
public interface OrganisationDao {

    /**
     * Получение коллекции объектов по параметрам.
     * @param params
     * @return
     */
    List<OrganisationEntity> getByParams(Object ... params);

    /**
     * Получение объекта по ID.
     * @param id
     * @return
     */
    OrganisationEntity getById (Long id);

    /**
     * Сохраненить объект.
     * @param organisationEntity
     */
    String save (OrganisationEntity organisationEntity);

    /**
     * Изменить объект.
     * @param params строка с параметрами, разделенная запятой.
     */
    String update (String params);
}


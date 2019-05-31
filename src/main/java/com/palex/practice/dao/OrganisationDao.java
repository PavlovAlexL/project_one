package com.palex.practice.dao;

import com.palex.practice.model.OrganisationEntity;

import java.util.List;

/**
 * DAO для доступа к Organisation.
 */
public interface OrganisationDao {

    /**
     * Получение коллекции объектов по параметрам.
     *
     * @return
     */
    List<OrganisationEntity> getByParams(OrganisationEntity organisationEntity);

    /**
     * Получение объекта по ID.
     *
     * @param id
     * @return
     */
    OrganisationEntity getById(Long id);

    /**
     * Изменить объект.
     *
     * @param
     */
    void update(OrganisationEntity organisationEntity);

    /**
     * Сохраненить объект.
     * @param
     */
    void save(OrganisationEntity organisationEntity);

}


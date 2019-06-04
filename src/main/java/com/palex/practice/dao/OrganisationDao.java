package com.palex.practice.dao;

import com.palex.practice.model.OrganisationEntity;

import java.util.List;

/**
 * DAO для доступа к организации.
 */
public interface OrganisationDao {

    /**
     * Получение коллекции объектов организаций.
     * @param organisationEntity Организация.
     * @return коллекция организаций.
     */
    List<OrganisationEntity> getByParams(OrganisationEntity organisationEntity);

    /**
     * Получение объекта по идентификатору.
     * @param id идентификатор.
     * @return организация.
     */
    OrganisationEntity getById(Long id);

    /**
     * Изменить организацию.
     * @param organisationEntity Организация.
     */
    void update(OrganisationEntity organisationEntity);

    /**
     * Сохранить организацию.
     * @param organisationEntity Организация.
     */
    void save(OrganisationEntity organisationEntity);

}


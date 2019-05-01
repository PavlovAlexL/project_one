package com.palex.practice.dao;

import com.palex.practice.model.OfficeEntity;

import java.util.List;

/**
 * DAO для работы с office
 */
public interface OfficeDao {

    /**
     * Получение коллекции объектов по id.
     * @param id
     * @return
     */
    List<OfficeEntity> getByOrgId(Long id);

    /**
     * Получение коллекции по параметрам.
     * @param param
     * @return
     */
    List<OfficeEntity> getByParams(Object ... param);

    /**
     * Получение объекта по ID
     * @param id
     * @return
     */
    OfficeEntity getById (Long id);

    /**
     * Сохранить объект office
     * @param officeEntity
     */
    void save (OfficeEntity officeEntity);

    /**
     * Изменить объект office
     * @param officeEntity
     */
    void update (OfficeEntity officeEntity);
 }

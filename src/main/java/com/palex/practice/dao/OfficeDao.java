package com.palex.practice.dao;

import com.palex.practice.model.OfficeEntity;

import java.util.List;

/**
 * DAO для доступа к Office.
 */
public interface OfficeDao {

    /**
     * Получение коллекции объектов по параметрам.
     *
     * @return
     */
    List<OfficeEntity> getByParams(OfficeEntity officeEntity);

    /**
     * Получение объекта по ID.
     *
     * @param id
     * @return
     */
    OfficeEntity getById(Long id);

    /**
     * Изменить объект.
     *
     * @param
     */
    void update(OfficeEntity officeEntity);

    /**
     * Сохраненить объект.
     * @param
     */
    void save (OfficeEntity officeEntity);
}

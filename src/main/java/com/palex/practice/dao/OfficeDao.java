package com.palex.practice.dao;

import com.palex.practice.model.OfficeEntity;

import java.util.List;

/**
 * DAO для доступа к Office.
 */
public interface OfficeDao {

    /**
     * Получение коллекции объектов типа офис по параметрам.
     * @param officeEntity офис
     * @return коллекция объектов типа офис.
     */
    List<OfficeEntity> getByParams(OfficeEntity officeEntity);

    /**
     * Получение объекта по идентификатору.
     * @param id идентификатор
     * @return офис.
     */
    OfficeEntity getById(Long id);

    /**
     * Изменить офис.
     * @param officeEntity офис.
     */
    void update(OfficeEntity officeEntity);

    /**
     * Сохраненить офис.
     * @param officeEntity офис.
     */
    void save (OfficeEntity officeEntity);
}

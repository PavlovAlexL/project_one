package com.palex.practice.dao;

import com.palex.practice.model.OfficeEntity;

import java.util.List;
import java.util.Map;

/**
 * DAO для работы с office
 */
public interface OfficeDao {

    /**
     * Получение коллекции по параметрам.
     * @param orgId
     * @return
     */
    List<OfficeEntity> getByParams(String orgId);

    /**
     * Получение объекта по ID
     * @param id идентификатор объекта
     * @return
     */
    OfficeEntity getById (Long id);

    /**
     * Изменить объект office
     * @param params карта параметров
     */
    void update (Map<String, String> params);

    /**
     * Сохранить объект office
     * @param
     */
    void save (OfficeEntity officeEntity);
 }

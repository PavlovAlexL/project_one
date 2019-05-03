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
     * @param params
     * @return
     */
    List<OfficeEntity> getByParams(Map<String, String> params);

    /**
     * Получение объекта по ID
     * @param id идентификатор объекта
     * @return
     */
    OfficeEntity getById (Long id);

    /**
     * Сохранить объект office
     * @param params карта параметров
     */
    void save (Map<String, String> params);

    /**
     * Изменить объект office
     * @param params карта параметров
     */
    void update (Map<String, String> params);
 }

package com.palex.practice.dao;

import com.palex.practice.model.CountryEntity;

import java.util.List;

/**
 * DAO для доступа к справочникам стран.
 */
public interface CountryDao {

    /**
     * Получить список всех стран.
     * @return коллекцию объектов типа страна.
     */
    List<CountryEntity> getAll();

    /**
     * Получить объект типа страна по коду.
     * @param code Код.
     * @return Страна.
     */
    CountryEntity getByCode(String code);
}

package com.palex.practice.dao;

import com.palex.practice.model.CountryEntity;

import java.util.List;

/**
 * DAO для доступа к справочникам стран.
 */
public interface CountryDao {

    /**
     * Получить список.
     *
     * @return коллекцию объектов.
     */
    List<CountryEntity> getAll();

    /**
     * Получить по коду.
     * @param code код.
     * @return объект
     */
    CountryEntity getByCode(String code);
}

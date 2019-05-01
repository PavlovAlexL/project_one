package com.palex.practice.dao;

import com.palex.practice.model.CountryEntity;

import java.util.List;

/**
 * DAO для доступа к справочникам стран.
 */
public interface CountriesDao {

    List<CountryEntity> get();
}

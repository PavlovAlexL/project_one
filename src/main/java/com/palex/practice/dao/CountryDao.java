package com.palex.practice.dao;

import com.palex.practice.model.CountryEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * DAO для доступа к справочникам стран.
 */
public interface CountryDao {

    List<CountryEntity> getAll();
}

package com.palex.practice.dao;

import com.palex.practice.model.OfficeEntity;
import com.palex.practice.model.UserEntity;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * DAO для доступа UserDao
 */

public interface UserDao {

    /**
     * Получение коллекции объектов по параметрам.
     * @param params
     * @return
     */
    List<UserEntity> getByParams(Map<String,String> params);

    /**
     * Получение объекта по ID.
     * @param id
     * @return
     */
    UserEntity getById (Long id);

    /**
     * Изменить объект.
     * @param params строка с параметрами, разделенная запятой.
     */
    void update (Map<String,String> params, OfficeEntity officeEntity);

    /**
     * Сохраненить объект.
     * @param
     */
    void save (UserEntity userEntity);
}


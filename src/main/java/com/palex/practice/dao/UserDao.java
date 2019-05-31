package com.palex.practice.dao;

import com.palex.practice.model.UserEntity;

import java.util.List;

/**
 * DAO для доступа к User
 */
public interface UserDao {

    /**
     * Получение коллекции объектов по параметрам.
     * @return
     */
    List<UserEntity> getByParams(UserEntity userEntity);

    /**
     * Получение объекта по ID.
     * @param id
     * @return
     */
    UserEntity getById (Long id);

    /**
     * Изменить объект.
     * @param
     */
    void update (UserEntity userEntity);

    /**
     * Сохраненить объект.
     * @param
     */
    void save (UserEntity userEntity);
}


package com.palex.practice.dao;

import com.palex.practice.model.UserEntity;

import java.util.List;

/**
 * DAO для доступа к User
 */
public interface UserDao {

    /**
     * Получение коллекции объектов по параметрам.
     * @return коллекция пользователей.
     */
    List<UserEntity> getByParams(UserEntity userEntity);

    /**
     * Получение объекта по ID.
     * @param id идентификатор.
     * @return пользователь.
     */
    UserEntity getById (Long id);

    /**
     * Изменить пользователя.
     */
    void update (UserEntity userEntity);

    /**
     * Сохраненить пользвателя.
     */
    void save (UserEntity userEntity);
}


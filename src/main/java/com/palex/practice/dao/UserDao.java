package com.palex.practice.dao;

import com.palex.practice.model.UserEntity;
import com.palex.practice.view.User.UserListFilterView;

import java.util.List;

/**
 * DAO для доступа UserDao
 */

public interface UserDao {

    /**
     * Получение коллекции объектов по параметрам.
     * @return
     */
    List<UserEntity> getByParams(UserListFilterView userListFilterView);

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


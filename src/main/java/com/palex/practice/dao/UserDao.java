package com.palex.practice.dao;

import com.palex.practice.model.UserEntity;
import java.util.List;

/**
 * DAO для доступа UserDao
 */
public interface UserDao {
    /**
     * Получение коллекции объектов по id.
     * @param id
     * @return
     */
    List<UserEntity> getOfficeId(Long id);

    /**
     * Получение коллекции по параметрам.
     * @param param
     * @return
     */
    List<UserEntity> getByParams(Object ... param);

    /**
     * Получение объекта по ID.
     * @param id
     * @return
     */
    UserEntity getById (Long id);

    /**
     * Сохранить объект office.
     * @param userEntity
     */
    void save (UserEntity userEntity);

    /**
     * Изменить объект office.
     * @param userEntity
     */
    void update (UserEntity userEntity);
}
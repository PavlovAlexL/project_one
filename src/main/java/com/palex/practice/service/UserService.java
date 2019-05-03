package com.palex.practice.service;

import com.palex.practice.model.UserEntity;

public interface UserService {

    /**
     * Отобразить объекта с параметрами.
     */
    void list(Object ... parametr);

    /**
     *  Отобразить объект по Id.
     */
    void getById(Long id);

    /**
     * Изменить объект.
     */
    void update(UserEntity user);

    /**
     * Создать объект.
     */
    void save(UserEntity user);

}

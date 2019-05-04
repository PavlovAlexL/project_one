package com.palex.practice.service;

import com.palex.practice.view.UserView;

import java.util.List;
import java.util.Map;

public interface UserService {

    /**
     * Отобразить объекта с параметрами.
     */
    List<UserView> list(Map<String,String> params);

    /**
     *  Отобразить объект по Id.
     */
    UserView getById(Long id);

    /**
     * Изменить объект.
     */
    void update(Map<String,String> params);

    /**
     * Создать объект.
     */
    void save(Map<String,String> params);

}

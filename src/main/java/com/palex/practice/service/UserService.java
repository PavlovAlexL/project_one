package com.palex.practice.service;

import com.palex.practice.view.User.*;

import java.util.List;

/**
 * Сервис
 */
public interface UserService {

    /**
     * Отобразить объекты с параметрами.
     */
    List<UserListView> list(UserListFilterView userListFilterView);

    /**
     *  Отобразить объект по Id.
     */
    UserView getById(Long id);

    /**
     * Изменить объект.
     */
    void update(UserUpdateFilterView userUpdateFilterView);

    /**
     * Создать объект.
     */
    void save(UserSaveFilterView userSaveFilterView);

}

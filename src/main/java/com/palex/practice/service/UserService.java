package com.palex.practice.service;


import com.palex.practice.view.User.UserListFilterView;
import com.palex.practice.view.User.UserListView;
import com.palex.practice.view.User.UserSaveFilterView;
import com.palex.practice.view.User.UserUpdateFilterView;
import com.palex.practice.view.User.UserView;

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

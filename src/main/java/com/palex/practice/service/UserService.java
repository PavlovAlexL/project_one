package com.palex.practice.service;

import com.palex.practice.view.User.UserListFilterView;
import com.palex.practice.view.User.UserListView;
import com.palex.practice.view.User.UserSaveFilterView;
import com.palex.practice.view.User.UserUpdateFilterView;
import com.palex.practice.view.User.UserView;

import java.util.List;

/**
 * Сервис для работы с объектами пользователь.
 */
public interface UserService {

    /**
     * Отобразить пользователей по параметрам.
     */
    List<UserListView> list(UserListFilterView userListFilterView);

    /**
     *  Отобразить пользователя по идентификатору.
     */
    UserView getById(Long id);

    /**
     * Изменить пользователя.
     */
    void update(UserUpdateFilterView userUpdateFilterView);

    /**
     * Создать пользователя.
     */
    void save(UserSaveFilterView userSaveFilterView);
}

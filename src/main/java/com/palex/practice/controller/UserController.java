package com.palex.practice.controller;

import com.palex.practice.service.UserService;
import com.palex.practice.view.User.UserListFilterView;
import com.palex.practice.view.User.UserListView;
import com.palex.practice.view.User.UserSaveFilterView;
import com.palex.practice.view.User.UserUpdateFilterView;
import com.palex.practice.view.User.UserView;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

/**
 * Контроллер для обработки запросов для User
 */
@RestController
@RequestMapping(value = "/api/user", produces = APPLICATION_JSON_VALUE)
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    /**
     * Возврат коллекции обектов по параметрам.
     * @param userListFilterView Представление с фильтрацией входящих параметров для запроса пользователей по параметрам.
     * @return коллекция запрошенных пользователей.
     */
    @RequestMapping(value = "/list", method = RequestMethod.POST)
    public List<UserListView> userList(@RequestBody @Valid UserListFilterView userListFilterView) {
        return userService.list(userListFilterView);
    }

    /**
     * Возврат объекта по Id.
     * @param id Идентификатор пользователя.
     * @return представление пользователя.
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public UserView userGetById(@PathVariable("id") Long id){
        return userService.getById(id);
    }

    /**
     * Запрос на операцию обновления объекта.
     * @param userUpdateFilterView Представление с фильтрацией входящих параметров для обновления пользователя.
     */
    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public void userUpdate(@RequestBody @Valid UserUpdateFilterView userUpdateFilterView) {
        userService.update(userUpdateFilterView);
    }

    /**
     * Запрос на операцию сохранения обекта.
     * @param userSaveFilterView Представление с фильтрацией входящих параметров для сохранения пользователя.
     */
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public void userSave(@RequestBody @Valid UserSaveFilterView userSaveFilterView) {
        userService.save(userSaveFilterView);
    }
}
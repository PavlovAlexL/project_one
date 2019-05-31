package com.palex.practice.controller;

import com.palex.practice.service.UserService;
import com.palex.practice.view.ResultView;
import com.palex.practice.view.SuccessView;
import com.palex.practice.view.User.UserListFilterView;
import com.palex.practice.view.User.UserSaveFilterView;
import com.palex.practice.view.User.UserUpdateFilterView;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

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
     *
     * @param userListFilterView
     * @return
     */
    @RequestMapping(value = "/list", method = RequestMethod.POST)
    public ResultView userList(@RequestBody @Valid UserListFilterView userListFilterView) {
        return new ResultView(userService.list(userListFilterView));
    }

    /**
     * Возврат объекта по Id.
     *
     * @param id
     * @return
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResultView userGetById(@PathVariable("id") Long id){
        return new ResultView(userService.getById(id));
    }

    /**
     * Запрос на операцию обновления объекта.
     *
     * @param userUpdateFilterView
     * @return статус операции.
     */
    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public SuccessView userUpdate(@RequestBody @Valid UserUpdateFilterView userUpdateFilterView) {
        userService.update(userUpdateFilterView);
        return new SuccessView();
    }

    /**
     * Запрос на операцию сохранения обекта.
     *
     * @param userSaveFilterView
     * @return статус операции.
     */
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public SuccessView userSave(@RequestBody @Valid UserSaveFilterView userSaveFilterView) {
        userService.save(userSaveFilterView);
        return new SuccessView();
    }
}
package com.palex.practice.controller;

import com.palex.practice.service.UserService;
import com.palex.practice.view.UserView;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;
import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

@RestController
@RequestMapping(value = "/api/user", produces = APPLICATION_JSON_VALUE)
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    /**
     * Запрос списка по параметрам
     * @param params коллекция параметров
     * @return
     */
    @RequestMapping(
            value = "/list",
            method = {POST})
    @ResponseBody
    public List<UserView> userList(
            @RequestParam Map<String,String> params
    ) {
        return userService.list(params);
    }


    /**
     * Запрос по Id.
     * @param userId
     * @return
     */
    @RequestMapping(
            value = "/{id}",
            method = {GET})
    @ResponseBody
    public UserView userGetById(
            @PathVariable("id") Long userId
    ){
        return userService.getById(userId);
    }

    /**
     *Запрос на обновление
     * @param params Карта с парамерами
     * @return
     */
    @RequestMapping(
            value = "/update",
            method = {POST})
    @ResponseBody
    public String userUpdate (
            @RequestParam Map<String,String> params
    ) {
        userService.update(params);
        return "userUpdate";
    }

    /**
     * Запрос на сохранение
     * @param params карта с параметрами
     * @return
     */
    @RequestMapping(
            value = "/save",
            method = {POST})
    @ResponseBody
    public String userSave(
            @RequestParam Map<String,String> params
    ){
        userService.save(params);
        return "UserSave";
    }
}
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
     *  “userId”:””, //обязательный параметр
     *   “firstName”:””,
     *   “lastName”:””,
     *   “middleName”:””,
     *   “position”,””,
     *   “docCode”:””,
     *   “citizenshipCode”:””
     * @param params коллекция параметров
     * @return
     * {
     *   “id”:””,
     *   “firstName”:””,
     *   “secondName”:””,
     *   “middleName”:””,
     *   “position”:””
     * },...
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
     * {
     *   “id”:””,
     *   “firstName”:””,
     *   “secondName”:””,
     *   “middleName”:””,
     *   “position”:””
     *   “phone”,””,
     *   “docName”:””,
     *   “docNumber”:””,
     *   “docDate”:””,
     *   “citizenshipName”:””,
     *   “citizenshipCode”:””,
     *   “isIdentified”:”true”
     * }
     */
    @RequestMapping(
            value = "/{id:\\\\d+}",
            method = {GET})
    @ResponseBody
    public UserView userGetById(
            @PathVariable("id") Long userId
    ){
        return userService.getById(userId);
    }

    /**
     *Запрос на обновление
     * “id”:””, //обязательный парамет
     * “userId”:””,
     * “firstName”:””, //обязательный параметр
     * “secondName”:””,
     * “middleName”:””,
     * “position”:”” //обязательный параметр
     * “phone”,””,
     * “docName”:””,
     * “docNumber”:””,
     * “docDate”:””,
     * “citizenshipCode”:””,
     * “isIdentified”:”true”
     * @param params Карта с парамерами
     * @return
     * {
     *     “result”:”success”
     * }
     */
    @RequestMapping(
            value = "/update",
            method = {POST})
    @ResponseBody
    public String userUpdate (
            @RequestParam Map<String,String> params
    ) {
        return userService.update(params);
    }

    /**
     * Запрос на сохранение
     * “id”:””, //обязательный параметр
     * “officeId”:””,
     * “firstName”:””, //обязательный параметр
     * “secondName”:””,
     * “middleName”:””,
     * “position”:”” //обязательный параметр
     * “phone”,””,
     * “docName”:””,
     * “docNumber”:””,
     * “docDate”:””,
     * “citizenshipCode”:””,
     * “isIdentified”:”true” //пример
     * @param params карта с параметрами
     * @return
     * {
     *     “result”:”success”
     * }
     */
    @RequestMapping(
            value = "/save",
            method = {POST})
    @ResponseBody
    public String userSave(
            @RequestParam Map<String,String> params
    ){
        return userService.save(params);
    }
}
package com.palex.practice.controller;

import com.palex.practice.view.OfficeView;
import com.palex.practice.service.OfficeService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;
import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

/**
 * Контроллер для office
 */
@RestController
@RequestMapping(value = "/api/office", produces = APPLICATION_JSON_VALUE)
public class OfficeController {

    private final OfficeService officeService;

    public OfficeController(OfficeService officeService) {
        this.officeService = officeService;
    }

    /**
     * Запрос списка по параметрам
     * @param params коллекция параметров
     * {
     *   “orgId”:””, //обязательный параметр
     *   “name”:””,
     *   “phone”:””,
     *   “isActive”
     * }
     * @return
     * {
     *     “id”:””,
     *     “name”:””,
     *     “isActive”:”true”
     *   },...
     */
    @RequestMapping(
            value = "/list",
            method = {POST})
    @ResponseBody
     public List<OfficeView> officeList (
            @RequestParam Map<String,String> params
    ) {
        return officeService.list(params);
    }



    /**
     * Запрос по Id.
     * @param officeId идентификатор объекта
     * @return
     * {
     *   “id”:””,
     *   “name”:””,
     *   “address”:””,
     *   “phone”,””,
     *   “isActive”:”true”
     * }
     */
    @RequestMapping(
            value = "/{id:\\\\d+}",
            method = {GET})
    @ResponseBody
    public OfficeView officeGetById(
            @PathVariable("id") Long officeId
    ){
        return officeService.getById(officeId);
    }

    /**
     * Запрос на обновление.
     * @param params коллекция параметров.
     * {
     *   “id”:””, //обязательный параметр
     *   “name”:””, //обязательный параметр
     *   “address”:””, //обязательный параметр
     *   “phone”,””,
     *   “isActive”:”true” //пример
     * }
     * @return
     * {
     *     “result”:”success”
     * }
     */
    @RequestMapping(
            value = "/update",
            method = {POST})
    @ResponseBody
    public String officeUpdate (
            @RequestParam Map<String,String> params
    ) {
        return officeService.update(params);
    }

    /**
     * Запрос на сохранение.
     * @param params коллекция параметров.
     * {
     *   “orgId”:””, //обязательный параметр
     *   “name”:””,
     *   “address”:””,
     *   “phone”,””,
     *   “isActive”:”true”
     * }
     * @return
     * {
     *     “result”:”success”
     * }
     */
    @RequestMapping(
            value = "/save",
            method = {POST})
    @ResponseBody
    public String officeSave(
            @RequestParam Map<String,String> params
    ){

        return officeService.save(params);
    }
}

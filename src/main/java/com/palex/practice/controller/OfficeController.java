package com.palex.practice.controller;

import com.palex.practice.model.OfficeEntity;
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

    /*
     * Запрос списка по параметрам.
     * @param orgId обязательный параметр.
     * @param officeName
     * @param officePhone
     * @param officeStatus
     * @return
     */
    /*
    @RequestMapping(
            value = "/list",
            params = {"orgId", "name", "phone", "isActive"},
            method = {POST})
    @ResponseBody
    public List<OfficeView> officeList (
            @RequestParam("orgId") Long orgId,
            @RequestParam("name") String officeName,
            @RequestParam("phone") String officePhone,
            @RequestParam("isActive") Boolean officeStatus
    ) {
        String params = orgId.toString();
        if(officeName != null) {params += " ," + officeName;}
        if(officePhone != null) {params += " ," + officePhone;}
        if(officeStatus != null) {params += " ," + officeStatus;}
        return officeService.list(params);
    }
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
     * @param officeId
     * @return
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



    /*
     * Запрос на обновление.
     * @param officeId - обязательный параметр.
     * @param officeName - обязательный параметр.
     * @param officeAddress - обязательный параметр.
     * @param officePhone
     * @param isAvtive
     * @return "result":"(success or none)"
     */
    /*
    @RequestMapping(
            value = "/update",
            params = {"id", "name", "address", "phone", "isActive"},
            method = {POST})
    @ResponseBody
    public String officeUpdate(
            @PathVariable("id") Long officeId,
            @PathVariable("name") String officeName,
            @PathVariable("address") String officeAddress,
            @PathVariable("phone") String officePhone,
            @PathVariable("isActive") String isAvtive
    ){
        return officeService.update();
    }
    */

    /**
     *
     * @param params    Карта с парамерами
     * officeId - обязательный параметр.
     * officeName - обязательный параметр.
     * officeAddress - обязательный параметр.
     * officePhone
     * isAvtive
     * @return
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
     *
     * @param params
     * orgId обязательный параметр
     * @return
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

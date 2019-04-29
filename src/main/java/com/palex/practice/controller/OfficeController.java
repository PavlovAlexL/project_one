package com.palex.practice.controller;

import com.palex.practice.model.OfficeEntity;
import com.palex.practice.model.UserEntity;
import com.palex.practice.service.OfficeService;
import org.springframework.web.bind.annotation.*;

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
     * Запрос офиса с параметрами.
     * @param organisationId обязательный параметр.
     * @param officeName
     * @param officePhone
     * @param officeStatus
     * @return
     */
    @RequestMapping(
            value = "/office/list",
            params = {"orgId", "name", "phone", "isActive"},
            method = {POST})
    @ResponseBody
    public OfficeEntity officelist (
            @RequestParam("orgId") Integer organisationId,
            @RequestParam("name") String officeName,
            @RequestParam("phone") String officePhone,
            @RequestParam("isActive") Boolean officeStatus
    ) {
        String params = organisationId.toString();
        if(officeName != null) {params += " ," + officeName;}
        if(officePhone != null) {params += " ," + officePhone;}
        if(officeStatus != null) {params += " ," + officeStatus;}
        return officeService.list(params);
    }

    @RequestMapping(
            value = "/office/{id}",
            method = {GET})
    @ResponseBody
    public OfficeEntity officeById(
            @PathVariable("id") Integer officeId
    ){
        return officeService.getById(officeId);
    }

    @RequestMapping(
            value = "/office/update",
            params = {"id", "name", "address", "phone", "isActive"},
            method = {GET})
    @ResponseBody
    public String officeUpdate(
            @PathVariable("id") Integer officeId,
            @PathVariable("name") String officeName,
            @PathVariable("address") String officeAddress,
            @PathVariable("phone") String officePhone,
            @PathVariable("isActive") String isAvtive
    ){
        return null;
    }



    /**
     *
     * @param
     *
    {
    “orgId”:””, //обязательный параметр
    “name”:””,
    “address”:””,
    “phone”,””,
    “isActive”:”true”
    }

    Out:
    {
    “result”:”success”
     */
    @RequestMapping(
            value = "/office/save",
            params = {"id", "name", "address", "phone", "isActive"},
            method = {GET})
    @ResponseBody
    public String officeSave(
            @PathVariable("id") String officeId,
            @PathVariable("name") String officeName,
            @PathVariable("address") String officeAddress,
            @PathVariable("phone") String officePhone,
            @PathVariable("isActive") String isAvtive
    ){
        return null;
    }
}

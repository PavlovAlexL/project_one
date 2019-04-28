package com.palex.practice.controller;

import org.springframework.web.bind.annotation.*;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;
import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

@RestController
@RequestMapping(value = "/api/office", produces = APPLICATION_JSON_VALUE)
public class OfficeController {

    /**
     * In (фильтр):
     * {
     *   “orgId”:””, //обязательный параметр
     *   “name”:””,
     *   “phone”:””,
     *   “isActive”
     * }
     * @return
     *     “id”:””,
     *     “name”:””,
     *     “isActive”:”true”
     */

    /**
     *
     * @param organisationId
     * @param officeName
     * @param officePhone
     * @param officeStatius
     * @return
     */
    @RequestMapping(
            value = "/office/list",
            params = {"orgId", "name", "phone", "isActive"},
            method = {POST})
    @ResponseBody
    public String officelist (
            @RequestParam("orgId") String organisationId,
            @RequestParam("name") String officeName,
            @RequestParam("phone") String officePhone,
            @RequestParam("isActive") String officeStatius
    ) {

        return null;
    }





    /**
     *
     *
     * @return
     * Out:
     * {
     *   “id”:””,
     *   “name”:””,
     *   “address”:””,
     *   “phone”,””,
     *   “isActive”:”true”
     * }
     */
    @RequestMapping(value = "/office/{id}", method = {GET})
    @ResponseBody
    public String officeById(
            @PathVariable("id") String officeId
    ){
        return null;
    }





    /**
     In:
     {
     “id”:””, //обязательный параметр
     “name”:””, //обязательный параметр
     “address”:””, //обязательный параметр
     “phone”,””,
     “isActive”:”true” //пример
     }
     */
    @RequestMapping(
            value = "/office/update",
            params = {"id", "name", "address", "phone", "isActive"},
            method = {GET})
    @ResponseBody
    public String officeUpdate(
            @PathVariable("id") String officeId,
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

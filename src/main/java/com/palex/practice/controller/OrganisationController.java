package com.palex.practice.controller;

import com.palex.practice.view.OrganisationView;
import com.palex.practice.service.OrganisationService;
import org.springframework.web.bind.annotation.*;
import com.palex.practice.model.OrganisationEntity;


import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;
import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

@RestController
@RequestMapping(value = "/api/organisation", produces = APPLICATION_JSON_VALUE)
public class OrganisationController {

    private final OrganisationService organisationService;

    public OrganisationController(OrganisationService organisationService) {
        this.organisationService = organisationService;
    }

    /**
     * Запрос списка по параметрам.
     * @param organisationName обязательный параметр.
     * @param organisationInn
     * @param organisationStatus
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
            params = {"name", "inn", "isActive"},
            method = {POST})
    @ResponseBody
    public List<OrganisationView> organisationList (
            @RequestParam("name") String organisationName,
            @RequestParam("inn") String organisationInn,
            @RequestParam("isActive") Boolean organisationStatus
    ) {
        String params = organisationName;
        if(organisationInn != null) {params += " ," + organisationInn;}
        if(organisationStatus != null) {params += " ," + organisationStatus;}
        return organisationService.list(params);
    }

    /**
     * Запрос по Id.
     * @param organisationId
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
    public OrganisationView organisationGetById(
            @PathVariable("id") Long organisationId
    ){
        return organisationService.getById(organisationId);
    }

    /**
     * Запрос на обновление
     * @param organisationId обязательный параметр
     * @param organisationName обязательный параметр
     * @param organisationFullName обязательный параметр
     * @param organisationInn обязательный параметр
     * @param organisationKpp обязательный параметр
     * @param organisationAddress обязательный параметр
     * @param organisationPhone
     * @param organisationStatus
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
            params = {"id", "name", "fullName", "inn", "kpp", "address", "phone", "isActive"},
            method = {POST})
    @ResponseBody
    public void organisatonUpdate(
            @PathVariable("id") Long organisationId,
            @PathVariable("name") String organisationName,
            @PathVariable("fullName") String organisationFullName,
            @PathVariable("inn") String organisationInn,
            @PathVariable("kpp") String organisationKpp,
            @PathVariable("address") String organisationAddress,
            @PathVariable("phone") String organisationPhone,
            @PathVariable("isActive") Boolean organisationStatus
    ){
        String params = organisationId + " ," +  organisationName + " ," + organisationFullName + " ," + organisationInn + " ," + organisationKpp + " ," + organisationAddress;
        if(organisationPhone != null) params += " ," + organisationPhone;
        if(organisationStatus != null) params += " ," + organisationStatus;
        String result = organisationService.update(params);
    }

    /**
     * Запрос на сохранение
     *
     * @param organisationName обязательный параметр
     * @param organisationFullName обязательный параметр
     * @param organisationInn обязательный параметр
     * @param organisationKpp обязательный параметр
     * @param organisationAddress обязательный параметр
     * @param organisationPhone
     * @param organisationStatus
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
            params = {"name", "fullName", "inn", "kpp", "address", "phone", "isActive"},
            method = {POST})
    @ResponseBody
    public String organisationSave(
            @PathVariable("name") String organisationName,
            @PathVariable("fullName") String organisationFullName,
            @PathVariable("inn") String organisationInn,
            @PathVariable("kpp") String organisationKpp,
            @PathVariable("address") String organisationAddress,
            @PathVariable("phone") String organisationPhone,
            @PathVariable("isActive") Boolean organisationStatus
    ){
        organisationService.save(new OrganisationEntity(organisationName, organisationFullName, organisationInn, organisationKpp, organisationAddress, organisationPhone, organisationStatus));
    }

}

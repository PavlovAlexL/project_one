package com.palex.practice.controller;

import com.palex.practice.view.OrganisationView;
import com.palex.practice.service.OrganisationService;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.Map;

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
     * @param params
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
    public List<OrganisationView> organisationList (
            @RequestParam Map<String, String> params
    ) {
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
            value = "/{id}",
            method = {GET})
    @ResponseBody
    public OrganisationView organisationGetById(
            @PathVariable("id") @Valid @NotNull Long organisationId
    ){
        return organisationService.getById(organisationId);
    }

    /**
     * Запрос на обновление
     * @param params
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
    public String organisatonUpdate(
            @RequestParam Map<String, String> params
    ){
        organisationService.update(params);
        return "organisatonUpdate";
    }

    /**
     * Запрос на сохранение
     * @param params collection of parameters
     * {
     *   “name”:””, //обязательный параметр
     *   “fullName”:””, //обязательный параметр
     *   “inn”:””, //обязательный параметр
     *   “kpp”:””, //обязательный параметр
     *   “address”:””, //обязательный параметр
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
    public String organisationSave(
            @RequestParam Map<String, String> params
    ){
        organisationService.save(params);
        return "organisationSave";
    }

}

package com.palex.practice.controller;

import com.palex.practice.view.OrganisationView;
import com.palex.practice.service.OrganisationService;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
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
            @RequestParam("name") @Valid @NotNull String organisationName,
            @RequestParam("inn") String organisationInn,
            @RequestParam("isActive") Boolean organisationStatus
    ) {
        return organisationService.list(
                organisationName,
                organisationInn,
                organisationStatus);
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
            @PathVariable("id") @Valid @NotNull Long organisationId
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
    public String organisatonUpdate(
            @RequestParam("id") @Valid @NotNull Long organisationId,
            @RequestParam("name") @Valid @NotNull String organisationName,
            @RequestParam("fullName") @Valid @NotNull String organisationFullName,
            @RequestParam("inn") @Valid @NotNull @Size(max = 10) String organisationInn,
            @RequestParam("kpp") @Valid @NotNull @Size(max = 9) String organisationKpp,
            @RequestParam("address") @Valid @NotNull String organisationAddress,
            @RequestParam("phone") String organisationPhone,
            @RequestParam("isActive") Boolean organisationStatus
    ){
        return organisationService.update(
                organisationId,
                organisationName,
                organisationFullName,
                organisationInn,
                organisationKpp,
                organisationAddress,
                organisationPhone,
                organisationStatus);
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
            params = {"name", "fullName", "inn", "kpp", "address", "phone", "isActive"},
            method = {POST})
    @ResponseBody
    public String organisationSave(
            @RequestParam("name") @Valid @NotNull String organisationName,
            @RequestParam("fullName") @Valid @NotNull String organisationFullName,
            @RequestParam("inn") @Valid @NotNull @Size(max = 10) String organisationInn,
            @RequestParam("kpp") @Valid @NotNull @Size(max = 9) String organisationKpp,
            @RequestParam("address") @Valid @NotNull String organisationAddress,
            @RequestParam("phone") String organisationPhone,
            @RequestParam("isActive") Boolean organisationStatus
    ){
        return organisationService.save(organisationName,
                organisationFullName,
                organisationInn,
                organisationKpp,
                organisationAddress,
                organisationPhone,
                organisationStatus);
    }

}

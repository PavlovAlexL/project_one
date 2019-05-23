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
     * @return
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
     * @return
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
     * @return
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

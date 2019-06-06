package com.palex.practice.controller;

import com.palex.practice.service.OrganisationService;
import com.palex.practice.view.Organisation.OrganisationListFilterView;
import com.palex.practice.view.Organisation.OrganisationListView;
import com.palex.practice.view.Organisation.OrganisationSaveFilterView;
import com.palex.practice.view.Organisation.OrganisationUpdateFilterView;
import com.palex.practice.view.Organisation.OrganisationView;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

/**
 * Контроллер для обработки запросов для Organisation.
 */
@RestController
@RequestMapping(value = "/api/organisation", produces = APPLICATION_JSON_VALUE)
public class OrganisationController {

    private final OrganisationService organisationService;

    public OrganisationController(OrganisationService organisationService) {
        this.organisationService = organisationService;
    }

    /**
     * Возврат коллекции обектов по параметрам.
     * @param organisationListFilterView Представление с фильтрацией входящих параметров для организации.
     * @return коллекция запрошенных представлений организаций по параметрам.
     */
    @RequestMapping(value = "/list", method = RequestMethod.POST)
    public List<OrganisationListView> organisationList(@RequestBody @Valid OrganisationListFilterView organisationListFilterView) {
        return organisationService.list(organisationListFilterView);
    }

    /**
     * Возврат объекта по Id.
     * @param id идентификатор.
     * @return Представление запрошенной организации.
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @ResponseBody
    public OrganisationView organisationGetById(@PathVariable("id") @Valid @NotNull @Min(1) Long id) {
        return organisationService.getById(id);
    }

    /**
     * Запрос на операцию обновления объекта.
     * @param organisationUpdateFilterView Представление с фильтрацией входящих параметров для сохранения организации.
     */
    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public void organisatonUpdate(@RequestBody @Valid OrganisationUpdateFilterView organisationUpdateFilterView) {
        organisationService.update(organisationUpdateFilterView);
    }

    /**
     * Запрос на операцию сохранения обекта.
     * @param organisationSaveFilterView Представление с фильтрацией входящих параметров для обновления организации.
     */
    @RequestMapping(value = "/save", method = RequestMethod.POST, produces = {MediaType.APPLICATION_JSON_VALUE})
    public void organisationSave(@RequestBody @Valid OrganisationSaveFilterView organisationSaveFilterView) {
        organisationService.save(organisationSaveFilterView);
    }
}

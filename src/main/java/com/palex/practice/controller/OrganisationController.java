package com.palex.practice.controller;

import com.palex.practice.service.OrganisationService;
import com.palex.practice.view.Organisation.*;
import com.palex.practice.view.ResultView;
import com.palex.practice.view.SuccessView;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping(value = "/api/organisation", produces = APPLICATION_JSON_VALUE)
public class OrganisationController {

    private final OrganisationService organisationService;

    public OrganisationController(OrganisationService organisationService) {
        this.organisationService = organisationService;
    }

    @RequestMapping(
            value = "/list",
            method = RequestMethod.POST
            )
    @ResponseBody
    public List<OrganisationListView> organisationList(
            @RequestBody @Valid OrganisationListFilterView organisationListFilterView) {
        return organisationService.list(organisationListFilterView);
    }


    @RequestMapping(
            value = "/{id}",
            method = RequestMethod.GET
            )
    public ResultView organisationGetById(
            @PathVariable("id") @Valid @NotNull Long id
    ) {
        return new ResultView(organisationService.getById(id));
    }


    @RequestMapping(
            value = "/update",
            method = RequestMethod.POST
    )
    public SuccessView organisatonUpdate(
            @RequestBody @Valid OrganisationUpdateFilterView organisationUpdateFilterView
    ) {
        organisationService.update(organisationUpdateFilterView);
        return new SuccessView();
    }


    @RequestMapping(
            value = "/save",
            method = RequestMethod.POST
    )
    public SuccessView organisationSave(
            @RequestBody @Valid OrganisationSaveFilterView organisationSaveFilterView
    ) {
        organisationService.save(organisationSaveFilterView);
        return new SuccessView();
    }

}

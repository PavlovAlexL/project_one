package com.palex.practice.controller;

import com.palex.practice.service.OfficeService;
import com.palex.practice.view.Office.OfficeListFilterView;
import com.palex.practice.view.Office.OfficeSaveFilterView;
import com.palex.practice.view.Office.OfficeUpdateFilterView;
import com.palex.practice.view.ResultView;
import com.palex.practice.view.SuccessView;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping(value = "/api/office", produces = APPLICATION_JSON_VALUE)
public class OfficeController {

    private final OfficeService officeService;

    public OfficeController(OfficeService officeService) {
        this.officeService = officeService;
    }

    @RequestMapping(
            value = "/list",
            method = RequestMethod.POST
    )
    public ResultView officeList(
            @RequestBody @Valid OfficeListFilterView officeListFilterView) {
        return new ResultView(officeService.list(officeListFilterView));
    }

    @RequestMapping(
            value = "/{id}",
            method = RequestMethod.GET
    )
    public ResultView officeGetById(
            @PathVariable("id") @Valid @NotNull Long id
    ) {
        return new ResultView(officeService.getById(id));
    }

    @RequestMapping(
            value = "/update",
            method = RequestMethod.POST
    )
    public SuccessView officeUpdate(
            @RequestBody @Valid OfficeUpdateFilterView officeUpdateFilterView
    ) {
        officeService.update(officeUpdateFilterView);
        return new SuccessView();
    }

    @RequestMapping(
            value = "/save",
            method = RequestMethod.POST
    )
    public SuccessView officeSave(
            @RequestBody @Valid OfficeSaveFilterView officeSaveFilterView
    ) {
        officeService.save(officeSaveFilterView);
        return new SuccessView();
    }

}

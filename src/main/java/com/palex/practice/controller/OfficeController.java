package com.palex.practice.controller;

import com.palex.practice.service.OfficeService;
import com.palex.practice.view.Office.OfficeListFilterView;
import com.palex.practice.view.Office.OfficeListView;
import com.palex.practice.view.Office.OfficeSaveFilterView;
import com.palex.practice.view.Office.OfficeUpdateFilterView;
import com.palex.practice.view.Office.OfficeView;
import com.palex.practice.view.SuccessView;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

/**
 * Контроллер для обработки запросов для Office
 */
@RestController
@RequestMapping(value = "/api/office", produces = APPLICATION_JSON_VALUE)
public class OfficeController {

    private final OfficeService officeService;

    public OfficeController(OfficeService officeService) {
        this.officeService = officeService;
    }

    /**
     * Возврат коллекции обектов по параметрам.
     *
     * @param officeListFilterView
     * @return
     */
    @RequestMapping(value = "/list", method = RequestMethod.POST)
    public List<OfficeListView> officeList(@RequestBody @Valid OfficeListFilterView officeListFilterView) {
        return officeService.list(officeListFilterView);
    }

    /**
     * Возврат объекта по Id.
     *
     * @param id
     * @return
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public OfficeView officeGetById(@PathVariable("id") @Valid @NotNull Long id) {
        return officeService.getById(id);
    }

    /**
     * Запрос на операцию обновления объекта.
     *
     * @param officeUpdateFilterView
     * @return статус операции.
     */
    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public SuccessView officeUpdate(@RequestBody @Valid OfficeUpdateFilterView officeUpdateFilterView) {
        officeService.update(officeUpdateFilterView);
        return new SuccessView();
    }

    /**
     * Запрос на операцию сохранения обекта.
     *
     * @param officeSaveFilterView
     * @return статус операции.
     */
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public SuccessView officeSave(@RequestBody @Valid OfficeSaveFilterView officeSaveFilterView) {
        officeService.save(officeSaveFilterView);
        return new SuccessView();
    }
}

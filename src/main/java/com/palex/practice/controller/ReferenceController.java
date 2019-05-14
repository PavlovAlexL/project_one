package com.palex.practice.controller;

import com.palex.practice.service.CountryService;
import com.palex.practice.service.DocksTypeService;
import com.palex.practice.view.CountryView;
import com.palex.practice.view.DocksTypeView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;
import static org.springframework.web.bind.annotation.RequestMethod.GET;


/**
 * Контроллер для доступа к справочникам.
 */
@RestController
@RequestMapping(value = "/api", produces = APPLICATION_JSON_VALUE)
public class ReferenceController {

    private final DocksTypeService docksTypeService;
    private final CountryService countryService;

    @Autowired
    public ReferenceController(DocksTypeService docksTypeService, CountryService countryService) {
        this.docksTypeService = docksTypeService;
        this.countryService = countryService;
    }

    /**
     * Вывод справочника типов документов.
     * @return Коллекция типов документов.
     * {
     * data”:{
     *          “name”:“”,
     *          “code”:””
     *       }
     * }
     */
    @RequestMapping(
            value = "/countries",
            method = {GET})
    @ResponseBody
    public List<CountryView> countries() {
        return countryService.countries();
    }

    /**
     * Вывод справочника стран.
     * @return Коллекция стран в формате
     * {
     *     “name”:“”,
     *     “code”:””
     * }
     */
    @RequestMapping(
            value = "/docs",
            method = {GET})
    @ResponseBody
    public List<DocksTypeView> docs(){
        return docksTypeService.docs();
    }

}

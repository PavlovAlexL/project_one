package com.palex.practice.controller;

import com.palex.practice.model.DocumentTypeEntity;
import com.palex.practice.service.CountriesService;
import com.palex.practice.service.DocksTypeService;
import com.palex.practice.view.CoutriesView;
import com.palex.practice.view.DocksTypeView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;
import static org.springframework.web.bind.annotation.RequestMethod.POST;


@RestController
@RequestMapping(value = "/api", produces = APPLICATION_JSON_VALUE)
public class ApiController {

    private final DocksTypeService docksTypeService;
    private final CountriesService countriesService;

    //@Autowired
    public ApiController (DocksTypeService docksTypeService){
        this.docksTypeService = docksTypeService;
    }
    //@Autowired
    public ApiController (CountriesService countriesService){
        this.countriesService = countriesService;
    }

    @RequestMapping(
            value = "/docs",
            method = {POST})    //may be GET???
    @ResponseBody
    public List<CoutriesView> countries() {
        return countriesService.countries();
    }

    @RequestMapping(
            value = "/countries",
            method = {POST})
    @ResponseBody
    public List<DocksTypeView> docs(){
        return docksTypeService.docs();
    }

}

package com.palex.practice.service;

import com.palex.practice.view.CountryView;

import java.util.List;

public interface CountryService {

    /**
     * Плучить список видов гражданств.
     * @return {@CountryEntity}
     */
    List<CountryView> countries();
}

package com.palex.practice.service;

import com.palex.practice.view.CoutriesView;

import java.util.List;

public interface CountriesService {

    /**
     * Плучить список видов гражданств.
     * @return {@CountryEntity}
     */
    List<CoutriesView> countries();
}

package com.palex.practice.service;

import com.palex.practice.view.CountryView;

import java.util.List;

/**
 * Сервис стран.
 */
public interface CountryService {

    /**
     * Плучить список видов гражданств.
     */
    List<CountryView> countries();
}

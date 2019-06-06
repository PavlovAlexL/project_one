package com.palex.practice.view;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * View для отображения справочника стран.
 */
public class CountryView {

    /**
     * Имя.
     */
    @JsonProperty("citizenshipName")
    public String name;

    /**
     * Код.
     */
    @JsonProperty("citizenshipCode")
    public String code;
}

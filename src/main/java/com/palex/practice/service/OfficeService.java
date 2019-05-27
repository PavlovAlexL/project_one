package com.palex.practice.service;

import com.palex.practice.view.Office.*;

import java.util.List;

public interface OfficeService {

    /**
     * Отобразить объекта с параметрами.
     */
    List<OfficeListView> list(OfficeListFilterView officeListFilterView);

    /**
     *  Отобразить объект по Id.
     */
    OfficeView getById(Long id);

    /**
     * Изменить объект.
     */
    void update(OfficeUpdateFilterView officeUpdateFilterView);

    /**
     * Создать объект.
     */
    void save(OfficeSaveFilterView officeSaveFilterView);

}

package com.palex.practice.service;


import com.palex.practice.view.Office.OfficeListFilterView;
import com.palex.practice.view.Office.OfficeListView;
import com.palex.practice.view.Office.OfficeSaveFilterView;
import com.palex.practice.view.Office.OfficeUpdateFilterView;
import com.palex.practice.view.Office.OfficeView;

import java.util.List;

/**
 * Сервис
 */
public interface OfficeService {

    /**
     * Отобразить объекты с параметрами.
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

package com.palex.practice.service;

import com.palex.practice.view.Office.OfficeListFilterView;
import com.palex.practice.view.Office.OfficeListView;
import com.palex.practice.view.Office.OfficeSaveFilterView;
import com.palex.practice.view.Office.OfficeUpdateFilterView;
import com.palex.practice.view.Office.OfficeView;

import java.util.List;

/**
 * Сервис для работы с объектами типа офис.
 */
public interface OfficeService {

    /**
     * Отобразить объекты офис по параметрам.
     */
    List<OfficeListView> list(OfficeListFilterView officeListFilterView);

    /**
     *  Отобразить офис по идентификатору.
     */
    OfficeView getById(Long id);

    /**
     * Изменить офис.
     */
    void update(OfficeUpdateFilterView officeUpdateFilterView);

    /**
     * Создать офис.
     */
    void save(OfficeSaveFilterView officeSaveFilterView);

}

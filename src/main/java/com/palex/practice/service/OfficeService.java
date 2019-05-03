package com.palex.practice.service;


import com.palex.practice.model.OfficeEntity;
import com.palex.practice.view.OfficeView;

import java.util.List;
import java.util.Map;

public interface OfficeService {

    /**
     * Отобразить объекта с параметрами.
     */
    //List<OfficeView> list(String params);
    List<OfficeView> list(Map<String,String> params);

    /**
     *  Отобразить объект по Id.
     */
    OfficeView getById(Long id);

    /**
     * Изменить объект.
     */
    String update(Map<String,String> params);

    /**
     * Создать объект.
     */
    String save(Map<String,String> params);

}

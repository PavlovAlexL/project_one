package com.palex.practice.service;


import com.palex.practice.model.OfficeEntity;

public interface OfficeService {

    /**
     * Отобразить объекта с параметрами.
     */
    OfficeEntity list(String params);

    /**
     *  Отобразить объект по Id.
     */
    OfficeEntity getById(Integer id);

    /**
     * Изменить объект.
     */
    void update(OfficeEntity office);

    /**
     * Создать объект.
     */
    void save(OfficeEntity office);

}

package com.palex.practice.service;

import com.palex.practice.model.OrganisationEntity;
import com.palex.practice.view.OrganisationView;

import java.util.List;

public interface OrganisationService {

    /**
     * Отобразить объекты по параметрам.
     */
    List<OrganisationView> list( String organisationName,
                                 String organisationInn,
                                 Boolean organisationStatus);

    /**
     *  Отобразить объект по Id.
     */
    OrganisationView getById(Long id);

    /**
     * Изменить объект.
     */
    String update(Long organisationId,
                  String organisationName,
                  String organisationFullName,
                  String organisationInn,
                  String organisationKpp,
                  String organisationAddress,
                  String organisationPhone,
                  Boolean organisationStatus);

    /**
     * Создать объект.
     */
    String save(String organisationName,
                String organisationFullName,
                String organisationInn,
                String organisationKpp,
                String organisationAddress,
                String organisationPhone,
                Boolean organisationStatus);

}

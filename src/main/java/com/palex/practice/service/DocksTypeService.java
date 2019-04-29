package com.palex.practice.service;

import com.palex.practice.view.DocksTypeView;

import java.util.List;

public interface DocksTypeService {

    /**
     * Плучить список типов документов
     * @return {@DocksTypeEntity}
     */
    List<DocksTypeView> docs();
}

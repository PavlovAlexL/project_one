package com.palex.practice.service;

import com.palex.practice.view.DocksTypeView;

import java.util.List;

/**
 * Сервис типов документов.
 */
public interface DocksTypeService {

    /**
     * Плучить список типов документов
     */
    List<DocksTypeView> docs();
}

package com.palex.practice.dao;

import com.palex.practice.model.OfficeEntity;
import com.palex.practice.view.Office.OfficeListFilterView;
import com.palex.practice.view.Office.OfficeUpdateFilterView;

import java.util.List;

public interface OfficeDao {

    List<OfficeEntity> getByParams(OfficeListFilterView officeListFilterView);

    OfficeEntity getById (Long id);

    void update(OfficeUpdateFilterView officeUpdateFilterView);

    void save (OfficeEntity officeEntity);
 }

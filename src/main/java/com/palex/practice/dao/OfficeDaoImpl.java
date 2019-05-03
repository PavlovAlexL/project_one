package com.palex.practice.dao;

import com.palex.practice.model.OfficeEntity;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public class OfficeDaoImpl implements OfficeDao{

    @Override
    public List<OfficeEntity> getByParams(Map<String, String> params) {
        return null;
    }

    @Override
    public OfficeEntity getById(Long id) {
        return null;
    }

    @Override
    public void save(Map<String, String> params) {

    }

    @Override
    public void update(Map<String, String> params) {

    }
}

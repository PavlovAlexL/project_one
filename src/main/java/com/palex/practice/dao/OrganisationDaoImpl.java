package com.palex.practice.dao;

import com.palex.practice.model.OrganisationEntity;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class OrganisationDaoImpl implements OrganisationDao {

    @Override
    public List<OrganisationEntity> getByParams(Object... params) {
        return null;
    }

    @Override
    public OrganisationEntity getById(Long id) {
        return null;
    }

    @Override
    public String save(OrganisationEntity organisationEntity) {
        return null;
    }

    @Override
    public String update(String params) {
        return null;
    }
}

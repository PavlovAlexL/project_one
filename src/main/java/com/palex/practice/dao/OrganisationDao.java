package com.palex.practice.dao;

import com.palex.practice.model.OrganisationEntity;
import com.palex.practice.view.Organisation.OrganisationListFilterView;
import com.palex.practice.view.Organisation.OrganisationSaveFilterView;
import com.palex.practice.view.Organisation.OrganisationUpdateFilterView;

import java.util.List;

public interface OrganisationDao {

    List<OrganisationEntity> getByParams(OrganisationListFilterView organisationListFilterView);

    OrganisationEntity getById (Long id);

    void update (OrganisationUpdateFilterView organisationUpdateFilterView);

    void save (OrganisationSaveFilterView organisationSaveFilterView);

}


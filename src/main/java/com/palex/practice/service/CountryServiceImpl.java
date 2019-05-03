package com.palex.practice.service;

import com.palex.practice.dao.CountryDao;
import com.palex.practice.model.CountryEntity;
import com.palex.practice.model.mapper.MapperFacade;
import com.palex.practice.view.CountryView;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CountryServiceImpl implements CountryService {

    private final CountryDao countryDao;
    private final MapperFacade mapperFacade;

    public CountryServiceImpl(CountryDao countryDao, MapperFacade mapperFacade) {
        this.countryDao = countryDao;
        this.mapperFacade = mapperFacade;
    }

    @Override
    public List<CountryView> countries() {
        List<CountryEntity> all = countryDao.getAll();
        return mapperFacade.mapAsList(all, CountryView.class);
    }
}

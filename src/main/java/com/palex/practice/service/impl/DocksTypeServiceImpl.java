package com.palex.practice.service.impl;

import com.palex.practice.dao.DocumentTypeDao;
import com.palex.practice.model.DocumentTypeEntity;
import com.palex.practice.model.mapper.MapperFacade;
import com.palex.practice.service.DocksTypeService;
import com.palex.practice.view.DocksTypeView;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Реализация сервиса
 */
@Service
public class DocksTypeServiceImpl implements DocksTypeService {

    private final DocumentTypeDao documentTypeDao;
    private final MapperFacade mapperFacade;


    public DocksTypeServiceImpl(DocumentTypeDao documentTypeDao, MapperFacade mapperFacade) {
        this.documentTypeDao = documentTypeDao;
        this.mapperFacade = mapperFacade;
    }

    /**
     * Плучить список типов документов
     * @return
     */
    @Override
    public List<DocksTypeView> docs() {
        List<DocumentTypeEntity> all = documentTypeDao.getAll();
        return mapperFacade.mapAsList(all, DocksTypeView.class);
    }
}

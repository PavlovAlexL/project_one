package com.palex.practice.dao;

import com.palex.practice.model.OrganisationEntity;
import com.palex.practice.view.Organisation.OrganisationListFilterView;
import com.palex.practice.view.Organisation.OrganisationSaveFilterView;
import com.palex.practice.view.Organisation.OrganisationUpdateFilterView;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.criteria.*;
import javax.transaction.Transactional;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class OrganisationDaoImpl implements OrganisationDao {

    private final EntityManager em;

    public OrganisationDaoImpl(EntityManager em) {
        this.em = em;
    }

    @Override
    public List<OrganisationEntity> getByParams(OrganisationListFilterView organisationListFilterView) {
        String name = organisationListFilterView.name;
        String inn = organisationListFilterView.inn;
        String isActive = organisationListFilterView.isActive;

        System.out.println(name + inn + isActive);

        CriteriaBuilder cb = em.getCriteriaBuilder();   //QueryBuilder, который представляет собой фабрику для инстанциирования CriteriaQuery.
        CriteriaQuery<OrganisationEntity> query = cb.createQuery(OrganisationEntity.class); //фабрика QueryBuilder создает типизированный экземпляр CriteriaQuery.
        Root<OrganisationEntity> organisationEntityRoot = query.from(OrganisationEntity.class); //для экземпляра CriteriaQuery задаются выражения запроса (query expressions).
        //помощи метода from указывается, что поиск будет осуществляться среди хранимых объектов типа OrganisationEntity.class.
        // Root представляет собой выражение, описывающее область определения некоторого множества сохраняемых объектов.
        // Выражение Root<T> фактически означает, что данный запрос должен выполняться над всеми объектами типа T, тем самым напоминая выражение FROM в запросах SQL и JPQL
            //query.select(organisationEntityRoot);
        Predicate predicate = cb.conjunction();
        //ParameterExpression<String> p = cb.parameter(String.class, "name");
        predicate = cb.and(predicate, cb.equal(organisationEntityRoot.get("name"), name));
        if(inn.length() > 0){
            predicate = cb.and(predicate, cb.equal(organisationEntityRoot.get("inn"), inn));
        }
        if(isActive.length() > 0){
            predicate = cb.and(predicate, cb.equal(organisationEntityRoot.get("isActive"), Boolean.parseBoolean(isActive)));
        }
        query.where(predicate);
        return em.createQuery(query).getResultList();
    }

    @Override
    public OrganisationEntity getById(Long id) {
         return em.find(OrganisationEntity.class, id);
    }

    @Override
    public void update(OrganisationUpdateFilterView organisationUpdateFilterView) {

        OrganisationEntity organisationEntity = em.find(OrganisationEntity.class, organisationUpdateFilterView.id);
        organisationEntity.setName(organisationUpdateFilterView.name);
        organisationEntity.setFullName(organisationUpdateFilterView.fullName);
        organisationEntity.setInn(organisationUpdateFilterView.inn);
        organisationEntity.setKpp(organisationUpdateFilterView.kpp);
        organisationEntity.setAddress(organisationUpdateFilterView.address);
        if(organisationUpdateFilterView.phone.length() > 0){
            organisationEntity.setPhone(organisationUpdateFilterView.phone);
        }
        if(organisationUpdateFilterView.isActive.length() > 0) {
            organisationEntity.setIsActive(Boolean.parseBoolean(organisationUpdateFilterView.isActive));
        }
        em.merge(organisationEntity);

    }

    @Override
    @Transactional
    public void save(OrganisationSaveFilterView organisationSaveFilterView) {
        String name = organisationSaveFilterView.name;
        String fullName = organisationSaveFilterView.fullName;
        String inn = organisationSaveFilterView.inn;
        String kpp = organisationSaveFilterView.kpp;
        String address = organisationSaveFilterView.address;
        String phone = organisationSaveFilterView.phone;
        Boolean isActive = Boolean.parseBoolean(organisationSaveFilterView.isActive);

        OrganisationEntity organisationEntity = new OrganisationEntity(name, fullName, inn, kpp, address, phone, isActive);
        em.persist(organisationEntity);
    }


}

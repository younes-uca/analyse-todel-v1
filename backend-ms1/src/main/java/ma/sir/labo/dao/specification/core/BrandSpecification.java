package  ma.sir.labo.dao.specification.core;

import ma.sir.labo.zynerator.specification.AbstractSpecification;
import ma.sir.labo.dao.criteria.core.BrandCriteria;
import ma.sir.labo.bean.core.Brand;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

public class BrandSpecification extends  AbstractSpecification<BrandCriteria, Brand>  {

    @Override
    public void constructPredicates() {
        addPredicateId("id", criteria);
        addPredicate("code", criteria.getCode(),criteria.getCodeLike());
        addPredicate("libelle", criteria.getLibelle(),criteria.getLibelleLike());
    }

    public BrandSpecification(BrandCriteria criteria) {
        super(criteria);
    }

    public BrandSpecification(BrandCriteria criteria, boolean distinct) {
        super(criteria, distinct);
    }

}

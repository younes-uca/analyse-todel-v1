package  ma.sir.labo.dao.specification.core;

import ma.sir.labo.zynerator.specification.AbstractSpecification;
import ma.sir.labo.dao.criteria.core.ReasonCriteria;
import ma.sir.labo.bean.core.Reason;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

public class ReasonSpecification extends  AbstractSpecification<ReasonCriteria, Reason>  {

    @Override
    public void constructPredicates() {
        addPredicateId("id", criteria);
        addPredicate("code", criteria.getCode(),criteria.getCodeLike());
        addPredicate("libelle", criteria.getLibelle(),criteria.getLibelleLike());
    }

    public ReasonSpecification(ReasonCriteria criteria) {
        super(criteria);
    }

    public ReasonSpecification(ReasonCriteria criteria, boolean distinct) {
        super(criteria, distinct);
    }

}
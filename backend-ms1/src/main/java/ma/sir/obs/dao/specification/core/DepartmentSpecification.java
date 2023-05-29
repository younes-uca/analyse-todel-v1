package  ma.sir.obs.dao.specification.core;

import ma.sir.obs.zynerator.specification.AbstractSpecification;
import ma.sir.obs.dao.criteria.core.DepartmentCriteria;
import ma.sir.obs.bean.core.Department;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

public class DepartmentSpecification extends  AbstractSpecification<DepartmentCriteria, Department>  {

    @Override
    public void constructPredicates() {
        addPredicateId("id", criteria);
        addPredicate("code", criteria.getCode(),criteria.getCodeLike());
        addPredicate("libelle", criteria.getLibelle(),criteria.getLibelleLike());
    }

    public DepartmentSpecification(DepartmentCriteria criteria) {
        super(criteria);
    }

    public DepartmentSpecification(DepartmentCriteria criteria, boolean distinct) {
        super(criteria, distinct);
    }

}
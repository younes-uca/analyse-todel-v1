package  ma.sir.labo.dao.specification.core;

import ma.sir.labo.zynerator.specification.AbstractSpecification;
import ma.sir.labo.dao.criteria.core.DataAnalysisCriteria;
import ma.sir.labo.bean.core.DataAnalysis;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

public class DataAnalysisSpecification extends  AbstractSpecification<DataAnalysisCriteria, DataAnalysis>  {

    @Override
    public void constructPredicates() {
        addPredicateId("id", criteria);
        addPredicate("code", criteria.getCode(),criteria.getCodeLike());
        addPredicate("format", criteria.getFormat(),criteria.getFormatLike());
        addPredicateFk("laboratory","id", criteria.getLaboratory()==null?null:criteria.getLaboratory().getId());
        addPredicateFk("laboratory","id", criteria.getLaboratorys());
        addPredicateFk("laboratory","code", criteria.getLaboratory()==null?null:criteria.getLaboratory().getCode());
    }

    public DataAnalysisSpecification(DataAnalysisCriteria criteria) {
        super(criteria);
    }

    public DataAnalysisSpecification(DataAnalysisCriteria criteria, boolean distinct) {
        super(criteria, distinct);
    }

}

package  ma.sir.obs.dao.criteria.core;


import ma.sir.obs.zynerator.criteria.BaseCriteria;
import java.util.List;

public class DataArchiveCriteria extends  BaseCriteria  {

    private String code;
    private String codeLike;
    private String nom;
    private String nomLike;

    private LaboratoryCriteria laboratory ;
    private List<LaboratoryCriteria> laboratorys ;


    public DataArchiveCriteria(){}

    public String getCode(){
        return this.code;
    }
    public void setCode(String code){
        this.code = code;
    }
    public String getCodeLike(){
        return this.codeLike;
    }
    public void setCodeLike(String codeLike){
        this.codeLike = codeLike;
    }

    public String getNom(){
        return this.nom;
    }
    public void setNom(String nom){
        this.nom = nom;
    }
    public String getNomLike(){
        return this.nomLike;
    }
    public void setNomLike(String nomLike){
        this.nomLike = nomLike;
    }


    public LaboratoryCriteria getLaboratory(){
        return this.laboratory;
    }

    public void setLaboratory(LaboratoryCriteria laboratory){
        this.laboratory = laboratory;
    }
    public List<LaboratoryCriteria> getLaboratorys(){
        return this.laboratorys;
    }

    public void setLaboratorys(List<LaboratoryCriteria> laboratorys){
        this.laboratorys = laboratorys;
    }
}
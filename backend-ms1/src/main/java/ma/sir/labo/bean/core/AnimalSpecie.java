package ma.sir.labo.bean.core;

import java.util.Objects;






import com.fasterxml.jackson.annotation.JsonInclude;
import ma.sir.labo.zynerator.audit.AuditBusinessObject;
import javax.persistence.*;
import java.util.Objects;




@Entity
@Table(name = "animal_specie")
@JsonInclude(JsonInclude.Include.NON_NULL)
@SequenceGenerator(name="animal_specie_seq",sequenceName="animal_specie_seq",allocationSize=1, initialValue = 1)
public class AnimalSpecie   extends AuditBusinessObject     {

    private Long id;

    @Column(length = 500)
    private String code;
    @Column(length = 500)
    private String libelle;



    public AnimalSpecie(){
        super();
    }

    public AnimalSpecie(Long id,String libelle){
        this.id = id;
        this.libelle = libelle ;
    }




    @Id
    @Column(name = "id")
        @GeneratedValue(strategy = GenerationType.SEQUENCE,generator="animal_specie_seq")
    public Long getId(){
        return this.id;
    }
    public void setId(Long id){
        this.id = id;
    }
    public String getCode(){
        return this.code;
    }
    public void setCode(String code){
        this.code = code;
    }
    public String getLibelle(){
        return this.libelle;
    }
    public void setLibelle(String libelle){
        this.libelle = libelle;
    }

    @Transient
    public String getLabel() {
        label = libelle;
        return label;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AnimalSpecie animalSpecie = (AnimalSpecie) o;
        return id != null && id.equals(animalSpecie.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

}


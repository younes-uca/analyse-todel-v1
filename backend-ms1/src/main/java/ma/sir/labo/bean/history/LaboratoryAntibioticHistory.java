package ma.sir.labo.bean.history;

import com.fasterxml.jackson.annotation.JsonInclude;
import ma.sir.labo.zynerator.history.HistBusinessObject;
import javax.persistence.*;


@Entity
@Table(name = "laboratory_antibiotic")
@JsonInclude(JsonInclude.Include.NON_NULL)
@SequenceGenerator(name="laboratory_antibiotic_seq",sequenceName="laboratory_antibiotic_seq",allocationSize=1, initialValue = 1)
public class LaboratoryAntibioticHistory extends HistBusinessObject  {


    public LaboratoryAntibioticHistory() {
    super();
    }

    public LaboratoryAntibioticHistory (Long id) {
    super(id);
    }

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator="laboratory_antibiotic_seq")
    public Long getId() {
    return id;
    }
}


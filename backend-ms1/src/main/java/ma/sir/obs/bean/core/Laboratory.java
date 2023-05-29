package ma.sir.obs.bean.core;

import java.util.Objects;
import java.util.List;






import com.fasterxml.jackson.annotation.JsonInclude;
import ma.sir.obs.zynerator.audit.AuditBusinessObject;
import javax.persistence.*;
import java.util.Objects;




@Entity
@Table(name = "laboratory")
@JsonInclude(JsonInclude.Include.NON_NULL)
@SequenceGenerator(name="laboratory_seq",sequenceName="laboratory_seq",allocationSize=1, initialValue = 1)
public class Laboratory   extends AuditBusinessObject     {

    private Long id;

    @Column(length = 500)
    private String code;
    @Column(length = 500)
    private String nom;
    @Column(columnDefinition = "boolean default false")
    private Boolean bloqued = false;
    @Column(length = 500)
    private String city;

    private Location location ;
    
    private DataAnalysis dataAnalysis ;
    
    private DataArchive dataArchive ;
    
    private Report report ;
    

    private List<LaboratoryAntibiotic> laboratoryAntibiotics ;
    private List<Alert> alerts ;
    private List<Notification> notifications ;

    public Laboratory(){
        super();
    }

    public Laboratory(Long id,String code){
        this.id = id;
        this.code = code ;
    }




    @Id
    @Column(name = "id")
        @GeneratedValue(strategy = GenerationType.SEQUENCE,generator="laboratory_seq")
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
    public String getNom(){
        return this.nom;
    }
    public void setNom(String nom){
        this.nom = nom;
    }
    public Boolean  getBloqued(){
        return this.bloqued;
    }
    public void setBloqued(Boolean bloqued){
        this.bloqued = bloqued;
    }
    public String getCity(){
        return this.city;
    }
    public void setCity(String city){
        this.city = city;
    }
    @OneToMany(mappedBy = "laboratory")
    public List<LaboratoryAntibiotic> getLaboratoryAntibiotics(){
        return this.laboratoryAntibiotics;
    }
    public void setLaboratoryAntibiotics(List<LaboratoryAntibiotic> laboratoryAntibiotics){
        this.laboratoryAntibiotics = laboratoryAntibiotics;
    }
    @ManyToOne(fetch = FetchType.LAZY)
    public Location getLocation(){
        return this.location;
    }
    public void setLocation(Location location){
        this.location = location;
    }
    @OneToMany(mappedBy = "laboratory")
    public List<Alert> getAlerts(){
        return this.alerts;
    }
    public void setAlerts(List<Alert> alerts){
        this.alerts = alerts;
    }
    @OneToMany(mappedBy = "laboratory")
    public List<Notification> getNotifications(){
        return this.notifications;
    }
    public void setNotifications(List<Notification> notifications){
        this.notifications = notifications;
    }
    @ManyToOne(fetch = FetchType.LAZY)
    public DataAnalysis getDataAnalysis(){
        return this.dataAnalysis;
    }
    public void setDataAnalysis(DataAnalysis dataAnalysis){
        this.dataAnalysis = dataAnalysis;
    }
    @ManyToOne(fetch = FetchType.LAZY)
    public DataArchive getDataArchive(){
        return this.dataArchive;
    }
    public void setDataArchive(DataArchive dataArchive){
        this.dataArchive = dataArchive;
    }
    @ManyToOne(fetch = FetchType.LAZY)
    public Report getReport(){
        return this.report;
    }
    public void setReport(Report report){
        this.report = report;
    }

    @Transient
    public String getLabel() {
        label = code;
        return label;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Laboratory laboratory = (Laboratory) o;
        return id != null && id.equals(laboratory.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

}

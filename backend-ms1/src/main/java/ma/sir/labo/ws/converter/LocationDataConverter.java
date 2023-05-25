package  ma.sir.labo.ws.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


import ma.sir.labo.zynerator.util.StringUtil;
import ma.sir.labo.zynerator.converter.AbstractConverter;
import ma.sir.labo.zynerator.util.DateUtil;
import ma.sir.labo.bean.history.LocationDataHistory;
import ma.sir.labo.bean.core.LocationData;
import ma.sir.labo.ws.dto.LocationDataDto;

@Component
public class LocationDataConverter extends AbstractConverter<LocationData, LocationDataDto, LocationDataHistory> {

    @Autowired
    private DataImportExportConverter dataImportExportConverter ;
    @Autowired
    private LocationTypeConverter locationTypeConverter ;
    @Autowired
    private InstitutionConverter institutionConverter ;
    @Autowired
    private DepartmentConverter departmentConverter ;
    private boolean institution;
    private boolean department;
    private boolean locationType;
    private boolean dataImportExport;

    public  LocationDataConverter(){
        super(LocationData.class, LocationDataDto.class, LocationDataHistory.class);
    }

    @Override
    public LocationData toItem(LocationDataDto dto) {
        if (dto == null) {
            return null;
        } else {
        LocationData item = new LocationData();
            if(StringUtil.isNotEmpty(dto.getId()))
                item.setId(dto.getId());
            if(StringUtil.isNotEmpty(dto.getCode()))
                item.setCode(dto.getCode());
            if(StringUtil.isNotEmpty(dto.getDateOfAdmission()))
                item.setDateOfAdmission(DateUtil.stringEnToDate(dto.getDateOfAdmission()));
            if(StringUtil.isNotEmpty(dto.getLocation()))
                item.setLocation(dto.getLocation());
            if(this.institution && dto.getInstitution()!=null)
                item.setInstitution(institutionConverter.toItem(dto.getInstitution())) ;

            if(this.department && dto.getDepartment()!=null)
                item.setDepartment(departmentConverter.toItem(dto.getDepartment())) ;

            if(this.locationType && dto.getLocationType()!=null)
                item.setLocationType(locationTypeConverter.toItem(dto.getLocationType())) ;

            if(this.dataImportExport && dto.getDataImportExport()!=null)
                item.setDataImportExport(dataImportExportConverter.toItem(dto.getDataImportExport())) ;



        return item;
        }
    }

    @Override
    public LocationDataDto toDto(LocationData item) {
        if (item == null) {
            return null;
        } else {
            LocationDataDto dto = new LocationDataDto();
            if(StringUtil.isNotEmpty(item.getId()))
                dto.setId(item.getId());
            if(StringUtil.isNotEmpty(item.getCode()))
                dto.setCode(item.getCode());
            if(item.getDateOfAdmission()!=null)
                dto.setDateOfAdmission(DateUtil.dateTimeToString(item.getDateOfAdmission()));
            if(StringUtil.isNotEmpty(item.getLocation()))
                dto.setLocation(item.getLocation());
        if(this.institution && item.getInstitution()!=null) {
            dto.setInstitution(institutionConverter.toDto(item.getInstitution())) ;
        }
        if(this.department && item.getDepartment()!=null) {
            dto.setDepartment(departmentConverter.toDto(item.getDepartment())) ;
        }
        if(this.locationType && item.getLocationType()!=null) {
            dto.setLocationType(locationTypeConverter.toDto(item.getLocationType())) ;
        }
        if(this.dataImportExport && item.getDataImportExport()!=null) {
            dataImportExportConverter.setLocationData(false);
            dto.setDataImportExport(dataImportExportConverter.toDto(item.getDataImportExport())) ;
            dataImportExportConverter.setLocationData(true);
        }


        return dto;
        }
    }


    public void initObject(boolean value) {
        this.institution = value;
        this.department = value;
        this.locationType = value;
        this.dataImportExport = value;
    }


    public DataImportExportConverter getDataImportExportConverter(){
        return this.dataImportExportConverter;
    }
    public void setDataImportExportConverter(DataImportExportConverter dataImportExportConverter ){
        this.dataImportExportConverter = dataImportExportConverter;
    }
    public LocationTypeConverter getLocationTypeConverter(){
        return this.locationTypeConverter;
    }
    public void setLocationTypeConverter(LocationTypeConverter locationTypeConverter ){
        this.locationTypeConverter = locationTypeConverter;
    }
    public InstitutionConverter getInstitutionConverter(){
        return this.institutionConverter;
    }
    public void setInstitutionConverter(InstitutionConverter institutionConverter ){
        this.institutionConverter = institutionConverter;
    }
    public DepartmentConverter getDepartmentConverter(){
        return this.departmentConverter;
    }
    public void setDepartmentConverter(DepartmentConverter departmentConverter ){
        this.departmentConverter = departmentConverter;
    }
    public boolean  isInstitution(){
        return this.institution;
    }
    public void  setInstitution(boolean institution){
        this.institution = institution;
    }
    public boolean  isDepartment(){
        return this.department;
    }
    public void  setDepartment(boolean department){
        this.department = department;
    }
    public boolean  isLocationType(){
        return this.locationType;
    }
    public void  setLocationType(boolean locationType){
        this.locationType = locationType;
    }
    public boolean  isDataImportExport(){
        return this.dataImportExport;
    }
    public void  setDataImportExport(boolean dataImportExport){
        this.dataImportExport = dataImportExport;
    }
}
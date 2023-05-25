package  ma.sir.labo.ws.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


import ma.sir.labo.zynerator.util.StringUtil;
import ma.sir.labo.zynerator.converter.AbstractConverter;
import ma.sir.labo.zynerator.util.DateUtil;
import ma.sir.labo.bean.history.DepartmentHistory;
import ma.sir.labo.bean.core.Department;
import ma.sir.labo.ws.dto.DepartmentDto;

@Component
public class DepartmentConverter extends AbstractConverter<Department, DepartmentDto, DepartmentHistory> {


    public  DepartmentConverter(){
        super(Department.class, DepartmentDto.class, DepartmentHistory.class);
    }

    @Override
    public Department toItem(DepartmentDto dto) {
        if (dto == null) {
            return null;
        } else {
        Department item = new Department();
            if(StringUtil.isNotEmpty(dto.getId()))
                item.setId(dto.getId());
            if(StringUtil.isNotEmpty(dto.getCode()))
                item.setCode(dto.getCode());
            if(StringUtil.isNotEmpty(dto.getLibelle()))
                item.setLibelle(dto.getLibelle());


        return item;
        }
    }

    @Override
    public DepartmentDto toDto(Department item) {
        if (item == null) {
            return null;
        } else {
            DepartmentDto dto = new DepartmentDto();
            if(StringUtil.isNotEmpty(item.getId()))
                dto.setId(item.getId());
            if(StringUtil.isNotEmpty(item.getCode()))
                dto.setCode(item.getCode());
            if(StringUtil.isNotEmpty(item.getLibelle()))
                dto.setLibelle(item.getLibelle());


        return dto;
        }
    }


    public void initObject(boolean value) {
    }


}

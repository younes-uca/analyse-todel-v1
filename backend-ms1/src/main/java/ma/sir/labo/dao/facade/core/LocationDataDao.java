package ma.sir.labo.dao.facade.core;

import org.springframework.data.jpa.repository.Query;
import ma.sir.labo.zynerator.repository.AbstractRepository;
import ma.sir.labo.bean.core.LocationData;
import org.springframework.stereotype.Repository;
import ma.sir.labo.bean.core.LocationData;
import java.util.List;


@Repository
public interface LocationDataDao extends AbstractRepository<LocationData,Long>  {
    LocationData findByCode(String code);
    int deleteByCode(String code);

    List<LocationData> findByInstitutionId(Long id);
    int deleteByInstitutionId(Long id);
    List<LocationData> findByDepartmentId(Long id);
    int deleteByDepartmentId(Long id);
    List<LocationData> findByLocationTypeId(Long id);
    int deleteByLocationTypeId(Long id);
    List<LocationData> findByDataImportExportId(Long id);
    int deleteByDataImportExportId(Long id);

    @Query("SELECT NEW LocationData(item.id,item.code) FROM LocationData item")
    List<LocationData> findAllOptimized();
}
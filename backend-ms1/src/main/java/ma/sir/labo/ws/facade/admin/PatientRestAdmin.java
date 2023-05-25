package  ma.sir.labo.ws.facade.admin;


import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import ma.sir.labo.bean.core.Patient;
import ma.sir.labo.bean.history.PatientHistory;
import ma.sir.labo.dao.criteria.core.PatientCriteria;
import ma.sir.labo.dao.criteria.history.PatientHistoryCriteria;
import ma.sir.labo.service.facade.admin.PatientAdminService;
import ma.sir.labo.ws.converter.PatientConverter;
import ma.sir.labo.ws.dto.PatientDto;
import ma.sir.labo.zynerator.controller.AbstractController;
import ma.sir.labo.zynerator.dto.AuditEntityDto;
import ma.sir.labo.zynerator.util.PaginatedList;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import ma.sir.labo.zynerator.process.Result;


import org.springframework.web.multipart.MultipartFile;
import ma.sir.labo.zynerator.dto.FileTempDto;

@Api("Manages patient services")
@RestController
@RequestMapping("/api/admin/patient/")
public class PatientRestAdmin  extends AbstractController<Patient, PatientDto, PatientHistory, PatientCriteria, PatientHistoryCriteria, PatientAdminService, PatientConverter> {


    @ApiOperation("upload one patient")
    @RequestMapping(value = "upload", method = RequestMethod.POST, consumes = "multipart/form-data")
    public ResponseEntity<FileTempDto> uploadFileAndGetChecksum(@RequestBody MultipartFile file) throws Exception {
        return super.uploadFileAndGetChecksum(file);
    }
    @ApiOperation("upload multiple patients")
    @RequestMapping(value = "upload-multiple", method = RequestMethod.POST, consumes = "multipart/form-data")
    public ResponseEntity<List<FileTempDto>> uploadMultipleFileAndGetChecksum(@RequestBody MultipartFile[] files) throws Exception {
        return super.uploadMultipleFileAndGetChecksum(files);
    }

    @ApiOperation("Finds a list of all patients")
    @GetMapping("")
    public ResponseEntity<List<PatientDto>> findAll() throws Exception {
        return super.findAll();
    }

    @ApiOperation("Finds an optimized list of all patients")
    @GetMapping("optimized")
    public ResponseEntity<List<PatientDto>> findAllOptimized() throws Exception {
        return super.findAllOptimized();
    }

    @ApiOperation("Finds a patient by id")
    @GetMapping("id/{id}")
    public ResponseEntity<PatientDto> findById(@PathVariable Long id, String[] includes, String[] excludes) throws Exception {
        return super.findById(id, includes, excludes);
    }
    @ApiOperation("Saves the specified  patient")
    @PostMapping("")
    public ResponseEntity<PatientDto> save(@RequestBody PatientDto dto) throws Exception {
        return super.save(dto);
    }

    @ApiOperation("Updates the specified  patient")
    @PutMapping("")
    public ResponseEntity<PatientDto> update(@RequestBody PatientDto dto) throws Exception {
        return super.update(dto);
    }

    @ApiOperation("Delete list of patient")
    @PostMapping("multiple")
    public ResponseEntity<List<PatientDto>> delete(@RequestBody List<PatientDto> listToDelete) throws Exception {
        return super.delete(listToDelete);
    }
    @ApiOperation("Delete the specified patient")
    @DeleteMapping("")
    public ResponseEntity<PatientDto> delete(@RequestBody PatientDto dto) throws Exception {
            return super.delete(dto);
    }

    @ApiOperation("Delete the specified patient")
    @DeleteMapping("id/{id}")
    public ResponseEntity<Long> deleteById(@PathVariable Long id) throws Exception {
        return super.deleteById(id);
    }
    @ApiOperation("Delete multiple patients by ids")
    @DeleteMapping("multiple/id")
    public ResponseEntity<List<Long>> deleteByIdIn(@RequestBody List<Long> ids) throws Exception {
            return super.deleteByIdIn(ids);
     }


    @ApiOperation("find by gender id")
    @GetMapping("gender/id/{id}")
    public List<Patient> findByGenderId(@PathVariable Long id){
        return service.findByGenderId(id);
    }
    @ApiOperation("delete by gender id")
    @DeleteMapping("gender/id/{id}")
    public int deleteByGenderId(@PathVariable Long id){
        return service.deleteByGenderId(id);
    }
    @ApiOperation("find by ageCategory id")
    @GetMapping("ageCategory/id/{id}")
    public List<Patient> findByAgeCategoryId(@PathVariable Long id){
        return service.findByAgeCategoryId(id);
    }
    @ApiOperation("delete by ageCategory id")
    @DeleteMapping("ageCategory/id/{id}")
    public int deleteByAgeCategoryId(@PathVariable Long id){
        return service.deleteByAgeCategoryId(id);
    }
    @ApiOperation("find by dataImportExport id")
    @GetMapping("dataImportExport/id/{id}")
    public List<Patient> findByDataImportExportId(@PathVariable Long id){
        return service.findByDataImportExportId(id);
    }
    @ApiOperation("delete by dataImportExport id")
    @DeleteMapping("dataImportExport/id/{id}")
    public int deleteByDataImportExportId(@PathVariable Long id){
        return service.deleteByDataImportExportId(id);
    }
    @ApiOperation("Finds patients by criteria")
    @PostMapping("find-by-criteria")
    public ResponseEntity<List<PatientDto>> findByCriteria(@RequestBody PatientCriteria criteria) throws Exception {
        return super.findByCriteria(criteria);
    }

    @ApiOperation("Finds paginated patients by criteria")
    @PostMapping("find-paginated-by-criteria")
    public ResponseEntity<PaginatedList> findPaginatedByCriteria(@RequestBody PatientCriteria criteria) throws Exception {
        return super.findPaginatedByCriteria(criteria);
    }

    @ApiOperation("Exports patients by criteria")
    @PostMapping("export")
    public ResponseEntity<InputStreamResource> export(@RequestBody PatientCriteria criteria) throws Exception {
        return super.export(criteria);
    }

    @ApiOperation("Gets patient data size by criteria")
    @PostMapping("data-size-by-criteria")
    public ResponseEntity<Integer> getDataSize(@RequestBody PatientCriteria criteria) throws Exception {
        return super.getDataSize(criteria);
    }

    @ApiOperation("Gets patient history by id")
    @GetMapping("history/id/{id}")
    public ResponseEntity<AuditEntityDto> findHistoryById(@PathVariable("id") Long id) throws Exception {
        return super.findHistoryById(id);
    }

    @ApiOperation("Gets patient paginated history by criteria")
    @PostMapping("history-paginated-by-criteria")
    public ResponseEntity<PaginatedList> findHistoryPaginatedByCriteria(@RequestBody PatientHistoryCriteria criteria) throws Exception {
        return super.findHistoryPaginatedByCriteria(criteria);
    }

    @ApiOperation("Exports patient history by criteria")
    @PostMapping("export-history")
    public ResponseEntity<InputStreamResource> exportHistory(@RequestBody PatientHistoryCriteria criteria) throws Exception {
        return super.exportHistory(criteria);
    }

    @ApiOperation("Gets patient history data size by criteria")
    @PostMapping("history-data-size")
    public ResponseEntity<Integer> getHistoryDataSize(@RequestBody PatientHistoryCriteria criteria) throws Exception {
        return super.getHistoryDataSize(criteria);
    }
    public PatientRestAdmin (PatientAdminService service, PatientConverter converter) {
        super(service, converter);
    }


}
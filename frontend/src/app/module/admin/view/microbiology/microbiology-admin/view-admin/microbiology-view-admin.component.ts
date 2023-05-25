import {Component, OnInit} from '@angular/core';


import {AbstractViewController} from 'src/app/zynerator/controller/AbstractViewController';
import { environment } from 'src/environments/environment';

import {MicrobiologyService} from 'src/app/controller/service/Microbiology.service';
import {MicrobiologyDto} from 'src/app/controller/model/Microbiology.model';
import {MicrobiologyCriteria} from 'src/app/controller/criteria/MicrobiologyCriteria.model';

import {SeroTypeDto} from 'src/app/controller/model/SeroType.model';
import {SeroTypeService} from 'src/app/controller/service/SeroType.service';
import {DataImportExportDto} from 'src/app/controller/model/DataImportExport.model';
import {DataImportExportService} from 'src/app/controller/service/DataImportExport.service';
import {AntibioticDto} from 'src/app/controller/model/Antibiotic.model';
import {AntibioticService} from 'src/app/controller/service/Antibiotic.service';
import {OrganismDto} from 'src/app/controller/model/Organism.model';
import {OrganismService} from 'src/app/controller/service/Organism.service';
@Component({
  selector: 'app-microbiology-view-admin',
  templateUrl: './microbiology-view-admin.component.html'
})
export class MicrobiologyViewAdminComponent extends AbstractViewController<MicrobiologyDto, MicrobiologyCriteria, MicrobiologyService> implements OnInit {


    constructor(private microbiologyService: MicrobiologyService, private seroTypeService: SeroTypeService, private dataImportExportService: DataImportExportService, private antibioticService: AntibioticService, private organismService: OrganismService){
        super(microbiologyService);
    }

    ngOnInit(): void {
        this.organism = new OrganismDto();
        this.organismService.findAll().subscribe((data) => this.organisms = data);
        this.seroType = new SeroTypeDto();
        this.seroTypeService.findAll().subscribe((data) => this.seroTypes = data);
        this.antibiotic = new AntibioticDto();
        this.antibioticService.findAll().subscribe((data) => this.antibiotics = data);
        this.dataImportExport = new DataImportExportDto();
        this.dataImportExportService.findAll().subscribe((data) => this.dataImportExports = data);
    }


    get seroType(): SeroTypeDto {
       return this.seroTypeService.item;
    }
    set seroType(value: SeroTypeDto) {
        this.seroTypeService.item = value;
    }
    get seroTypes():Array<SeroTypeDto> {
       return this.seroTypeService.items;
    }
    set seroTypes(value: Array<SeroTypeDto>) {
        this.seroTypeService.items = value;
    }
    get antibiotic(): AntibioticDto {
       return this.antibioticService.item;
    }
    set antibiotic(value: AntibioticDto) {
        this.antibioticService.item = value;
    }
    get antibiotics():Array<AntibioticDto> {
       return this.antibioticService.items;
    }
    set antibiotics(value: Array<AntibioticDto>) {
        this.antibioticService.items = value;
    }
    get dataImportExport(): DataImportExportDto {
       return this.dataImportExportService.item;
    }
    set dataImportExport(value: DataImportExportDto) {
        this.dataImportExportService.item = value;
    }
    get dataImportExports():Array<DataImportExportDto> {
       return this.dataImportExportService.items;
    }
    set dataImportExports(value: Array<DataImportExportDto>) {
        this.dataImportExportService.items = value;
    }
    get organism(): OrganismDto {
       return this.organismService.item;
    }
    set organism(value: OrganismDto) {
        this.organismService.item = value;
    }
    get organisms():Array<OrganismDto> {
       return this.organismService.items;
    }
    set organisms(value: Array<OrganismDto>) {
        this.organismService.items = value;
    }


}
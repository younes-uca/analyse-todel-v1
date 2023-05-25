import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {BehaviorSubject, Observable} from 'rxjs';

import * as moment from 'moment';

import { RoleService } from 'src/app/zynerator/security/Role.service';
import {environment} from 'src/environments/environment';
import {PaginatedList} from 'src/app/zynerator/dto/PaginatedList.model';
import {BaseDto} from 'src/app/zynerator/dto/BaseDto.model';

import {DataAnalysisDto} from '../model/DataAnalysis.model';
import {DataAnalysisCriteria} from '../criteria/DataAnalysisCriteria.model';
import {AbstractService} from 'src/app/zynerator/service/AbstractService';

import {LaboratoryDto} from '../model/Laboratory.model';

@Injectable({
  providedIn: 'root'
})
export class DataAnalysisService extends AbstractService<DataAnalysisDto, DataAnalysisCriteria> {
     constructor(private http: HttpClient, private roleService: RoleService) {
        super();
        this.setHttp(http);
        this.setApi(environment.apiUrl + 'admin/dataAnalysis/');
    }

    public constrcutDto(): DataAnalysisDto {
        return new DataAnalysisDto();
    }

    public constrcutCriteria(): DataAnalysisCriteria {
        return new DataAnalysisCriteria();
    }
}

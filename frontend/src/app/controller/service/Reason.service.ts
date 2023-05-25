import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {BehaviorSubject, Observable} from 'rxjs';

import * as moment from 'moment';

import { RoleService } from 'src/app/zynerator/security/Role.service';
import {environment} from 'src/environments/environment';
import {PaginatedList} from 'src/app/zynerator/dto/PaginatedList.model';
import {BaseDto} from 'src/app/zynerator/dto/BaseDto.model';

import {ReasonDto} from '../model/Reason.model';
import {ReasonCriteria} from '../criteria/ReasonCriteria.model';
import {AbstractService} from 'src/app/zynerator/service/AbstractService';


@Injectable({
  providedIn: 'root'
})
export class ReasonService extends AbstractService<ReasonDto, ReasonCriteria> {
     constructor(private http: HttpClient, private roleService: RoleService) {
        super();
        this.setHttp(http);
        this.setApi(environment.apiUrl + 'admin/reason/');
    }

    public constrcutDto(): ReasonDto {
        return new ReasonDto();
    }

    public constrcutCriteria(): ReasonCriteria {
        return new ReasonCriteria();
    }
}

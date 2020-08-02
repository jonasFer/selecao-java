import { Injectable } from '@angular/core';
import { catchError, tap } from 'rxjs/operators';
import { Observable } from 'rxjs';
import { HttpClient } from '@angular/common/http';
import { HttpUtilService } from './http-util-service';
import {Distribuidora} from '../model/distribuidora-model';

@Injectable()

export class DistribuidoraService {
  private readonly PATH: string = 'http://localhost:8080/revenda';

  constructor(
    private http: HttpClient,
    private httpUtil: HttpUtilService
  ) { }

  getAll(): Observable<Distribuidora[]> {
    return this.http.get<Distribuidora[]>(this.PATH)
      .pipe(
        tap(),
        catchError(this.httpUtil.handleError('getAll', []))
      );
  }
}

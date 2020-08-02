import { Injectable } from '@angular/core';
import { catchError, tap } from 'rxjs/operators';
import { Observable } from 'rxjs';
import { HttpClient } from '@angular/common/http';
import { HttpUtilService } from './http-util-service';
import {Bandeira} from '../model/bandeira-model';

@Injectable()

export class BandeiraService {
  private readonly PATH: string = 'http://localhost:8080/bandeira';

  constructor(
    private http: HttpClient,
    private httpUtil: HttpUtilService
  ) { }

  getAll(): Observable<Bandeira[]> {
    return this.http.get<Bandeira[]>(this.PATH)
      .pipe(
        tap(),
        catchError(this.httpUtil.handleError('getAll', []))
      );
  }
}

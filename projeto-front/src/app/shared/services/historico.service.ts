import { Injectable } from '@angular/core';
import { catchError, tap } from 'rxjs/operators';
import { Observable } from 'rxjs';
import { HttpClient } from '@angular/common/http';
import { HttpUtilService } from './http-util-service';
import {Historico} from '../../admin/historico/historico.model';

@Injectable()

export class HistoricoService {
  private readonly PATH: string = 'http://localhost:8080/historico';

  constructor(
    private http: HttpClient,
    private httpUtil: HttpUtilService
  ) { }

  getHistorico(): Observable<Historico[]> {
    return this.http.get<Historico[]>(this.PATH)
      .pipe(
        tap(),
        catchError(this.httpUtil.handleError('getHistorico', []))
      );
  }

  save(historico: Historico): Observable<any> {
    return this.http.post(
      this.PATH,
      historico,
      this.httpUtil.headers()
    );
  }

  edit(id: string, historico: Historico): Observable<any> {
    return this.http.put(
      this.PATH + '/' + id,
      historico,
      this.httpUtil.headers()
    );
  }

  buscarPorId(id: string): Observable<any> {
    return this.http.get(
      this.PATH + '/' + id,
      this.httpUtil.headers()
    );
  }

  deletar(id: number): Observable<any> {
    return this.http.delete(
      this.PATH + '/' + id,
      this.httpUtil.headers()
    );
  }
}

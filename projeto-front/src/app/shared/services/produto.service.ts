import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { HttpClient } from '@angular/common/http';
import { HttpUtilService } from './http-util-service';

@Injectable()

export class ProdutoService {
  private readonly PATH: string = 'http://localhost:8080/produto';

  constructor(
    private http: HttpClient,
    private httpUtil: HttpUtilService
  ) { }

  all(): Observable<any> {
    return this.http.get(this.PATH, this.httpUtil.headers());
  }

  byId(id: string): Observable<any> {
    return this.http.get(
      this.PATH + '/' + id,
      this.httpUtil.headers()
    );
  }
}

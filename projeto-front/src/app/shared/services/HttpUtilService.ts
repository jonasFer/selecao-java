import { Injectable } from '@angular/core';
import { HttpHeaders } from '@angular/common/http';
import {Observable, of} from 'rxjs';

@Injectable()
export class HttpUtilService {

  constructor() { }

  headers() {
    let httpHeaders: HttpHeaders = new HttpHeaders();
    httpHeaders = httpHeaders.set('Content-Type', 'application/json');

    return { headers: httpHeaders };
  }

  public handleError<T>(operation = 'operation', result?: T) {
    return (error: any): Observable<T> => {
      return of(result as T);
    };
  }
}








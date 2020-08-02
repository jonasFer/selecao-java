import { Injectable } from '@angular/core';
import { catchError, tap } from 'rxjs/operators';
import { Observable } from 'rxjs';
import { HttpClient } from '@angular/common/http';
import { Usuario} from '../../admin/usuario/usuario.model';
import { HttpUtilService } from './http-util-service';

@Injectable()

export class UsuarioService {
  private readonly PATH: string = 'http://localhost:8080/usuario';

  constructor(
    private http: HttpClient,
    private httpUtil: HttpUtilService
  ) { }

  getAll(): Observable<Usuario[]> {
    return this.http.get<Usuario[]>(this.PATH)
      .pipe(
        tap(),
        catchError(this.httpUtil.handleError('getUsuarios', []))
      );
  }

  save(usuario: Usuario): Observable<any> {
    return this.http.post(
      this.PATH,
      usuario,
      this.httpUtil.headers()
    );
  }

  edit(id: string, usuario: Usuario): Observable<any> {
    return this.http.put(
      this.PATH + '/' + id,
      usuario,
      this.httpUtil.headers()
    );
  }

  getById(id: string): Observable<any> {
    return this.http.get(
       this.PATH + '/' + id,
      this.httpUtil.headers()
    );
  }

  delete(id: number): Observable<any> {
    return this.http.delete(
      this.PATH + '/' + id,
      this.httpUtil.headers()
    );
  }
}

import { Component, OnInit } from '@angular/core';
import {Usuario} from './usuario.model';
import {UsuarioService} from '../../shared/services/usuario.service';

@Component({
  selector: 'app-usuario',
  templateUrl: './usuario.component.html',
  styleUrls: ['./usuario.component.css']
})
export class UsuarioComponent implements OnInit {
  usuarios: Usuario[];
  constructor(
    private service: UsuarioService
  ) { }

  ngOnInit() {
    this.getAllUsuarios();
  }

  getAllUsuarios() {
    this.service.getAll()
      .subscribe(data => {
        this.usuarios = data;
      }, error => {
        console.log(error);
      });
  }

  deletar(id: number) {
    this.service.delete(id)
      .subscribe(
        data => {
          alert('Usuário deletado');
        },
        err => {
          console.log(err);
        }
      );
  }
}

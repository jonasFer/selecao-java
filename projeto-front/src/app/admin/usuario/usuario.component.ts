import { Component, OnInit } from '@angular/core';
import {Usuario} from './usuario.model';
import {UsuarioService} from './usuario.service';

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
    this.service.getUsuarios()
      .subscribe(data => {
        this.usuarios = data;
      }, error => {
        console.log(error);
      });
  }

  deletar(id: number) {
    this.service.deletar(id)
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

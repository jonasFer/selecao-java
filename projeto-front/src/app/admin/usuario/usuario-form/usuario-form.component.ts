import { Component, OnInit } from '@angular/core';
import {Usuario} from '../usuario.model';
import { FormGroup, FormBuilder } from '@angular/forms';
import {UsuarioService} from '../usuario.service';
import {ActivatedRoute, Router} from '@angular/router';
import {error} from 'util';

@Component({
  selector: 'app-usuario-form',
  templateUrl: './usuario-form.component.html',
  styleUrls: ['./usuario-form.component.css']
})
export class UsuarioFormComponent implements OnInit {
  private usuarioId: string;
  formUsuario: FormGroup;
  private usuario: Usuario;

  constructor(
    private route: ActivatedRoute,
    private router: Router,
    private formBuilder: FormBuilder,
    private usuarioService: UsuarioService,
  ) {
    this.usuarioId = this.route.snapshot.paramMap.get('id');
  }

  ngOnInit() {
    this.usuario = new Usuario();
    if (this.usuarioId) {
      this.obterDadosUsuario();
    }
    this.createForm(this.usuario);
  }

  onSubmit() {
    this.salvar();
  }

  createForm(usuario: Usuario) {
    this.formUsuario = this.formBuilder.group({
      nome: [usuario.nome]
    });
  }

  salvar() {
    if (this.formUsuario.invalid) { return; }
    if (this.usuarioId) {
      this.editar();
      return;
    }
    this.cadastrar();
  }

  cadastrar() {
    this.usuarioService.cadastrar(this.formUsuario.value)
      .subscribe(
        data => {
          this.router.navigate(['/admin/usuario']);
        },
        err => {
          console.log(err);
        }
      );
  }

  editar() {
    this.usuarioService.editar(this.usuarioId, this.formUsuario.value)
      .subscribe(
        data => {
          this.router.navigate(['/admin/usuario']);
        },
        err => {
          console.log(err);
        }
      );
  }

  obterDadosUsuario() {
    this.usuarioService.buscarPorId(this.usuarioId)
      .subscribe(
        dados => {
          const data = dados;
          this.formUsuario.get('nome').setValue(dados.nome);
        },
        err => {
          console.log(err);
        }
      );
  }
}

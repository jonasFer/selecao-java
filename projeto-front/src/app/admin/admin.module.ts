import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterModule } from '@angular/router';
import { AppRoutingModule} from '../app-routing.module';
import { HeaderComponent } from '../shared/components/header/header.component';
import { FooterComponent } from '../shared/components/footer/footer.component';
import { UsuarioComponent } from './usuario/usuario.component';
import {HttpUtilService} from '../shared/services/HttpUtilService';
import {UsuarioService} from './usuario/usuario.service';
import { UsuarioFormComponent } from './usuario/usuario-form/usuario-form.component';
import {ReactiveFormsModule} from '@angular/forms';

@NgModule({
  imports: [
    CommonModule,
    RouterModule,
    ReactiveFormsModule,
    AppRoutingModule
  ],
  declarations: [
    HeaderComponent,
    FooterComponent,
    UsuarioComponent,
    UsuarioFormComponent
  ],
  providers: [
    HttpUtilService,
    UsuarioService
  ],
  exports: [
    HeaderComponent,
    FooterComponent
  ],
  entryComponents: []
})

export class AdminModule { }

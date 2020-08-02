import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterModule } from '@angular/router';
import { AppRoutingModule} from '../app-routing.module';
import { HeaderComponent } from '../shared/components/header/header.component';
import { FooterComponent } from '../shared/components/footer/footer.component';
import { UsuarioComponent } from './usuario/usuario.component';
import {HttpUtilService} from '../shared/services/http-util-service';
import {UsuarioService} from '../shared/services/usuario.service';
import { UsuarioFormComponent } from './usuario/usuario-form/usuario-form.component';
import {ReactiveFormsModule} from '@angular/forms';
import { HistoricoComponent } from './historico/historico.component';
import { RelatorioComponent } from './relatorio/relatorio.component';
import {HistoricoService} from '../shared/services/historico.service';
import { HistoricoFormComponent } from './historico/historico-form/historico-form.component';
import {ProdutoService} from '../shared/services/produto.service';
import {BandeiraService} from '../shared/services/bandeira.service';
import {DistribuidoraService} from '../shared/services/distribuidora.service';

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
    UsuarioFormComponent,
    HistoricoComponent,
    RelatorioComponent,
    HistoricoFormComponent,
  ],
  providers: [
    HttpUtilService,
    UsuarioService,
    HistoricoService,
    ProdutoService,
    BandeiraService,
    DistribuidoraService
  ],
  exports: [
    HeaderComponent,
    FooterComponent,
  ],
  entryComponents: []
})

export class AdminModule { }

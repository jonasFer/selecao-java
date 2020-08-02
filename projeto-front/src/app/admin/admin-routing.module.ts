import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { UsuarioComponent } from './usuario/usuario.component';
import { UsuarioFormComponent } from './usuario/usuario-form/usuario-form.component';
import {HistoricoComponent} from './historico/historico.component';
import {RelatorioComponent} from './relatorio/relatorio.component';
import {AdminComponent} from './admin.component';
import {HistoricoFormComponent} from './historico/historico-form/historico-form.component';

const AdminRoutes: Routes = [
  {
    path: 'admin',
    component: AdminComponent,
    children: [
      {
        path: '',
        redirectTo: 'home',
        pathMatch: 'full'
      },
      {
        path: 'home',
        component: RelatorioComponent
      },
      {
        path: 'usuario',
        children: [
          {
            path: '',
            component: UsuarioComponent
          },
          {
            path: 'formulario',
            component: UsuarioFormComponent
          },
          {
            path: 'formulario/:id',
            component: UsuarioFormComponent
          }
        ]
      },
      {
        path: 'historico',
        children: [
          {
            path: '',
            component: HistoricoComponent
          },
          {
            path: 'formulario',
            component: HistoricoFormComponent
          },
          {
            path: 'formulario/:id',
            component: HistoricoFormComponent
          }
        ]
      }
    ]
  }
];

@NgModule({
  imports: [RouterModule.forChild(AdminRoutes)],
  exports: [RouterModule]
})
export class AdminRoutingModule {
}

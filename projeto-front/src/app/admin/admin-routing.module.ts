import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AdminComponent } from './admin.component';
import { UsuarioComponent } from './usuario/usuario.component';
import { UsuarioFormComponent } from './usuario/usuario-form/usuario-form.component';

const AdminRoutes: Routes = [
  {
    path: 'admin',
    component: AdminComponent,
    children: [
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

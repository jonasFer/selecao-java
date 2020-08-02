import { Component, OnInit } from '@angular/core';
import {HistoricoService} from '../../shared/services/historico.service';
import {Historico} from './historico.model';
import {Router} from '@angular/router';

@Component({
  selector: 'app-historico',
  templateUrl: './historico.component.html',
  styleUrls: ['./historico.component.css']
})
export class HistoricoComponent implements OnInit {
  historicos: Historico[];
  constructor(
    private router: Router,
    private service: HistoricoService
  ) { }

  ngOnInit() {
    this.getAllHistoricos();
  }

  getAllHistoricos() {
    this.service.getHistorico()
      .subscribe(data => {
        this.historicos = data;
      }, error => {
        console.log(error);
      });
  }

  deletar(id: number) {
    this.service.deletar(id)
      .subscribe(
        data => {
          alert('Histórico deletado');
        },
        err => {
          console.log(err);
        }
      );
  }
}

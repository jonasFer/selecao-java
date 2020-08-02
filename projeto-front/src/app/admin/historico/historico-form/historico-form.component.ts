import {AfterViewInit, Component, OnInit} from '@angular/core';
import { FormBuilder, FormGroup } from '@angular/forms';
import { Historico } from '../historico.model';
import {ActivatedRoute, Router} from '@angular/router';
import { HistoricoService } from '../../../shared/services/historico.service';
import {ProdutoService} from '../../../shared/services/produto.service';
import {Produto} from '../../../shared/model/produto-model';
import {BandeiraService} from '../../../shared/services/bandeira.service';
import {DistribuidoraService} from '../../../shared/services/distribuidora.service';
import {Bandeira} from '../../../shared/model/bandeira-model';
import {Distribuidora} from '../../../shared/model/distribuidora-model';

@Component({
  selector: 'app-historico-form',
  templateUrl: './historico-form.component.html',
  styleUrls: ['./historico-form.component.css']
})
export class HistoricoFormComponent implements OnInit {
  private produtos: Produto[];
  private bandeiras: Bandeira[];
  private distribuidoras: Distribuidora[];
  private historicoId: string;
  formHistorico: FormGroup;
  private historico: Historico;
  constructor(
    private route: ActivatedRoute,
    private router: Router,
    private formBuilder: FormBuilder,
    private historicoService: HistoricoService,
    private produtoService: ProdutoService,
    private bandeiraService: BandeiraService,
    private distribuidoraService: DistribuidoraService
  ) {
    this.historicoId = this.route.snapshot.paramMap.get('id');
  }

  ngOnInit() {
    this.historico = new Historico();
    this.populateSelect();
    this.createForm(this.historico);
    if (this.historicoId) {
      this.obterDadosHistorico();
    }
  }

  createForm(historico: Historico) {
    this.formHistorico = this.formBuilder.group({
      revenda: '',
      bandeira: '',
      produto: '',
      unidade: '',
      valor_venda: '',
      valor_custo: '',
      data_coleta: ''
    });
  }

  obterDadosHistorico() {
    this.historicoService.buscarPorId(this.historicoId)
      .subscribe(
        data => {
            this.historico = data;
            this.formHistorico.get('revenda').setValue(data.revenda);
            this.formHistorico.get('bandeira').setValue(data.bandeira);
            this.formHistorico.get('produto').setValue(data.produto);
            this.formHistorico.get('unidade').setValue(data.unidade);
            this.formHistorico.get('valor_venda').setValue(data.valor_venda);
            this.formHistorico.get('valor_custo').setValue(data.valor_custo);
            this.formHistorico.get('data_coleta').setValue(data.data_coleta);
          },
        err => {
          console.log(err);
        }
      );
  }
  onSubmit() {
    this.salvar();
  }

  salvar() {
    if (this.formHistorico.invalid) { return; }
    if (this.historicoId) {
      this.editar();
      return;
    }
    this.cadastrar();
  }

  cadastrar() {
    this.historicoService.save(this.formHistorico.value)
      .subscribe(
        data => {
          this.router.navigate(['/admin/historico']);
        },
        err => {
          console.log(err);
        }
      );
  }

  editar() {
    this.historicoService.edit(this.historicoId, this.formHistorico.value)
      .subscribe(
        data => {
          this.router.navigate(['/admin/historico']);
        },
        err => {
          console.log(err);
        }
      );
  }

  populateSelect() {
    this.getProdutos();
    this.getDistribuidoras();
    this.getBandeiras();
  }

  getProdutos() {
    this.produtoService.all()
      .subscribe(data => {
        this.produtos = data;
      }, error => {
        console.log(error);
      });
  }

  getBandeiras() {
    this.bandeiraService.getAll()
      .subscribe(data => {
        this.bandeiras = data;
      }, error => {
        console.log(error);
      });
  }

  getDistribuidoras() {
    this.distribuidoraService.getAll()
      .subscribe(data => {
        this.distribuidoras = data;
      }, error => {
        console.log(error);
      });
  }
}

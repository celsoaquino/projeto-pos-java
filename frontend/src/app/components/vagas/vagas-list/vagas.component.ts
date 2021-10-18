import {Component, Input, OnInit} from '@angular/core';
import {Vaga} from "../../../models/vaga";
import {VagaService} from "../../../services/vaga.service";
import {MovimentoService} from "../../../services/movimento.service";
import {Movimento} from "../../../models/movimento";

@Component({
  selector: 'app-vagas',
  templateUrl: './vagas.component.html',
  styleUrls: ['./vagas.component.scss']
})
export class VagasComponent implements OnInit {

  @Input() vagaId!: number;
  spinner: boolean = true;
  vagas: Vaga[] = [];
  visible: boolean = false;
  veiculoId?: string;
  movimento?: Movimento;

  constructor(private vagaService: VagaService,
              private movimentoService: MovimentoService) {
  }

  ngOnInit(): void {
    this.getVagas();
  }

  getVagas() {
    this.vagaService.listVagas()
      .subscribe(data => {
        if (data) {
          this.spinner = false;
        }
        this.vagas = data;
      });
  }

  getVagaId(id: number, full: boolean) {
    this.vagaId = id;
    this.visible = full
  }

  getMovimentoByVeiculoId(id: string) {
    this.movimentoService.getMovimentoByVeiculoId(id)
      .subscribe(data => {
        this.movimento = data;
        this.veiculoId = this.movimento.veiculoId
      })
  }
}

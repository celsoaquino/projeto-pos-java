import {Component, Input, OnInit} from '@angular/core';
import {MovimentoService} from "../../../services/movimento.service";
import {Movimento} from "../../../models/movimento";
import {Router} from "@angular/router";

@Component({
  selector: 'app-saida',
  templateUrl: './saida.component.html',
  styleUrls: ['./saida.component.scss']
})
export class SaidaComponent implements OnInit {
  @Input() vagaId!: number;
  movimentos!: Movimento[];
  @Input() veiculoId!: string;

  constructor(
    private router: Router,
    private movimentoService: MovimentoService) {
  }

  ngOnInit(): void {
    this.getMovimentos();
  }

  saida(id: string) {
    this.movimentoService.saida(id)
      .subscribe(data => {
        this.router.navigate(['/']).then(() => {
          window.location.reload();
        });
      })
  }

  getMovimentos(): void {
    this.movimentoService.list()
      .subscribe(data => {
          this.movimentos = data;
        },
        error => {
          console.log(error);
        });
  }

  getMovimentoByVeiculoId(id: string) {
    this.movimentoService.getMovimentoByVeiculoId(id)
      .subscribe(data => {
        console.log(data)
      })
  }
}

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
  @Input() veiculoId!: string;
  movimentos!: Movimento[];


  constructor(
    private router: Router,
    private movimentoService: MovimentoService) {

  }

  ngOnInit(): void {
    this.getMovimentos();
  }

  saida(id: string) {
    this.movimentoService.saida(id)
      .subscribe(() => {
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
}

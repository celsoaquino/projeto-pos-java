import {Component, Input, OnInit} from '@angular/core';
import {MovimentoService} from "../../../services/movimento.service";
import {Veiculo} from "../../../models/veiculo";
import {Router} from "@angular/router";

@Component({
  selector: 'app-entrada',
  templateUrl: './entrada.component.html',
  styleUrls: ['./entrada.component.scss']
})
export class EntradaComponent implements OnInit {


  @Input()vagaId!: number;
  veiculo: Veiculo = {
    placa: '',
    vagaId: 0
  };

  constructor(private movimentoService: MovimentoService,
              private router: Router) {
  }

  ngOnInit(): void {
  }

  entrada(veiculo: Veiculo) {
    this.movimentoService.entrada(veiculo)
      .subscribe(data => {
        this.router.navigate(['/']).then(() => {
          window.location.reload();
        });
      })
  }


}

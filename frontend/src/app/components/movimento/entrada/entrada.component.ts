import {Component, Input, OnInit} from '@angular/core';
import {MovimentoService} from "../../../services/movimento.service";
import {Veiculo} from "../../../models/veiculo";
import {Router} from "@angular/router";
import {HttpErrorResponse} from "@angular/common/http";

@Component({
  selector: 'app-entrada',
  templateUrl: './entrada.component.html',
  styleUrls: ['./entrada.component.scss']
})
export class EntradaComponent implements OnInit {

  @Input() vagaId!: number;
  errorMessage!: string;
  placaValida!: boolean;
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
          console.log(data)
          this.router.navigate(['/']).then(() => {
            window.location.reload();
          });
        },
        (error: HttpErrorResponse) => {
          console.log(error)
          this.errorMessage = error.error;
          setTimeout(() =>
            this.errorMessage = '', 3000)
        })
  }

  validarPlaca(placa: string) {
    const regex = /[A-Z]{3}[0-9][0-9A-Z][0-9]{2}/;
    if (regex.test(placa)) {
      this.placaValida = true;
    } else {
      this.placaValida = false;
    }
  }

  limparCampo() {
    this.veiculo.placa = '';
  }
}

import {Component, Input, OnInit} from '@angular/core';
import {MovimentoService} from "../../../services/movimento.service";
import {Veiculo} from "../../../models/veiculo";
import {Router} from "@angular/router";
import {HttpErrorResponse} from "@angular/common/http";
import {FormControl, NgForm} from "@angular/forms";

@Component({
  selector: 'app-entrada',
  templateUrl: './entrada.component.html',
  styleUrls: ['./entrada.component.scss']
})
export class EntradaComponent implements OnInit {

  @Input() vagaId!: number;
  errorMessage!: [];
  isError = false;
  isValidPlaca!: boolean;
  veiculo!: Veiculo;

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
         this.isError = true;
          this.errorMessage = error.error.errors;
          console.log(error)
          setTimeout(() =>
            this.isError = false, 3000)
        })
  }

  validarPlaca(placa: string) {
    const pattern = new RegExp('[A-Z]{3}[0-9][0-9A-Z][0-9]{2}');
    if (pattern.test(placa)) {
      this.isValidPlaca= true;
    } else {
      this.isValidPlaca = false;
    }
  }


  limparCampo(f: NgForm) {
    f.resetForm();
  }
}

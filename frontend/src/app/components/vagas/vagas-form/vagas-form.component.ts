import {Component, OnInit} from '@angular/core';
import {VagaService} from "../../../services/vaga.service";
import {Router} from "@angular/router";
import {Vaga} from "../../../models/vaga";

@Component({
  selector: 'app-vagas-form',
  templateUrl: './vagas-form.component.html',
  styleUrls: ['./vagas-form.component.scss']
})
export class VagasFormComponent implements OnInit {


  errorMessage!: string;
  invalid = '';
  vagaId!: number;
  vagas?: Vaga[];
  qtd = {
    'quantindade': 0
  };

  constructor(private vagaService: VagaService,
              private router: Router) {
  }

  ngOnInit(): void {
    this.getVagas();
  }

  createVagas(qtd: number) {
    this.vagaService.create(qtd)
      .subscribe(response => {
          this.router.navigate(['/']).then(() => {
            window.location.reload();
          });
        },
        error => {
          console.log(error);
        })
  }

  getVagas(): void {
    this.vagaService.listVagas()
      .subscribe(data => {
          this.vagas = data
        },
        error => {
          console.log(error);
        });
  }

  deleteVaga(id: number): void {
    this.vagaService.delete(id)
      .subscribe(response => {
          this.router.navigate(['/']).then(() => {
            window.location.reload();
          });
        },
        error => {
          this.errorMessage = error.error;
         this.invalid = 'is-invalid';
          setTimeout(() =>
            this.invalid = '', 3000)
        })
  }
}

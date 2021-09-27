import {Component, Input, OnInit, Output} from '@angular/core';
import {Vaga} from "../../../models/vaga";
import {VagaService} from "../../../services/vaga.service";

@Component({
  selector: 'app-vagas',
  templateUrl: './vagas.component.html',
  styleUrls: ['./vagas.component.scss']
})
export class VagasComponent implements OnInit {

  spinner: boolean = true;
  vagas?: Vaga[];
  @Input() vagaId!: number;
  visible: boolean = false;
  target!: string;
  toggle!: string;
  constructor(private vagaService: VagaService) {
  }

  ngOnInit(): void {
    this.getVagas();
  }

  getVagas(): void {
    this.vagaService.list()
      .subscribe(data => {
        console.log(data);
          if (data) {
            this.spinner = false;
          }
          this.vagas = data;
        },
        error => {
          console.log(error);
        });
  }

  getVagaId(id: number, full: boolean) {
    this.vagaId = id;
    this.visible = full
    if (full == false) {
      this.target = '#entradaModal'
    } else {
      this.target = '#saidaModal'
    }
  }
}

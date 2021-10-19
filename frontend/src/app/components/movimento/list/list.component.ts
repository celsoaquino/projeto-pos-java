import {Component, OnInit} from '@angular/core';
import {MovimentoService} from "../../../services/movimento.service";
import {Movimento} from "../../../models/movimento";
import {FormControl} from "@angular/forms";

@Component({
  selector: 'app-list',
  templateUrl: './list.component.html',
  styleUrls: ['./list.component.scss']
})
export class ListComponent implements OnInit {

  movimentos!: Movimento[];
  size = 10;
  filtro: string = "";
  page: number = 1;

  data!: any;


  constructor(private movimentoService: MovimentoService) {
  }

  ngOnInit(): void {
    this.list();
  }

  list() {
    this.movimentoService.list()
      .subscribe(data => {
        this.movimentos = data;
      })
  }

  ngOnChanges(size: number) {
    this.size = size;
  }


  filtrarPoData(e: FormControl) {
    this.page = 1
    this.movimentoService.filtroPorData(this.data)
      .subscribe(data => {
        this.movimentos = data;
      })
  }

  filtrarPlaca(filtro: string) {
    this.page = 1;
    if (filtro) {
      this.movimentos = this.movimentos
        .filter(p =>
          p.veiculoPlaca!.indexOf(filtro) >= 0);
    } else {
      this.data = '';
      this.list()
    }
  }

  mostrarTodos() {
    this.page = 1;
    this.data = '';
    this.list();
  }


  /*onOcupadoChange(event: Event) {
    this.isCheckedOcupado = (event.target as HTMLInputElement).checked;
    this.page = 1
    if (this.isCheckedOcupado) {
      this.disableVago = true;
      this.movimentos = this.movimentos.filter(o => o.saida == null)
    } else {
      this.disableVago = false
      this.data = '';
      this.list();
    }
  }

  onVagoChange(event: Event) {
    this.isCheckedVago = (event.target as HTMLInputElement).checked;
    this.page = 1
    if (this.isCheckedVago) {
      this.disableOcupado = true;
      this.movimentos = this.movimentos.filter(o => o.saida != null)
    } else {
      this.disableOcupado = false;
      this.data = '';
      this.list();
    }
  }*/

}

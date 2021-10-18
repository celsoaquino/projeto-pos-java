import {Component, OnInit} from '@angular/core';
import {MovimentoService} from "../../../services/movimento.service";
import {Movimento, MovimentoPage} from "../../../models/movimento";

@Component({
  selector: 'app-list',
  templateUrl: './list.component.html',
  styleUrls: ['./list.component.scss']
})
export class ListComponent implements OnInit {

  movimentos!: Movimento[];
  movimentoPage!: MovimentoPage;
  size = 10;
  filtro: string = "";
  page: number = 1;
  disableVago!: boolean;
  disableOcupado!: boolean;



  constructor(private movimentoService: MovimentoService) {
  }

  ngOnInit(): void {
    this.list();
    //this.pageList(0, this.size)
  }

  /*pageList(page: number, size: number) {
    this.movimentoService.pageList(page, size)
      .subscribe(data => {
        this.movimentos = data.content;
        this.movimentoPage = data;

      })
  }*/

  list() {
    this.movimentoService.list()
      .subscribe(data => {
        this.movimentos = data;
      })
  }

  ngOnChanges(size: number) {
    this.size = size;
  }

  filtrarPlaca(filtro: string) {
    if (filtro) {
      this.page = 1;
      this.movimentos = this.movimentos
        .filter(p =>
          p.veiculoPlaca!.indexOf(filtro) >= 0);
    } else {
      this.list()
    }
  }

  onOcupadoChange(event: Event) {
    const isCheckedOcupado = (event.target as HTMLInputElement).checked;
    if (isCheckedOcupado) {
      this.disableVago = true;
      this.movimentos = this.movimentos.filter( o => o.saida == null)
    } else {
      this.page = 1;
      this.disableVago = false
      this.list();
    }
  }

  onVagoChange(event: Event) {
     const isCheckedVago =  (event.target as HTMLInputElement).checked;
     console.log(event)
    if (isCheckedVago) {
      this.disableOcupado = true;
      this.movimentos = this.movimentos.filter( o => o.saida != null)
    } else {
      this.page = 1;
      this.disableOcupado = false
      this.list();
    }
  }
}

import { Component, OnInit } from '@angular/core';
import {MovimentoService} from "../../../services/movimento.service";
import {Movimento} from "../../../models/movimento";

@Component({
  selector: 'app-list',
  templateUrl: './list.component.html',
  styleUrls: ['./list.component.scss']
})
export class ListComponent implements OnInit {

  movimentos!: Movimento[];

  constructor(private movimentoService: MovimentoService) { }

  ngOnInit(): void {
    this.list()
  }

  list() {
    this.movimentoService.list()
      .subscribe(data => {
        this.movimentos = data;
        console.log(data)
      })
  }
}

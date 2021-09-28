import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {Veiculo} from "../models/veiculo";
import {Movimento} from "../models/movimento";

@Injectable({
  providedIn: 'root'
})
export class MovimentoService {

  baseUrl = 'http://localhost:8080/movimento'

  constructor(private http: HttpClient) { }



  entrada(veiculo: Veiculo): Observable<any> {
    return this.http.post(`${this.baseUrl}/entrada`,  veiculo);
  }

  saida(movimentoId: string): Observable<any> {
    return this.http.put(`${this.baseUrl}/saida/${movimentoId}`, {});
  }

  list(): Observable<any>{
    return this.http.get(this.baseUrl);
  }

  getMovimentoByVeiculoId(id: string): Observable<Movimento> {
    return this.http.get<Movimento>(`${this.baseUrl}/veiculo-id/${id}`);
  }
}

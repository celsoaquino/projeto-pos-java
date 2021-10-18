import {Injectable} from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {Veiculo} from "../models/veiculo";
import {Movimento} from "../models/movimento";
import {environment} from "../../environments/environment";

@Injectable({
  providedIn: 'root'
})
export class MovimentoService {

  private readonly API = `${environment.API}movimento`;


  constructor(private http: HttpClient) {
  }


  entrada(veiculo: Veiculo): Observable<any> {
    return this.http.post(`${this.API}/entrada`, veiculo);
  }

  saida(movimentoId: string): Observable<any> {
    return this.http.put(`${this.API}/saida/${movimentoId}`, {});
  }

  list(): Observable<any> {
    return this.http.get(`${this.API}/findAll`);
  }

  pageList(page: number, size: number): Observable<any> {
    return this.http.get(`${this.API}?page=${page}&size=${size}`);
  }

  getMovimentoByVeiculoId(id: string): Observable<Movimento> {
    return this.http.get<Movimento>(`${this.API}/veiculo-id/${id}`);
  }
}

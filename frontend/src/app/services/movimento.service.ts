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

  private readonly API = `${environment.API}movimentos`;

  constructor(private http: HttpClient) {
  }

  entrada(veiculo: Veiculo): Observable<any> {
    return this.http.post(`${this.API}/entrada`, veiculo);
  }

  saida(movimentoId: string): Observable<any> {
    return this.http.put(`${this.API}/saida/${movimentoId}`, {});
  }

  list(): Observable<Movimento[]> {
    return this.http.get<Movimento[]>(`${this.API}`);
  }

  getMovimentoByVeiculoId(id: string): Observable<Movimento> {
    return this.http.get<Movimento>(`${this.API}/veiculo-id/${id}`);
  }

  filtroPorData(data: string): Observable<Movimento[]> {
    return this.http.get<Movimento[]>(`${this.API}/data?from=${data}`)
  }
}

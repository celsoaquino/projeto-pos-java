import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {Veiculo} from "../models/veiculo";

@Injectable({
  providedIn: 'root'
})
export class MovimentoService {

  baseUrl = 'http://localhost:8080/entrada/'

  constructor(private http: HttpClient) { }



  entrada(veiculo: Veiculo): Observable<any> {
    return this.http.post(this.baseUrl,  veiculo);
  }
}

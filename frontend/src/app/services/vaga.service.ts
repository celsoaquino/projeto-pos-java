import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {environment} from "../../environments/environment";

@Injectable({
  providedIn: 'root'
})
export class VagaService {

   private readonly API = `${environment.API}vagas`;

  constructor(private http: HttpClient) { }

  list(): Observable<any>{
    return this.http.get(this.API);
  }

  create(qtd: number): Observable<any> {
    return this.http.get(`${this.API}/${qtd}`)
  }

  delete(id: number): Observable<any> {
    return this.http.delete(`${this.API}/${id}`)
  }
}

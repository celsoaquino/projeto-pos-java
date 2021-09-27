import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";

@Injectable({
  providedIn: 'root'
})
export class VagaService {

   baseUrl = "http://localhost:8080/vagas";

  constructor(private http: HttpClient) { }

  list(): Observable<any>{
    return this.http.get(this.baseUrl);
  }

  create(qtd: number): Observable<any> {
    return this.http.get(`${this.baseUrl}/${qtd}`)
  }

  delete(id: number): Observable<any> {
    return this.http.delete(`${this.baseUrl}/${id}`)
  }
}

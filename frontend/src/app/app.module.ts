import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { NavbarComponent } from './components/navbar/navbar.component';
import { VagasComponent } from './components/vagas/vagas-list/vagas.component';
import { HttpClientModule} from "@angular/common/http";
import { VagasFormComponent } from './components/vagas/vagas-form/vagas-form.component';
import {FormsModule, ReactiveFormsModule} from "@angular/forms";
import { EntradaComponent } from './components/movimento/entrada/entrada.component';
import {NgPipesModule} from "ngx-pipes";
import { SaidaComponent } from './components/movimento/saida/saida.component';
import { ListComponent } from './components/movimento/list/list.component';


@NgModule({
  declarations: [
    AppComponent,
    NavbarComponent,
    VagasComponent,
    VagasFormComponent,
    EntradaComponent,
    SaidaComponent,
    ListComponent,      ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule,
    ReactiveFormsModule,
    NgPipesModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }

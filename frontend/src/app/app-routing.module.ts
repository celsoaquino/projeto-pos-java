import {NgModule} from '@angular/core';
import {RouterModule, Routes} from '@angular/router';
import {VagasComponent} from "./components/vagas/vagas-list/vagas.component";
import {VagasFormComponent} from "./components/vagas/vagas-form/vagas-form.component";
import {ListComponent} from "./components/movimento/list/list.component";

const routes: Routes = [
  { path: 'home', component: VagasComponent},
  { path: 'vagas', component: VagasFormComponent},
  { path: 'movimento', component: ListComponent},
  { path: '', redirectTo: 'home', pathMatch: 'full'}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }

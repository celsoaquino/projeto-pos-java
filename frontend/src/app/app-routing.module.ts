import {NgModule} from '@angular/core';
import {RouterModule, Routes} from '@angular/router';
import {VagasComponent} from "./components/vagas/vagas-list/vagas.component";
import {VagasFormComponent} from "./components/vagas/vagas-form/vagas-form.component";

const routes: Routes = [
  { path: '', component: VagasComponent},
  {path: 'vagas', component: VagasFormComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }

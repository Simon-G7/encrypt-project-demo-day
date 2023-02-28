import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { DeleteComponent } from './endpoints/delete/delete.component';
import { GetAllComponent } from './endpoints/get-all/get-all.component';
import { GetOneComponent } from './endpoints/get-one/get-one.component';
import { InsertComponent } from './endpoints/insert/insert.component';
import { UpdateComponent } from './endpoints/update/update.component';
import { HomeComponent } from './home/home.component';
import { LoginComponent } from './login/login.component';

const routes: Routes = [
  { path: '', pathMatch: 'full', redirectTo: 'home'},
  { path: 'home', component: HomeComponent},
  { path: 'login', component: LoginComponent},
  { path: 'restApi', component: GetAllComponent},
  { path: 'dataRecord', component: GetOneComponent},
  { path: 'ist', component: InsertComponent},
  { path: 'upt', component: UpdateComponent},
  { path: 'dlt', component: DeleteComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }

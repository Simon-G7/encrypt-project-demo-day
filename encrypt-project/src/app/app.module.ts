import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HomeComponent } from './home/home.component';
import { LoginComponent } from './login/login.component';
import { GetOneComponent } from './endpoints/get-one/get-one.component';
import { InsertComponent } from './endpoints/insert/insert.component';
import { GetAllComponent } from './endpoints/get-all/get-all.component';
import { DeleteComponent } from './endpoints/delete/delete.component';
import { UpdateComponent } from './endpoints/update/update.component';
import { FormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';
import { ApiService } from './services/api.service';

@NgModule({
  declarations: [
    AppComponent,
    HomeComponent,
    LoginComponent,
    GetOneComponent,
    InsertComponent,
    GetAllComponent,
    DeleteComponent,
    UpdateComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule
  ],
  providers: [ApiService],
  bootstrap: [AppComponent]
})
export class AppModule { }

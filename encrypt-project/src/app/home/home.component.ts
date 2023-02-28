import { HttpClient } from '@angular/common/http';
import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { ApiService } from '../services/api.service';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent {

  title = 'Demo';
  private url: string = "http://localhost:8087/encryption"

  constructor(private app: ApiService, private http: HttpClient, private router : Router) {
  }

  authenticated() { return this.app.authenticated; }

  getAdmin(){
    if(this.app.discoverRol()=='simon'){
      return true;
    }else{
      return false;
    }
  }

  doGetAll(){
    this.router.navigate(["/restApi"]);
  }

  doGetOne(){
    this.router.navigate(["/dataRecord"]);
  }

  doInsert(){
    this.router.navigate(["/ist"]);
  }

  doUpdate(){
    this.router.navigate(["/upt"]);
  }

  doDelete(){
    this.router.navigate(["/dlt"]);
  }
}

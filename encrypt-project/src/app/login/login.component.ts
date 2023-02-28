import { HttpClient } from '@angular/common/http';
import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { ApiService } from '../services/api.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent {

  credentials = {username: '', password: ''};
  error : boolean = false ;
  constructor(private app: ApiService, private http: HttpClient, private router: Router) {
  }

  login() {
    this.app.authenticate(this.credentials, () => {
        this.router.navigateByUrl('/home');
    });
    setTimeout(() =>{
      this.failed()
    }, 1000);

  }

  failed(){
    if(this.app.authenticated){
      this.error=false
    }else{
    this.error=true
    }
  }
}

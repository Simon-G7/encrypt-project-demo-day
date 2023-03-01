import { HttpClient } from '@angular/common/http';
import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { finalize } from 'rxjs';
import { ApiService } from './services/api.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'DemoProject';
  greeting = {'id': 'XXX', 'content': 'Hello World'};
  constructor(private app: ApiService, private http: HttpClient, private router: Router) {
    this.app.authenticate(undefined, undefined);
  }
  logout() {  
    this.http.post('logout', {}).pipe(finalize (() => {
        this.app.authenticated = false;
        this.router.navigateByUrl('/login');
    })).subscribe();
  }}

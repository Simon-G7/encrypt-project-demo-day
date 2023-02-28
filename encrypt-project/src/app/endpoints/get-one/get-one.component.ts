import { Component } from '@angular/core';
import { ApiService } from 'src/app/services/api.service';

@Component({
  selector: 'app-get-one',
  templateUrl: './get-one.component.html',
  styleUrls: ['./get-one.component.css']
})
export class GetOneComponent {

  password: any;
  id!: number;
  secret :any;

  constructor(private app: ApiService){}

  doGetOne(){
    let resp = this.app.getOne(this.id, this.password);
    resp.subscribe(data=>{
      this.secret=data
    })
  }

}

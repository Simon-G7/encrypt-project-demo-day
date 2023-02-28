import { Component } from '@angular/core';
import { ApiService } from 'src/app/services/api.service';

@Component({
  selector: 'app-insert',
  templateUrl: './insert.component.html',
  styleUrls: ['./insert.component.css']
})
export class InsertComponent {

  password: any;
  name :any;
  numero :any;
  secret :any;
  result :any;

  constructor(private app: ApiService){}

  doInsert(){
    let resp = this.app.insert(this.name, this.numero, this.secret, this.password);
    resp.subscribe(data=>{
      console.log(data)
      this.result=data
    })
  }

  inserted(){
    if(this.result){
      return true
    }else{
      return false
    }
  }
}

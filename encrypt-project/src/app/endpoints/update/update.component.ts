import { Component } from '@angular/core';
import { ApiService } from 'src/app/services/api.service';

@Component({
  selector: 'app-update',
  templateUrl: './update.component.html',
  styleUrls: ['./update.component.css']
})
export class UpdateComponent {

  password: any;
  name :any;
  numero :any;
  secret :any;
  result :any;
  id :any;

  constructor(private app: ApiService){}

  doUpdate(){
    let resp = this.app.update(this.name, this.numero, this.secret, this.password , this.id);
    resp.subscribe(data=>{
      console.log(data)
      this.result=data
    })
  }

  updated(){
    if(this.result){
      return true
    }else{
      return false
    }
  }

}

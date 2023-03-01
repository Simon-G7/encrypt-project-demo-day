import { Component } from '@angular/core';
import { ApiService } from 'src/app/services/api.service';

@Component({
  selector: 'app-delete',
  templateUrl: './delete.component.html',
  styleUrls: ['./delete.component.css']
})
export class DeleteComponent {

   password: any;
  id!: number;
  secret :any;

  constructor(private app: ApiService){}

  doDelete(){
    let resp = this.app.deleteOne(this.id);
    resp.subscribe(data=>{
      console.log(data)
      this.secret=data
    })
  }

  deleted(){
    if(this.secret){
      return true
    }else{
      return false
    }
  }

}

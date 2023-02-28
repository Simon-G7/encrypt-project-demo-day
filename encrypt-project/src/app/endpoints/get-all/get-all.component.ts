import { Component } from '@angular/core';
import { ApiService } from 'src/app/services/api.service';

@Component({
  selector: 'app-get-all',
  templateUrl: './get-all.component.html',
  styleUrls: ['./get-all.component.css']
})
export class GetAllComponent {

  secrets :any;

  constructor(private app: ApiService){}

  doGetAll(){
    let resp = this.app.getAll();
    resp.subscribe((data: any)=>{
      console.log(data.information_list)
      this.secrets=data.information_list
    })
  }

}

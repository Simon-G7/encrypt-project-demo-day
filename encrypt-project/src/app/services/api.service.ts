import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class ApiService {

  private url: string = "http://localhost:8087/encryption"
  private clientRol : string | undefined;
  private headers : any;
  private headers2 = new HttpHeaders()

  private user : any ;
  private userPassword : any;

  authenticated = false;

  constructor(private http: HttpClient) {
  }

  authenticate(credentials:any, callback:any) {

        if(credentials){
          this.user = credentials.username;
          this.userPassword = credentials.password;
        }
        this.headers = new HttpHeaders(credentials ? {
            Authorization : 'Basic ' + btoa(this.user+ ':' + this.userPassword)
        } : {});
        
        this.http.get(this.url+'/user', {headers: this.headers}).subscribe(response => {
            if (response['name']) {
              console.log(response['name']);
              this.clientRol=response['name'];
              this.authenticated = true;
            } else {
              this.authenticated = false;
            }
            return callback && callback();
        });
    }

    discoverRol(){
        return this.clientRol;
    }

    getAll(){
      return this.http.get(this.url, {headers: this.headers});
    }

    getOne(id: number , pass : string ){
      let headers2 = new HttpHeaders()
 
      headers2=headers2.append('password', pass)
      headers2=headers2.append('Authorization', 'Basic ' + btoa(this.user + ':' + this.userPassword))

      return this.http.get(`${this.url}/${id}`, {headers: headers2});
    }

    insert(name: string , description: number , secret: string , pass : string ){
      let headers2 = new HttpHeaders()
 
      headers2=headers2.append('password', pass)
      headers2=headers2.append('Authorization', 'Basic ' + btoa(this.user + ':' + this.userPassword))

      return this.http.post<any>(this.url,{"data":{"value1":name, "value2":description, "value3":secret}} ,{headers: headers2});
    }

    update(name: string , description: number , secret: string , pass : string , id: number ){
      let headers2 = new HttpHeaders()
 
      headers2=headers2.append('password', pass)
      headers2=headers2.append('Authorization', 'Basic ' + btoa(this.user + ':' + this.userPassword))

      return this.http.put<any>(`${this.url}/${id}`,{"data":{"value1":name, "value2":description, "value3":secret}} ,{headers: headers2});
    }

    deleteOne(id: number ){
      let headers2 = new HttpHeaders()
 
      headers2=headers2.append('Authorization', 'Basic ' + btoa(this.user + ':' + this.userPassword))

      return this.http.delete(`${this.url}/${id}`, {headers: headers2});
    }
}

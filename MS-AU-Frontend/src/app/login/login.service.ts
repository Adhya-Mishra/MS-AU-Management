import { Injectable } from '@angular/core';
import { HttpClient,  HttpHeaders } from "@angular/common/http";
import { Router } from '@angular/router'
import { environment } from 'src/environments/environment';

@Injectable({
  providedIn: 'root'
})
export class LoginService {
  
  constructor(private httpClient: HttpClient, private Router:Router) { }

  public login(data: any){
    
  }

}
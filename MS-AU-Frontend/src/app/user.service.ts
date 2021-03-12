import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { environment } from 'src/environments/environment';

@Injectable({
  providedIn: 'root'
})
export class UserService {
  private apiServer = environment.baseUrl;
  constructor(private httpClient: HttpClient) {}

  public getAllUser() {
      return this.httpClient.get(this.apiServer + '/user/showAll');
  }

  public getCurrentUser() {
      return this.httpClient.get(this.apiServer + '/user/getCurrentUser');
  }
}

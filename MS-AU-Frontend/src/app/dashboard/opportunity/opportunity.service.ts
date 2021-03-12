import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { environment } from 'src/environments/environment';

@Injectable({
  providedIn: 'root'
})
export class OpportunityService {
  private apiServer = environment.baseUrl;
  constructor(private httpClient: HttpClient) {}

  public getAllOpp() {
      return this.httpClient.get(this.apiServer + '/opportunity/showAll');
  }

  public del(id: string | number) {
      console.log(localStorage.getItem("Email"));
      return this.httpClient.get(this.apiServer + '/opportunity/delete/' + id);
  }

  public addOpp(Opportunity: { endDate: string | number | Date; }) {

      let httpHeaders = new HttpHeaders({
          'Content-Type': 'application/json',
          'email':'adhyamishra268@gmail.com'
      });

      let options = {
          headers: httpHeaders
      };
      const body = Opportunity;
     
      return this.httpClient.post(this.apiServer + '/opportunity/create', body, options);
  }

  public editOpp(Opportunity: { oppid: string; }) {

      let httpHeaders = new HttpHeaders({
          'Content-Type': 'application/json',
          'Cache-Control': 'no-cache',
          'email':'adhyamishra268@gmail.com'
      });
      let options = {
          headers: httpHeaders
      };
      const headers = new HttpHeaders().set('Content-Type', 'application/json; charset=utf-8');
      const body = Opportunity
      return this.httpClient.post(this.apiServer + '/opportunity/edit/' + Opportunity.oppid, body, options);

  }

}

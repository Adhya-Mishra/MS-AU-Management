import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { environment } from 'src/environments/environment';

@Injectable({
  providedIn: 'root'
})
export class TrendService {
  private apiServer = environment.baseUrl;

  constructor(private httpClient: HttpClient) {}
  public getLabels(label:String) {
    return this.httpClient.get(this.apiServer + '/trend/' + label);
}

  public getLabelsPie(label:String) {
      return this.httpClient.get(this.apiServer + '/trend/' + label);
  }

}

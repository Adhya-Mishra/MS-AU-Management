import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { environment } from 'src/environments/environment';

@Injectable({
  providedIn: 'root'
})
export class SearchService {
  private apiServer = environment.baseUrl;

  constructor(private httpClient: HttpClient) {}

  public search(col: String, place: String) {
      return this.httpClient.get(this.apiServer + '/opportunity/search/' + col + '/' + place);
  }

}

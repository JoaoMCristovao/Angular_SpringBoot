import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { map } from 'rxjs/operators';
import { PanelComponent } from '../components/panel/panel.component';


@Injectable({
  providedIn: 'root'
})
export class ApiService {

  private apiURL = 'http://localhost:8080/api/fibonacci';

  constructor(private http: HttpClient) { }

  //GET request to fetch single value
  getFibonacciValue(n: number): Observable<number> {
    return this.http.get<any>(`${this.apiURL}/${n}`).pipe(
      map(response => response.output)
    )
  }
}

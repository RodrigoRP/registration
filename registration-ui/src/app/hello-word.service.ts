import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Message } from './message';

@Injectable({
  providedIn: 'root'
})
export class HelloWordService {

  constructor(private http: HttpClient) { }

  helloWorldService() {
    const headers = new HttpHeaders({ Authorization: 'Basic ' + btoa('admin' + ':' + '123') });
    return this.http.get<Message>('http://localhost:8088/api/v1/greeting', {headers});
  }
}

import { Injectable } from '@angular/core';
import {HttpClient, HttpHeaders} from "@angular/common/http";
import {Observable} from "rxjs";

const API_URL = 'http://localhost:8081/api/';
const httpOptions = {headers: new HttpHeaders({ 'Content-Type': 'application/json' })};
@Injectable({
  providedIn: 'root'
})
export class ArticleService {

  constructor(private http: HttpClient) { }

  saveArticle(article): Observable<any> {
    return this.http.post(API_URL + 'article',article, httpOptions);
  }

  getAllArticle(): Observable<any> {
    return this.http.get(API_URL + 'articles');
  }
}

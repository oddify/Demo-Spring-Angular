import { Injectable } from '@angular/core';
import {HttpClient, HttpErrorResponse} from "@angular/common/http";
import {IProduct} from "../product";
import {catchError, Observable, throwError} from "rxjs";

@Injectable({
  providedIn: 'root'
})
export class ProductService {

  constructor(private http: HttpClient) {
  }

  private _url: string = "http://localhost:4727/products";

  // private _url : string = "/assets/data/products.json";
  getProducts(): Observable<IProduct[]> {
    console.log("data fetched");
    return this.http.get<IProduct[]>(this._url).pipe(catchError(this.errorHandler));

  }

  // errorHandler(error : HttpErrorResponse){
  //   return throwError(error.message || "Server Error");
  // }
  private errorHandler(err: HttpErrorResponse): Observable<never> {
    return throwError(() => err);
  }

}


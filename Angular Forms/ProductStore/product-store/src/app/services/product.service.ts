import { Injectable } from '@angular/core';
import {HttpClient, HttpErrorResponse} from "@angular/common/http";
import {catchError, Observable, throwError} from "rxjs";
import {IProduct} from "../models/product";

@Injectable({
  providedIn: 'root'
})
export class ProductService {
  url="http://localhost:4727/products";

  constructor(private _http : HttpClient) { }

  postProduct(product: JSON){
    return this._http.post(this.url,product);
  }

  getProducts():Observable<IProduct[]>{
    //   console.log("data fetched");
    return this._http.get<IProduct[]>(this.url).pipe(catchError(this.errorHandler));
  }
  // getProducts(): Observable<IProduct[]> {
  //   console.log("data fetched");
  //   return this.http.get<IProduct[]>(this._url).pipe(catchError(this.errorHandler));
  //
  // }

  // Fetch product by ID
  getProductById(id: number): Observable<any> {
    return this._http.get<any>(`${this.url}/${id}`);
  }

  delete(id : number):Observable<any> {
    const deleteUrl = this.url+'/'+id;
    console.log(deleteUrl);
    return this._http.delete(deleteUrl).pipe(catchError(this.errorHandler)) ;
  }

  errorHandler(error : HttpErrorResponse): Observable<never>{
    return throwError(()=>error);
  }


}

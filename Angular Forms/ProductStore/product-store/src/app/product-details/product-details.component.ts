import { Component } from '@angular/core';
import {IProduct} from "../models/product";
import {ProductService} from "../services/product.service";
import {CurrencyPipe} from "@angular/common";
import {CommonModule} from "@angular/common";
import {ActivatedRoute, Router, RouterLink} from "@angular/router";

@Component({
  selector: 'app-product-details',
  standalone: true,
  imports: [
    CurrencyPipe, CommonModule, RouterLink
  ],
  templateUrl: './product-details.component.html',
  styleUrl: './product-details.component.css'

})
export class ProductDetailsComponent {
  products: IProduct[]=[];
  errorMsg: string='';
  private successMsg: string = '';

  constructor(private productService : ProductService,
              private router :Router,
              private route :ActivatedRoute) {
  }

  ngOnInit() {
    this.loadData();
  }

  loadData(){
    this.productService.getProducts().subscribe(
      data=> this.products = data,
      error => this.errorMsg= error.message);
  }

  onDelete(id : number){
    this.productService.delete(id).subscribe(
      success=> {this.successMsg=success.message;
                        this.loadData();
                      },
      error => this.errorMsg= error.message);
  }

  onEdit(id :number){
    this.router.navigate(['./add/',{id:id}],{relativeTo:this.route});
  }
}

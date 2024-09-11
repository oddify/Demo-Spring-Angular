import {Component} from '@angular/core';
import {ProductService} from "../services/product.service";

@Component({
  selector: 'app-product-details',
  templateUrl: './product-details.component.html',
  styleUrl: './product-details.component.css'
})
export class ProductDetailsComponent {

  public products: any[];
  public errorMsg: any="error";


  constructor(private _productService: ProductService) {
    this.products = [];
  }

  ngOnInit() {
    this._productService.getProducts()
      .subscribe(data => this.products = data
        , error => this.errorMsg = error.message);
  }
}

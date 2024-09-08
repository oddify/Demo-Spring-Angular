import {Component} from '@angular/core';
import {ProductService} from "../services/product.service";


@Component({
  selector: 'app-product-list',
  template: `
    Product list

    <h2>{{errorMsg}} </h2>
    <table [ngClass]="messageClasses">
      <thead >
        <th>Id</th>
        <th> Name </th>
      </thead>
      <tbody >
        <tr *ngFor="let product of products">
          <th scope="row" class="text-center">{{product.id}}</th>
<!--          <td>{{product.id}}</td>-->
          <td>{{product.name}}</td>
        </tr>
      </tbody>
    </table>
    Angular heavily relies on RxJS for handling asynchronous operations,
    such as handling HTTP requests, event handling, and managing state changes.
  `,
  styles: [`
    table {
      width: 100%;
    }

    tr:nth-child(even) {
      background-color: #773838;
    }
  `]
})
export class ProductListComponent {
  public products : any[];
  public errorMsg: any;

  messageClasses: any = {
    'table': true,
    'table-striped': true,
    'table-bordered': true
  };

  constructor(private _productService: ProductService) {
    this.products = [];
  }

  ngOnInit() {
    console.log(" fetch triggeredl");
   this._productService.getProducts().pipe()
      .subscribe(data => this.products = data
                  , error => this.errorMsg = error.message);
  }
}

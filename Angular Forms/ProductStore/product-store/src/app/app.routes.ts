import { Routes } from '@angular/router';
import {ProductDetailsComponent} from "./product-details/product-details.component";
import {ProductFormComponent} from "./product-form/product-form.component";

export const routes: Routes = [
  {path: '', redirectTo: '/products', pathMatch: "full"},
  {path: 'products',component: ProductDetailsComponent},
  {path: 'products/add',component: ProductFormComponent},
  {path: '**', component: ProductDetailsComponent}
];

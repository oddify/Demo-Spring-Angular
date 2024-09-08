import {NgModule} from '@angular/core';
import {RouterModule, Routes} from '@angular/router';
import {DepartmentListComponent} from "./department-list/department-list.component";
import {EmployeeListComponent} from "./employee-list/employee-list.component";
import {PageNotFoundComponent} from "./page-not-found/page-not-found.component";
import {ProductListComponent} from "./product-list/product-list.component";
import {ProductDetailsComponent} from "./product-details/product-details.component";
import {DepartmentDetailComponent} from "./department-detail/department-detail.component";
import {DepartmentOverviewComponent} from "./department-overview/department-overview.component";
import {DepartmentContactComponent} from "./department-contact/department-contact.component";

const routes: Routes = [
  {path: '', redirectTo: '/departments', pathMatch: "full"},
  {path: 'departments', component: DepartmentListComponent},
  {path: 'employees', component: EmployeeListComponent},
  {path: 'products', component: ProductListComponent},
  {path: 'product/details', component: ProductDetailsComponent},
  {
    path: 'departments/:id',
    component: DepartmentDetailComponent,
    children: [
      {path: 'overview',component:DepartmentOverviewComponent},
      {path: 'contact',component:DepartmentContactComponent}
    ]
  },
  {path: '**', component: PageNotFoundComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule {
}

export const routingComponents =
  [
    DepartmentListComponent,
    EmployeeListComponent,
    PageNotFoundComponent,
    ProductDetailsComponent,
    DepartmentDetailComponent
  ];

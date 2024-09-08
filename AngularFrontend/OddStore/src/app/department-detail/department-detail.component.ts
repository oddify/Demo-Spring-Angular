import {Component} from '@angular/core';
import {ActivatedRoute, ParamMap, Router} from "@angular/router";
import {relative} from "@angular/compiler-cli";

@Component({
  selector: 'app-department-detail',
  template: `
    <h3> The department id = {{departmentId}}</h3>
    <p>
        <button class="btn btn-dark" (click)="showOverview()">Overview</button>
        <button  class="btn btn-dark" (click)="showContact()">Contact</button>
    </p>
    <router-outlet></router-outlet>
    <p>
      <button (click) ="goPrevious()"  class="badge bg-dark">Previous</button>
      <button (click) ="goNext()" class="badge bg-dark">Next </button>
      <button (click)="goToDepartment()" class="badge bg-dark">Back</button>
    </p>
  `,
  styles: ``
})
export class DepartmentDetailComponent {
  protected departmentId : number =-1;
  constructor( private  route: ActivatedRoute, private  router: Router) {
    // let id = parseInt( <string>this.route.snapshot.paramMap.get("id"));
    this.route.paramMap.subscribe((params: ParamMap )=> {
      this.departmentId= parseInt(<string>params.get('id'));
    } )

  }

  goNext() {
    this.router.navigate(['/departments',this.departmentId+1])
  }

  goPrevious() {
    if(this.departmentId >1)
    this.router.navigate(['./',this.departmentId-1])
  }

  goToDepartment(){
    // Absolute
    // this.router.navigate(['/departments',{id:this.departmentId, test: 'testvalue'}]);
    // Relative
    this.router.navigate(['../',{id:this.departmentId}],{relativeTo:this.route});
  }

  showOverview(){
    this.router.navigate(['overview'],{relativeTo:this.route});
  }

  showContact(){
    this.router.navigate(['contact'],{relativeTo:this.route});
  }
}

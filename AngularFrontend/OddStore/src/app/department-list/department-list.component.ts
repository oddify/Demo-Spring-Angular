import {Component} from '@angular/core';
import {Router,ActivatedRoute,ParamMap} from "@angular/router";

@Component({
  selector: 'app-department-list',
  template: `
    <ul>
      <li (click)="onSelect(department)" *ngFor="let department of departments">
        <!--        <a class="badge bg-success"-->
        <!--           routerLink="/departments/{{department.id}}">-->
        <!--          {{ department.name }}-->
        <!--        </a>-->

        <span class="badge bg-success" [class.bg-black]="isSelected(department)">
          {{ department.id }}</span> <span class="badge bg-dark">{{ department.name }}</span>

      </li>

    </ul>
  `,
  styles: ``
})

export class DepartmentListComponent {
  public departments = [
    {id: 1, name: "HR"},
    {id: 2, name: "IT"},
    {id: 3, name: "Finance"},
    {id: 4, name: "Admin"},
    {id: 5, name: "Sales"},
  ]

  public selectedDepartment:number=-1;
  constructor(private  router : Router,private route :ActivatedRoute) {
    route.paramMap.subscribe((params:ParamMap)  =>{
       this.selectedDepartment = parseInt(<string>params.get("id"));
    })
  }


  onSelect(department:any){
      // Absolute path
      // this.router.navigate(['/departments',department.id]);

      // Relative Path
      this.router.navigate([department.id],{relativeTo:this.route});
  }

  isSelected(department:any) {
    return this.selectedDepartment == department.id;

  }
}

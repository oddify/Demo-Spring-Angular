import { Component } from '@angular/core';

@Component({
  selector: 'app-demo-pipes',
  template: `
    <hr>
    <h4>Angular Pipes</h4>
    <hr>

    <p>Angular Pipes are used to transform data on a template. Pipes are used to format data before displaying it in the view.</p>
    <hr>

    <h5>{{name | lowercase}}</h5>
    <h5>{{name | uppercase}}</h5>
    <h5>{{name | titlecase}}</h5>
    <h5>{{name | slice:3}}</h5>
    <h5>{{100 | currency : 'INR'}}</h5>
    <h5>{{date | date: 'short'}}</h5>
  `,
  styleUrl: './demo-pipes.component.css'
})
export class DemoPipesComponent {
  public  name = "Welcome To ODDFIY";
  public date = new Date();
}

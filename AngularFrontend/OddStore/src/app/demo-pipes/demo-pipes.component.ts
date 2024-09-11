import { Component } from '@angular/core';
import {types} from "sass";

@Component({
  selector: 'app-demo-pipes',
  template: `
    <hr>
    <h4>Angular Pipes</h4>
    <hr>

    <p>Angular Pipes are used to transform data on a template.
      Pipes are used to format data before displaying it in the view.</p>
    <hr>

    <h5>{{ name | lowercase }}</h5>
    <h5>{{ name | uppercase }}</h5>
    <h5>{{ name | titlecase }}</h5>
    <h5>{{ name | slice:3 }}</h5>
    <h5>{{ 100 | currency : 'INR' }}</h5>
    <h5>{{ String(100) | uppercase }}</h5>
    <h5>{{ date | date: 'short' }}</h5>

    <h3>Show date formats</h3>
    <input [(ngModel)]="showDateFormats"  type="checkbox" >
    <div *ngIf="showDateFormats;" >
      <h3>Predefined Date Formats</h3>
      <p><strong>short:</strong> {{ date | date: 'short' }}</p>
      <p><strong>medium:</strong> {{ date | date: 'medium' }}</p>
      <p><strong>long:</strong> {{ date | date: 'long' }}</p>
      <p><strong>full:</strong> {{ date | date: 'full' }}</p>

      <h3>Custom Date Formats</h3>
      <p><strong>yyyy-MM-dd:</strong> {{ date | date: 'yyyy-MM-dd' }}</p>
      <p><strong>dd-MM-yyyy:</strong> {{ date | date: 'dd-MM-yyyy' }}</p>
      <p><strong>MMMM d, y:</strong> {{ date | date: 'MMMM d, y' }}</p>
      <p><strong>EEE, MMM d, y:</strong> {{ date | date: 'EEE, MMM d, y' }}</p>
      <p><strong>HH:mm:ss (24-hour time):</strong> {{ date | date: 'HH:mm:ss' }}</p>
      <p><strong>h:mm a (12-hour time):</strong> {{ date | date: 'h:mm a' }}</p>
      <p><strong>dd MMMM y, h:mm:ss a:</strong> {{ date | date: 'dd MMMM y, h:mm:ss a' }}</p>
      <p><strong>dd/MM/yyyy, EEEE:</strong> {{ date | date: 'dd/MM/yyyy, EEEE' }}</p>
      <p><strong>MMMM y, EEEE:</strong> {{ date | date: 'MMMM y, EEEE' }}</p>
    </div>
  `,
  styles: [``]
})
export class DemoPipesComponent {
  public showDateFormats : boolean= false;
  public  name = "Welcome To ODDFIY";
  public date = new Date();
  protected readonly types = types;
  protected readonly String = String;
}

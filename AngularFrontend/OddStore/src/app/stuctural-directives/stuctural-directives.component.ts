import { Component } from '@angular/core';

@Component({
  selector: 'app-stuctural-directives',
  template: `
    <hr>Stuctural directives<hr>
    <h4> *ngIf </h4>
    <hr>
    <input type="checkbox" [(ngModel)]="isdisplay"> basics of angular
    <!--    writting if else multiple-->

    <div *ngIf="isdisplay; then thenBlock; else elseBlock"></div>
    <ng-template #thenBlock>
      <h2>
        <div app-home>
        </div>
        Structural directive
      </h2>
    </ng-template>

    <ng-template #elseBlock>
      <h2>
        this will be hidden
      </h2>
    </ng-template>

    <input type="checkbox" [(ngModel)]="isdisplay2"> event binding
    <h2 *ngIf="isdisplay2">
      <app-test></app-test>
    </h2>

    <br>

    <hr>
    <input type="checkbox" [(ngModel)]="isdisplay3">
     *ngFor
    <div *ngIf="isdisplay3">

      <div *ngFor = "let color of colors; index as i; first as f ; odd as o" >
          <li>
           {{i}}  {{color}} {{f}} {{o}}
          </li>
  <!--      {{color}}-->
      </div>
    </div>

        <br>
    <hr>
<!--    <input type="checkbox" [(ngModel)]="isdisplay4"> component interaction-->
<!--    <div *ngIf="isdisplay4">-->

<!--    </div>-->
  `,
  styleUrl: './stuctural-directives.component.css'
})
export class StucturalDirectivesComponent {
  public isdisplay = false;
  public isdisplay2 = false;
  public isdisplay3 = false;
  public isdisplay4 = false;

  colors = ["orange", "red",'blue','Green'];
}

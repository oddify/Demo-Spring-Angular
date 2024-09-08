import { Component } from '@angular/core';

@Component({
  selector: 'app-test',
  template: `<hr>Event bindings<hr>
    <h2> Welcome to {{name}}</h2>
    <button (click)=" onClick($event)"> greet</button>
   <br> {{greeting}}

  <button (click)="greeting = 'welcome omkar'"> greet</button>
<br><br>

  <input #myInput >  <button (click)=onButtonClick(myInput)> greet</button>
  <hr>2 way bindings<hr>

  <input [(ngModel)] = "twoWay" type = "text">
  <br>
  {{twoWay}}
  <br> <br>
  text appears above

  `,
  styles: [`

  `]
})
export class TestComponent {
  public name = "event binding";
  public greeting = "";

  public twoWay="";
  onClick(event : Event) {

    console.log(event );
    this.greeting= event.type;
  }
  onButtonClick(s : HTMLElement ) {

    console.log( s );
  }

}

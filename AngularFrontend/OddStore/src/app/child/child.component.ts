import {Component, EventEmitter, Input, Output} from '@angular/core';

@Component({
  selector: 'app-child',
  template: `
    <hr>
    Component interaction
    <hr>
    Displaying data from parent
    <h2>
      {{name}}
    </h2>
    <input type="text" [(ngModel)]="data">
    <button (click)="fireEvent()">Send data to parent</button>
  `,
  styleUrl: './child.component.css'
})
export class ChildComponent {
  public data = "";

  @Input("parentData") public name = "";

  @Output() public childEvent = new EventEmitter();

  fireEvent(){
    console.log();
    this.childEvent.emit(this.data);
  }

}

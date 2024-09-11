import { Component } from '@angular/core';


//  This component gives demo of angular styling and basic ui components
@Component({
  selector: '[app-home]',
  template: `
    <H1>Angular Interpolation</H1>
    <div> Welcome {{ name }}</div>
    <h2> {{ 2 + 2 }}</h2>
    <h2 class=orange-text>{{ "Welcome " + name }}</h2>
    <h2> {{ name.length }}</h2>
    <h2> {{ name.toUpperCase() }}</h2>
    <h2> {{ name.toLowerCase() }}</h2>
    <h2>{{ greetUser() }}</h2>
    <!--    <h2> {{a=2+2}}</h2>  -->
    <!--    <h2 style="color: red" ngNonBindable>&lt;h2&gt;{{a=2+2}}&lt;/h2&gt;  Parser Error: Bindings cannot contain assignments </h2>-->
    <h2>{{ window.location.href }}</h2>
    <h2>{{ siteUrl }}</h2>

    <!--   Property binding-->
    <!--   <input type="text" value="Omkar"> <br><br>-->
    <!--   Attributes and properties are not the same-->
    <!--   Attributes - HTML -->
    <!--   properties are defined by DOM (Document object model)-->
    <!--   Attributes initialize DOM properties and then are done Attribute values cannot be changed once they are initialize-->

    <h2> Conditional class attrib</h2>
    <input [id]="myId" type="text" value="Name" (input)="enableTest()">

    <input [disabled]="isDisabled" id="test2" type="text" value="Omkar">
    <h2 class = text-success> Omkar </h2>
    <h2  [class] = "classSuccess" class="text-danger"> Oddify </h2>
    <h2 [class.text-danger]="hasError"> Omkar </h2>

    <h2 [ngClass] = "messageClasses"> messages </h2>

    <h2 [style.color]="hasError? 'red':'green'"> style binding </h2>
    <h2 [style.color]="hilightColor"> style binding 2</h2>
    <h2 [ngStyle]="titleStyles"> style binding 3 </h2>


  `,
  styles: [`
    div{ color: mediumvioletred}
    .orange-text {
      color: orange;
    }
    .text-success {
      color: green;
    }
    .text-danger {
      color: red;
    }
    .text-special {
      font-style: italic;
    }
  `]

})
export class HomeComponent {
  public  name = "Omkar Dattaraj Dali";
  public myId = "testId";
  public siteUrl = window.location.href;
  public isDisabled = true;
  public classSuccess = "text-success";
  public hasError = true;
  public isSpecial = true;

  //  style binding
  public hilightColor ="orange";

  public messageClasses = {
    "text-success":!this.hasError,
    "text-danger": this.hasError,
    "text-special": this.isSpecial
  }

  public titleStyles = {
    color:"blue",
    fontStyle:"italic"
  }

  constructor() {
  }

  greetUser(){
    return "Hello "+ this.name;
  }

  protected readonly window = window;

  enableTest() {
    const element = document.getElementById('testId') as HTMLInputElement;
    if(element && element.value.toLowerCase() == 'omkar'){
      this.isDisabled = false;
      this.hasError =this.isDisabled;
      this.hilightColor = "orange";
    }
    else{
      this.isDisabled = true;
      this.hasError =this.isDisabled;
      this.hilightColor = "skyblue";
    }

    // Update messageClasses accordingly
    this.messageClasses = {
      "text-success": !this.hasError,
      "text-danger": this.hasError,
      "text-special": this.isSpecial
    };
  }
}

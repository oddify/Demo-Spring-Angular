import { Component } from '@angular/core';
import {FormControl, FormGroup} from "@angular/forms";
@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrl: './app.component.css'
})
export class AppComponent {
  registrationFrom = new FormGroup({
    userName:new FormControl('Omkar'), // default value
    password:new FormControl(''),
    confirmPassword: new FormControl(''),
    address: new FormGroup(({
      city: new FormControl(''),
      state: new FormControl(''),
      postalCode: new FormControl('')
    }))
  });

  loadAPIData(){
    this.registrationFrom.patchValue(
      {
        userName: 'omkar',
        password: 'test',
        confirmPassword: 'test',
      }
    )

    // // Needs to sert all vallues
    //   .setValue({
    //   userName: 'omkar',
    //   password: 'test',
    //   confirmPassword: 'test',
    //   address: {
    //     city:'Rtn',
    //     state: 'State',
    //     postalCode: '123456'
    //   }
    // });
  }
}

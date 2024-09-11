import {Component, OnInit} from '@angular/core';
import {FormBuilder, Validators, FormArray, FormGroup, FormControl} from "@angular/forms";
import {forbiddenNameValidator} from "./shared/user-name.validator";
import {passwordValidator} from "./shared/passwordValidator";
import {RegistrationService} from "./registration.service";

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit {
  registrationFrom: FormGroup=new FormGroup({});
  getUsername(): FormControl {
    // const  fc =
    return this.registrationFrom.get('userName') as FormControl ;
  }

  get email(){
    return this.registrationFrom.get('email') as FormControl;
  }

  get alternateEmails(){
    return this.registrationFrom.get('alternateEmails') as FormArray;
  }

  addAlternateEmail(){
    console.log('alternateEmails:', this.alternateEmails); // Debug

    this.alternateEmails.push(this.fb.control('', Validators.required));
    console.log('alternateEmails after push:', this.alternateEmails); // Debug
  }

  onSubmit(){
    console.log(this.registrationFrom.value);
    this.registrationService.register(this.registrationFrom.value).subscribe(
      response => console.log('success'),
      error=> console.log('error')
    )
  }
  constructor(private fb: FormBuilder,private registrationService : RegistrationService) {
  }

  ngOnInit(): void {

    this.registrationFrom = this.fb.group({
      userName: ['Vishwas', [Validators.required, Validators.minLength(3), forbiddenNameValidator(/password/)]],
      email: [''],
      subscribe: [false],
      password: [''],
      confirmPassword: [''],
      address: this.fb.group({
        city: ['Rtn'],
        state: [''],
        postalCode: ['']
      },),
      alternateEmails: this.fb.array([])
    }, {validator: passwordValidator}
    );

    this.registrationFrom.get('subscribe')?.valueChanges
      .subscribe((checkedValue:boolean) => {
        const email = this.registrationFrom.get('email');

        if(checkedValue){
          email?.setValidators(Validators.required);
        }else{
          email?.setValidators(Validators.required);
        }
        email?.updateValueAndValidity();
      });
  }



  // registrationFrom = new FormGroup({
  //   userName:new FormControl('Omkar'), // default value
  //   password:new FormControl(''),
  //   confirmPassword: new FormControl(''),
  //   address: new FormGroup(({
  //     city: new FormControl(''),
  //     state: new FormControl(''),
  //     postalCode: new FormControl('')
  //   }))
  // });

  // loadAPIData(){
  //   this.registrationFrom.patchValue(
  //     {
  //       userName: 'omkar',
  //       password: 'test',
  //       confirmPassword: 'test',
  //     }
  //   )

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
  // }
  protected readonly onsubmit = onsubmit;
}

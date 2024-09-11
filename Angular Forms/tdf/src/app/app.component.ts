import { Component } from '@angular/core';
import { RouterOutlet } from '@angular/router';
import { CommonModule } from '@angular/common';
import { FormsModule, NgForm } from '@angular/forms';
import { User } from './user';
import { EnrollmentService } from './enrollment.service';


@Component({
  selector: 'app-root',
  standalone: true,
  imports: [RouterOutlet, CommonModule, FormsModule],
  templateUrl: './app.component.html',
  styleUrl: './app.component.css'
})
export class AppComponent {
  topics = ['Angular', 'React', 'Vue']
  topicHasError = true;

  userModel = new User('omkar', 'rob@test', '9890229160', '', 'morning', true);
  submitted = false;
  errorMsg= '';
  successMsg='';
  

  constructor(private _enrollmentService: EnrollmentService) { }

  validateTopic(value: string) {
    console.log(value + "" + value === 'default');
    if (value === 'default') {
      this.topicHasError = true;
    } else {
      this.topicHasError = false;
    }
  }

  onSubmit(userForm : NgForm) {
    // console.log("hello");
    // console.log("its working");
    // console.log(this.userModel);

    console.log(userForm);
    this.submitted = true;
    this._enrollmentService.enroll(this.userModel)
      .pipe().subscribe(
        data => {console.log('Success!');
                this.successMsg='Success!'
        },
        error => this.errorMsg= error.statusText
      )
  }

  clearForm(form: NgForm) {
    form.resetForm(); // Reset the form fields
    this.userModel = {
      name: '',
      email: '',
      phone: '',
      topic: '',
      timePreference: '',
      subscribe: false
    }; // Reset the model
  }
}

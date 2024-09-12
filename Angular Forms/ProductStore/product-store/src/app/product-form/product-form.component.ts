import {Component, OnInit} from '@angular/core';
import {FormBuilder, FormControl, FormGroup, FormsModule, Validators} from '@angular/forms'
import {ReactiveFormsModule} from "@angular/forms";
import {JsonPipe} from "@angular/common";
import {ProductService} from "../services/product.service";
import {ActivatedRoute,Router} from "@angular/router";

@Component({
  selector: 'app-product-form',
  standalone: true,
  templateUrl: './product-form.component.html',
  imports: [
    FormsModule, ReactiveFormsModule, JsonPipe
  ],
  styleUrl: './product-form.component.css'
})
export class ProductFormComponent implements OnInit{

  productFrom :FormGroup = new FormGroup<any>({});
  private errorMsg: string='';
  private successMsg: string='';
  private productId: number | null = null; // To store product ID if editing

  constructor(private fb :FormBuilder,
              private productService : ProductService,
              private route :ActivatedRoute,
              private router:Router) {}

  ngOnInit(): void {
    this.productFrom = this.fb.group({
      id:[''],
      name:['',Validators.required],
      description:['',Validators.required],
      price:['',Validators.required],
      quantity:['',Validators.required],
      imageUrl:['https://m.media-amazon.com/images/I/81TzOmIxEaL._AC_UY1000_.jpg',Validators.required],
      category: this.fb.group({
        name:['',Validators.required]
      })
    });
    // Check if we're editing a product by looking for a route parameter
    this.route.paramMap.subscribe(params => {
      const id = params.get('id');
      if (id) {
        this.productId = +id;
        this.loadProduct(this.productId);
      }
    });
  }

  loadProduct(id : number){
    this.productService.getProductById(id).subscribe(
      product => {
        this.productFrom.patchValue(product); // Pre-fill the form with the product data
      },
      error => {
        console.log("Failed to load product data");
        this.errorMsg = error.statusText;
      }
    );
  }

  onSubmit(){
    console.log(this.productFrom.valid);

    if(this.productFrom.valid){
      this.productService.postProduct(this.productFrom.value).subscribe(
        response=> {
          console.log("Successfully submitted");
          this.successMsg='Success!';
          this.router.navigate(['../'],{relativeTo:this.route});
        },
        error => {
          console.log("Failed");
           this.errorMsg= error.statusText
        }
      )
    }
  }

  goToDepartment(){
    // Absolute
    // this.router.navigate(['/departments',{id:this.departmentId, test: 'testvalue'}]);
    // Relative

  }

  get productname() {
    return this.productFrom.get('name') as FormControl;
  }

  get description() {
    return this.productFrom.get('description') as FormControl;
  }

  get price() {
    return this.productFrom.get('price') as FormControl;
  }


  get quantity() {
    return this.productFrom.get('quantity') as FormControl;
  }

  get imageUrl() {
    return this.productFrom.get('imageUrl') as FormControl;
  }

  get category(){
    return this.productFrom.get('category') as FormGroup;
  }

  get categoryName(){
    return this.category.get('name') as FormGroup;
  }
}


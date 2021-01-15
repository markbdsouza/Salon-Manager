import { Component, OnInit } from "@angular/core";
import {
  FormBuilder,
  FormControl,
  FormGroup,
  Validators,
} from "@angular/forms";
import { CustomerService } from "src/app/services/customer.service";

import { Customer } from "../customer";

@Component({
  selector: "app-customer-registeration",
  templateUrl: "./customer-registeration.component.html",
  styleUrls: ["./customer-registeration.component.scss"],
})
export class CustomerRegisterationComponent implements OnInit {
  customerRegisterationFormGroup: FormGroup;
  customer: Customer;

  constructor(
    private formBuilder: FormBuilder,
    private customerRegisterationService: CustomerService
  ) {}

  ngOnInit() {
    this.customerRegisterationFormGroup = this.formBuilder.group({
      firstName: new FormControl("", [
        Validators.required,
        Validators.minLength(2),
      ]),
      lastName: new FormControl("", [
        Validators.required,
        Validators.minLength(2),
      ]),
      email: new FormControl("", [
        Validators.required,
        Validators.pattern(
          "^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@[a-zA-Z0-9](?:[a-zA-Z0-9-]{0,61}[a-zA-Z0-9])?(?:.[a-zA-Z0-9](?:[a-zA-Z0-9-]{0,61}[a-zA-Z0-9])?)*$"
        ),
      ]),
      phoneNumber: new FormControl("", [
        Validators.required,
        Validators.pattern("^[0-9]"),
      ]),
    });
  }

  createContact() {
    this.customer = this.customerRegisterationFormGroup.value;
    this.customerRegisterationService.createCustomer(this.customer).subscribe(
      (res) => {
        console.log("success");
        console.log(res);
      },
      (err) => {
        console.log("ERROR" + err);
      }
    );
  }
}

import { Component, EventEmitter, OnInit, Output } from "@angular/core";
import {
  FormBuilder,
  FormControl,
  FormGroup,
  Validators,
} from "@angular/forms";
import { Router } from "@angular/router";
import { CustomerService } from "src/app/services/customer.service";

@Component({
  selector: "app-customer-phone-number-search",
  templateUrl: "./customer-phone-number-search.component.html",
  styleUrls: ["./customer-phone-number-search.component.scss"],
})
export class CustomerPhoneNumberSearchComponent implements OnInit {
  phoneNumberFormGroup: FormGroup;
  @Output() callParent = new EventEmitter();

  constructor(
    private formBuilder: FormBuilder,
    private customerService: CustomerService,
    private router: Router
  ) {}

  ngOnInit() {
    this.phoneNumberFormGroup = this.formBuilder.group({
      phoneNumber: new FormControl("", [
        Validators.required,
        Validators.minLength(5),
      ]),
    });
  }

  searchByPhoneNumber() {
    let phoneNumber = this.phoneNumberFormGroup.controls["phoneNumber"].value;
    this.customerService.findByPhoneNumber(phoneNumber).subscribe(
      (res) => {
        console.log(res);
        this.callParent.emit(res);
        this.router.navigate(["/Customer", { id: res.customerId }]);
      },
      (err) => {
        console.log(err);
      }
    );
  }
}

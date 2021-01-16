import { Component, OnInit } from "@angular/core";
import { Customer } from "./customer";

@Component({
  selector: "app-customer",
  templateUrl: "./customer.component.html",
  styleUrls: ["./customer.component.scss"],
})
export class CustomerComponent implements OnInit {
  customer: Customer;
  isCustomerInFocus: boolean;
  isRegisterDisplayed: boolean;
  constructor() {}

  ngOnInit() {
    debugger;
    this.isCustomerInFocus = false;
    this.isRegisterDisplayed = false;
  }

  getMsgFromBaby($event) {
    this.customer = $event;
    if (this.customer != null && this.customer != undefined)
      this.isCustomerInFocus = true;
    console.log("in parent");
  }

  registerClick() {
    this.isRegisterDisplayed = true;
  }
}

import { Component, Input, OnInit } from "@angular/core";
import { Customer } from "../customer";

@Component({
  selector: "app-customer-details",
  templateUrl: "./customer-details.component.html",
  styleUrls: ["./customer-details.component.scss"],
})
export class CustomerDetailsComponent implements OnInit {
  @Input() customerDetails: Customer;
  constructor() {}

  ngOnInit() {
    debugger;
    this.customerDetails = new Customer();
  }
}

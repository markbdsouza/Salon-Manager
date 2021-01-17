import { Component, Input, OnInit } from "@angular/core";
import { ActivatedRoute } from "@angular/router";
import { Customer } from "../customer";

@Component({
  selector: "app-customer-details",
  templateUrl: "./customer-details.component.html",
  styleUrls: ["./customer-details.component.scss"],
})
export class CustomerDetailsComponent implements OnInit {
  @Input() customerDetails: Customer;
  constructor(private route: ActivatedRoute) {}

  ngOnInit() {
    this.customerDetails = <Customer>{};
    this.route.queryParams.subscribe((params) => {
      console.log("reading params");
      console.log(params);
    });
  }

  addServices() {
    console.log("Route to services");
  }
  checkout() {
    console.log("Route to checkout");
  }
}

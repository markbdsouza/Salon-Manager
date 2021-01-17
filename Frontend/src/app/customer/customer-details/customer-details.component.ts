import { Component, Input, OnInit } from "@angular/core";
import { ActivatedRoute } from "@angular/router";
import { CustomerService } from "src/app/services/customer.service";
import { Customer } from "../customer";

@Component({
  selector: "app-customer-details",
  templateUrl: "./customer-details.component.html",
  styleUrls: ["./customer-details.component.scss"],
})
export class CustomerDetailsComponent implements OnInit {
  @Input() customerDetails: Customer;
  customerId: string;

  constructor(
    private route: ActivatedRoute,
    private customerService: CustomerService
  ) {}

  ngOnInit() {
    this.customerDetails = <Customer>{};
    this.route.queryParams.subscribe((params) => {
      this.customerId = params["id"];
      this.customerService.findByCustomerId(this.customerId).subscribe(
        (res) => {
          this.customerDetails = res;
        },
        (err) => {
          console.log(err);
        }
      );
    });
  }

  addServices() {
    console.log("Route to services");
  }
  checkout() {
    console.log("Route to checkout");
  }
}

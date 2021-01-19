import { CustomerServiceModel } from "./../CustomerServiceModel";
import { CustomerService } from "src/app/services/customer.service";
import { ProvidedServiceService } from "./../../services/provided-service.service";
import { Component, OnInit } from "@angular/core";
import { Service } from "../service";
import { FormBuilder, FormGroup, Validators } from "@angular/forms";

@Component({
  selector: "app-services",
  templateUrl: "./services.component.html",
  styleUrls: ["./services.component.scss"],
})
export class ServicesComponent implements OnInit {
  serviceList: Array<Service> = [];
  serviceTypeList: Array<string> = [];

  //serviceCodeValueMap: { code: string; value: string }[];
  CustomerServiceList: Array<CustomerServiceModel> = [];

  constructor(private providedServiceService: ProvidedServiceService) {}

  ngOnInit() {
    this.CustomerServiceList.push(new CustomerServiceModel());
    this.providedServiceService.findAllServices().subscribe(
      (res) => {
        this.serviceList = res;
        debugger;
        // this.serviceCodeValueMap = res.map((x) => {
        //   return { code: x.serviceTypeId, value: x.serviceType };
        // });
        this.serviceTypeList = [
          ...new Set(this.serviceList.map((x) => x.serviceType)),
        ];
      },
      (err) => {
        console.log(err);
      }
    );
  }

  addServices() {
    this.CustomerServiceList.push(new CustomerServiceModel());
  }
}

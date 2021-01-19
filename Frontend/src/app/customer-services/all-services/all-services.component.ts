import { Component, OnInit } from "@angular/core";
import { ProvidedServiceService } from "src/app/services/provided-service.service";
import { Service } from "../service";

@Component({
  selector: "app-all-services",
  templateUrl: "./all-services.component.html",
  styleUrls: ["./all-services.component.scss"],
})
export class AllServicesComponent implements OnInit {
  serviceArray: Array<Service> = [];

  constructor(private providedServiceService: ProvidedServiceService) {}

  ngOnInit() {
    this.providedServiceService.findAllServices().subscribe(
      (res) => {
        this.serviceArray = res;
      },
      (err) => {
        console.log(err);
      }
    );
  }
}

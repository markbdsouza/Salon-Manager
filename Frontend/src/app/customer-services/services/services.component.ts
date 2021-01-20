import { SingleServiceComponent } from "./single-service/single-service.component";
import { CustomerServiceModel } from "./../CustomerServiceModel";
import { CustomerService } from "src/app/services/customer.service";
import { ProvidedServiceService } from "./../../services/provided-service.service";
import {
  Component,
  OnInit,
  QueryList,
  ViewChild,
  ViewChildren,
} from "@angular/core";
import { Service } from "../service";
import { ActivatedRoute } from "@angular/router";

@Component({
  selector: "app-services",
  templateUrl: "./services.component.html",
  styleUrls: ["./services.component.scss"],
})
export class ServicesComponent implements OnInit {
  serviceList: Array<Service> = [];
  serviceTypeList: Array<string> = [];
  @ViewChildren("serviceComponent")
  components: QueryList<SingleServiceComponent>;
  customerId: string;

  //serviceCodeValueMap: { code: string; value: string }[];
  CustomerServiceList: Array<CustomerServiceModel> = [];

  constructor(
    private providedServiceService: ProvidedServiceService,
    private route: ActivatedRoute
  ) {}

  ngOnInit() {
    this.route.queryParams.subscribe((params) => {
      this.customerId = params["id"];
      this.providedServiceService
        .getCustomerServices(this.customerId)
        .subscribe(
          (res) => {
            res.serviceRegisterationModelList.forEach((x) =>
              this.CustomerServiceList.push(x)
            );
          },
          (err) => console.log(err)
        );
    });

    this.providedServiceService.findAllServices().subscribe(
      (res) => {
        this.serviceList = res;
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

  ngAfterViewInit() {
    console.log(this.components);
  }

  saveAll() {
    let childComponents = this.components.toArray();
    this.CustomerServiceList = [];
    childComponents.forEach((component) => {
      console.log(component.customerServiceRowData);
      this.CustomerServiceList.push(component.customerServiceRowData);
    });

    this.providedServiceService
      .saveCustomerService(this.customerId, this.CustomerServiceList)
      .subscribe((res) => console.log(res));
  }

  removeService(index: number) {
    this.CustomerServiceList.splice(index, 1);
  }

  doSomething() {
    debugger;
    let childComponents = this.components.toArray();
    this.CustomerServiceList = [];
  }
}

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
import {
  trigger,
  state,
  style,
  animate,
  transition,
} from "@angular/animations";

@Component({
  selector: "app-services",
  animations: [
    trigger("flyInOut", [
      state("in", style({ transform: "translateX(0)" })),
      transition("void => *", [
        style({ transform: "translateX(-100%)" }),
        animate(200),
      ]),
      transition("* => void", [
        animate(200, style({ transform: "translateX(100%)" })),
      ]),
    ]),
  ],
  templateUrl: "./services.component.html",
  styleUrls: ["./services.component.scss"],
})
export class ServicesComponent implements OnInit {
  serviceList: Array<Service> = [];
  serviceTypeList: Array<string> = [];
  @ViewChildren("serviceComponent")
  components: QueryList<SingleServiceComponent>;
  customerId: string;

  CustomerServiceList: Array<CustomerServiceModel> = [];

  constructor(
    private providedServiceService: ProvidedServiceService,
    private route: ActivatedRoute
  ) {}

  ngOnInit() {
    this.route.queryParams.subscribe((params) => {
      this.customerId = params["id"];

      this.providedServiceService.findAllServices().subscribe(
        (res) => {
          console.table(res);
          this.serviceList = res;
          this.serviceTypeList = [
            ...new Set(this.serviceList.map((x) => x.serviceType)),
          ];
          this.providedServiceService
            .getCustomerServices(this.customerId)
            .subscribe(
              (res) => {
                if (res != null)
                  res.serviceRegisterationModelList.forEach((x) =>
                    this.CustomerServiceList.push(x)
                  );
                if (this.CustomerServiceList.length === 0) this.addServices();
              },
              (err) => console.log(err)
            );
        },
        (err) => {
          console.log(err);
        }
      );
    });
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
    let deletedCustomerService: Array<CustomerServiceModel> = this.CustomerServiceList.splice(
      index,
      1
    );
    console.log(deletedCustomerService);
    this.providedServiceService
      .deleteCustomerService(
        this.customerId,
        deletedCustomerService[0].customerServiceId
      )
      .subscribe((res) => {
        console.log("deleted");
      });
  }
}

import { Component, Input, OnInit } from "@angular/core";
import { INSPECT_MAX_BYTES } from "buffer";
import { ProvidedServiceService } from "src/app/services/provided-service.service";
import { CustomerServiceModel } from "../../CustomerServiceModel";
import { Service } from "../../service";

@Component({
  selector: "[single-service-tr]",
  templateUrl: "./single-service.component.html",
  styleUrls: ["./single-service.component.scss"],
})
export class SingleServiceComponent implements OnInit {
  @Input() index: number;
  @Input() serviceList: Array<Service> = [];
  @Input("serviceTypeList") serviceCategoryList: Array<string>;
  @Input() asd: any;
  serviceNameDynamicOptions: Array<{ code: string; value: string }>;
  selectedServiceName: string;
  quantity: string;
  isSaveEnabled: boolean;

  constructor(private providedServiceService: ProvidedServiceService) {}

  ngOnInit() {}

  saveRow() {
    console.log(this.asd);
    let customerServiceModel: CustomerServiceModel = {
      serviceTypeId: this.selectedServiceName,
      isComplete: false,
      isCancelled: false,
      quantity: +this.quantity,
    };

    this.providedServiceService
      .saveCustomerService(
        "BakHxqf9Me4mH2FIG66RhzYiUPKJf8",
        customerServiceModel
      )
      .subscribe((res) => console.log(res));
  }

  typeChanged(target) {
    this.serviceNameDynamicOptions = this.filterOnServiceType(target.value);
  }

  serviceSelected(target) {
    target.parentElement.parentElement.querySelector(
      ".serviceDescription"
    ).innerHTML = this.getDescription(target.value);

    this.isSaveEnabled = true;
  }

  private getDescription(serviceTypeId: string) {
    return this.serviceList.find((x) => x.serviceTypeId === serviceTypeId)
      .description;
  }
  private filterOnServiceType(serviceType: string) {
    return [
      ...this.serviceList
        .filter((x) => x.serviceType === serviceType)
        .map((x) => {
          return { code: x.serviceTypeId, value: x.name };
        }),
    ];
  }
}

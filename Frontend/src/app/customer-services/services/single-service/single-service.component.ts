import { Component, EventEmitter, Input, OnInit, Output } from "@angular/core";
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
  @Input() customerServiceRowData: any;
  @Output() public onDelete: EventEmitter<any> = new EventEmitter();
  serviceNameDynamicOptions: Array<{ code: string; value: string }>;
  // selectedServiceName: string;
  // quantity: string;
  isSaveEnabled: boolean;
  selectedServiceCategory: string;
  serviceDescription: string;

  constructor(private providedServiceService: ProvidedServiceService) {}

  ngOnInit() {
    // this.quantity = !!this.customerServiceRowData.quantity
    //   ? this.customerServiceRowData.quantity.toString()
    //   : "1";
    // this.selectedServiceName = !!this.customerServiceRowData.serviceTypeId
    //   ? this.customerServiceRowData.serviceTypeId.toString()
    //   : null;

    this.selectedServiceCategory = this.customerServiceRowData.serviceTypeId
      ? this.getCategory(this.customerServiceRowData.serviceTypeId.toString())
      : null;
    this.typeChanged();
    this.serviceSelected();
  }

  ngOnChanges() {
    // this.customerServiceRowData = {
    //   serviceTypeId: this.selectedServiceName,
    //   isComplete: false,
    //   isCancelled: false,
    //   quantity: +this.quantity,
    //   customerServiceId: "",
    //   cancelled: false,
    //   complete: false,
    // };
  }

  saveRow() {
    this.providedServiceService
      .saveCustomerService(
        "BakHxqf9Me4mH2FIG66RhzYiUPKJf8",
        Array.of(this.customerServiceRowData)
      )
      .subscribe((res) => console.log(res));
  }

  typeChanged() {
    this.serviceNameDynamicOptions = this.filterOnServiceType(
      this.selectedServiceCategory
    );
  }

  serviceSelected() {
    this.serviceDescription = this.getDescription(
      this.customerServiceRowData.serviceTypeId
    );
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

  private getCategory(serviceTypeId: string): string {
    return this.serviceList
      .filter((x) => x.serviceTypeId === serviceTypeId)
      .map((x) => {
        return x.serviceType;
      })[0];
  }

  delete() {
    this.onDelete.emit();
  }
}

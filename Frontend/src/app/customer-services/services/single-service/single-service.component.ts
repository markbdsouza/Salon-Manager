import { Component, EventEmitter, Input, OnInit, Output } from "@angular/core";
import { ActivatedRoute } from "@angular/router";
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
  @Input() customerServiceRowData: CustomerServiceModel;
  @Input() customerId: string;
  @Output() public onDelete: EventEmitter<any> = new EventEmitter();
  serviceNameDynamicOptions: Array<{ code: string; value: string }>;
  isSaveEnabled: boolean;
  selectedServiceCategory: string;
  serviceDescription: string;
  isServiceEnabled: boolean = false;

  constructor(private providedServiceService: ProvidedServiceService) {}

  ngOnInit() {
    this.selectedServiceCategory = this.customerServiceRowData.serviceTypeId
      ? this.getCategory(this.customerServiceRowData.serviceTypeId.toString())
      : null;
    this.typeChanged();
    if (!this.customerServiceRowData.quantity)
      this.customerServiceRowData.quantity = 1;
    if (this.customerServiceRowData.serviceTypeId) this.serviceSelected();
    this.isSaveEnabled = !this.customerServiceRowData.customerServiceId;
  }

  saveRow() {
    this.providedServiceService
      .saveCustomerService(
        this.customerId,
        Array.of(this.customerServiceRowData)
      )
      .subscribe((res) => console.log(res));
  }

  typeChanged() {
    this.serviceNameDynamicOptions = this.filterOnServiceType(
      this.selectedServiceCategory
    );
    if (!!this.selectedServiceCategory) this.isServiceEnabled = true;
  }

  serviceSelected() {
    debugger;
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

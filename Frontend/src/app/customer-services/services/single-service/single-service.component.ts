import { Component, EventEmitter, Input, OnInit, Output } from "@angular/core";
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
    this.enableSave();
  }

  saveRow() {
    this.isSaveEnabled = false;
    this.providedServiceService
      .saveCustomerService(
        this.customerId,
        Array.of(this.customerServiceRowData)
      )
      .subscribe((res) => {});
  }

  typeChanged() {
    this.serviceNameDynamicOptions = this.filterOnServiceType(
      this.selectedServiceCategory
    );
    if (!!this.selectedServiceCategory) this.isServiceEnabled = true;
  }

  enableSave() {
    if (this.customerServiceRowData.customerServiceId) {
      this.isSaveEnabled = false;
    } else if (
      this.customerServiceRowData.customerServiceId === undefined ||
      this.customerServiceRowData.serviceTypeId !== undefined
    )
      this.isSaveEnabled = true;
  }

  serviceSelected() {
    this.serviceDescription = this.getDescription(
      this.customerServiceRowData.serviceTypeId
    );
    this.enableSave();
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

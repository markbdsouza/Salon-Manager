import { HttpClient } from "@angular/common/http";
import { Injectable } from "@angular/core";
import { Observable } from "rxjs";
import { CustomerServiceModel } from "../customer-services/CustomerServiceModel";
import { Service } from "../customer-services/service";

@Injectable({
  providedIn: "root",
})
export class ProvidedServiceService {
  private servicesUrl = "http://www.localhost:8080";

  constructor(private httpClient: HttpClient) {}

  findAllServices(): Observable<Array<Service>> {
    const findAllServices = `${this.servicesUrl}/services`;
    return this.httpClient.get<Array<Service>>(findAllServices);
  }

  saveCustomerService(
    customerId: string,
    customerServiceList: CustomerServiceModel[]
  ): Observable<any> {
    const saveCustomerServiceURL = `${
      this.servicesUrl
    }/customerServices/${customerId}/${getDate()}`;
    return this.httpClient.post<any>(
      saveCustomerServiceURL,
      customerServiceList
    );
  }

  getCustomerServices(customerId: string): Observable<serviceResponseData> {
    const getCustomerServiceURL = `${
      this.servicesUrl
    }/customerServices/${customerId}/${getDate()}`;
    return this.httpClient.get<serviceResponseData>(getCustomerServiceURL);
  }

  deleteCustomerService(
    customerId: string,
    customerServiceId: string
  ): Observable<null> {
    const deleteCustomerServiceURL = `${this.servicesUrl}/customerServices/${customerId}/${customerServiceId}`;
    return this.httpClient.delete<null>(deleteCustomerServiceURL);
  }
}

function getDate() {
  var d = new Date(),
    month = "" + (d.getMonth() + 1),
    day = "" + d.getDate(),
    year = d.getFullYear();

  if (month.length < 2) month = "0" + month;
  if (day.length < 2) day = "0" + day;

  return [year, month, day].join("-");
}

interface serviceResponseData {
  customerId: number;
  date: Date;
  serviceRegisterationModelList: Array<CustomerServiceModel>;
}

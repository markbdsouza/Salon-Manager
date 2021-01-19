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
    customerService: CustomerServiceModel
  ): Observable<any> {
    const saveCustomerServiceURL = `${
      this.servicesUrl
    }/customerServices/${customerId}/${getDate()}`;
    debugger;
    const url =
      "http://www.localhost:8080/customerServices/Pa2Hxqf9Me4mH2FIG66RhzYiUPKJf8/2020-10-20";
    return this.httpClient.post<any>(url, customerService);
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

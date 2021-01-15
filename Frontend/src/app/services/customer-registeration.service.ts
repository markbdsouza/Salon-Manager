import { HttpClient } from "@angular/common/http";
import { Injectable } from "@angular/core";
import { Observable } from "rxjs";
import { Customer } from "../customer-registeration/customer";

@Injectable({
  providedIn: "root",
})
export class CustomerRegisterationService {
  private customerRegisterationUrl = "http://www.localhost:8080/customers";

  constructor(private httpClient: HttpClient) {}

  createCustomer(customer: Customer): Observable<any> {
    console.log(customer);
    return this.httpClient.post<Customer>(
      this.customerRegisterationUrl,
      customer
    );
  }
}

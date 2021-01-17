import { HttpClient } from "@angular/common/http";
import { Injectable } from "@angular/core";
import { Observable } from "rxjs";
import { Customer } from "../customer/customer";

@Injectable({
  providedIn: "root",
})
export class CustomerService {
  private customersUrl = "http://www.localhost:8080/customers";

  constructor(private httpClient: HttpClient) {}

  createCustomer(customer: Customer): Observable<any> {
    return this.httpClient.post<Customer>(this.customersUrl, customer);
  }

  findByPhoneNumber(phoneNumber: string): Observable<Customer> {
    const findByPhoneURL = `${this.customersUrl}/phoneNumber/${phoneNumber}`;
    return this.httpClient.get<Customer>(findByPhoneURL);
  }

  findByCustomerId(id: string): Observable<Customer> {
    const findByCustomerId = `${this.customersUrl}/${id}`;
    return this.httpClient.get<Customer>(findByCustomerId);
  }
}

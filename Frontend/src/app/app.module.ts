import { AllServicesComponent } from "./customer-services/all-services/all-services.component";
import { BrowserModule } from "@angular/platform-browser";
import { NgModule } from "@angular/core";
import { HttpClientModule } from "@angular/common/http";
import { AppComponent } from "./app.component";
import { FooterComponent } from "./footer/footer.component";
import { HeaderComponent } from "./header/header.component";
import { FormsModule, ReactiveFormsModule } from "@angular/forms";
import { CustomerPhoneNumberSearchComponent } from "./customer/customer-phone-number-search/customer-phone-number-search.component";
import { CustomerRegisterationComponent } from "./customer/customer-registeration/customer-registeration.component";
import { CustomerDetailsComponent } from "./customer/customer-details/customer-details.component";
import { CustomerComponent } from "./customer/customer.component";
import { RouterModule, Routes } from "@angular/router";
import { CustomerServicesComponent } from "./customer-services/customer-services.component";
import { ServicesComponent } from "./customer-services/services/services.component";
import { SingleServiceComponent } from "./customer-services/services/single-service/single-service.component";
import { BrowserAnimationsModule } from "@angular/platform-browser/animations";

const routes: Routes = [
  { path: "Register", component: CustomerRegisterationComponent },
  { path: "Search", component: CustomerPhoneNumberSearchComponent },
  { path: "Customer", component: CustomerServicesComponent },
  { path: "AllServices", component: AllServicesComponent },
];

@NgModule({
  declarations: [
    AppComponent,
    FooterComponent,
    HeaderComponent,
    CustomerRegisterationComponent,
    CustomerPhoneNumberSearchComponent,
    CustomerDetailsComponent,
    CustomerComponent,
    CustomerServicesComponent,
    ServicesComponent,
    AllServicesComponent,
    SingleServiceComponent,
  ],
  imports: [
    BrowserModule,
    FormsModule,
    ReactiveFormsModule,
    HttpClientModule,
    RouterModule.forRoot(routes),
    BrowserAnimationsModule,
  ],
  providers: [],
  bootstrap: [AppComponent],
})
export class AppModule {}

import { environment } from "./../../environments/environment";
import { Component, OnInit } from "@angular/core";

@Component({
  selector: "app-header",
  templateUrl: "./header.component.html",
  styleUrls: ["./header.component.scss"],
})
export class HeaderComponent implements OnInit {
  appName: string;
  appDescription: string;
  constructor() {}

  ngOnInit() {
    this.appName = environment.appName;
    this.appDescription = environment.appDescription;
  }
}

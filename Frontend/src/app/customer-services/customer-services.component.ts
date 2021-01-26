import {
  animate,
  state,
  style,
  transition,
  trigger,
} from "@angular/animations";
import { ChangeDetectorRef, Component, OnInit } from "@angular/core";

@Component({
  selector: "app-customer-services",
  animations: [
    trigger("openClose", [
      state(
        "open",
        style({
          opacity: 1,
          bottom: "0px",
          position: "relative",
          "z-index": -1,
        })
      ),
      state(
        "closed",
        style({
          opacity: 0,
          position: "relative",
          bottom: "200px",
          "z-index": -1,
        })
      ),
      transition("closed => open", [animate(".7s")]),
    ]),
  ],
  templateUrl: "./customer-services.component.html",
  styleUrls: ["./customer-services.component.scss"],
})
export class CustomerServicesComponent implements OnInit {
  isOpen: boolean = false;
  constructor(private cdref: ChangeDetectorRef) {}

  ngOnInit() {}

  ngAfterContentChecked() {
    this.cdref.detectChanges();
    this.isOpen = true;
  }
}

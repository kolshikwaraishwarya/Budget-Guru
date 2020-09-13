import { Component, OnInit, NgZone } from '@angular/core';
import { AuthService } from "../../shared/services/auth.service";
import { Router } from "@angular/router";


@Component({
  selector: 'app-dashboard',
  templateUrl: './dashboard.component.html',
  styleUrls: ['./dashboard.component.css']
})
export class DashboardComponent implements OnInit {
  
  constructor(
    public authService: AuthService,
    public router: Router,
    public ngZone: NgZone,
    private userService : AuthService,
  ) {}

  ngOnInit() { }
  

  showDetailsPage() : void {
    this.router.navigate(['show-details']);
    console.log(this.userService.userData.uid);
  }

  showSaveDetailsPage() : void {
    this.router.navigate(['savedetails']);
  }
  showForumsPage() : void {
    this.router.navigate(['forum']);
  }

  showBillsPage() : void {
    this.router.navigate(['bills']);
  }
  showAnalysisPage() : void {
    this.router.navigate(['yearly-analysis']);
  }

}

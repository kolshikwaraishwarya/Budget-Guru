import { Component, OnInit } from '@angular/core';
import { AuthService } from "../../shared/services/auth.service";
//import { NotificationService } from 'src/app/shared/services/notification.service'
//import { ToastrService } from 'ngx-toastr';

import { Router } from "@angular/router";

interface Year {
  value: string;
  viewValue: string;
}
interface Month {
  value: string;
  viewValue: string;
}
//declare var toastr: any;
@Component({
  selector: 'app-savedetails',
  templateUrl: './savedetails.component.html',
  styleUrls: ['./savedetails.component.css']
})
export class SavedetailsComponent implements OnInit {
  years: Year[] = [
    { value: '2010', viewValue: '2010' },
    { value: '2011', viewValue: '2011' },
    { value: '2012', viewValue: '2012' },
    { value: '2013', viewValue: '2013' },
    { value: '2014', viewValue: '2014' },
    { value: '2015', viewValue: '2015' },
    { value: '2016', viewValue: '2016' },
    { value: '2017', viewValue: '2017' },
    { value: '2018', viewValue: '2018' },
    { value: '2019', viewValue: '2019' },
    { value: '2020', viewValue: '2020' },
    { value: '2021', viewValue: '2021' },
    { value: '2022', viewValue: '2022' },
    { value: '2023', viewValue: '2023' },
    { value: '2024', viewValue: '2024' },
    { value: '2025', viewValue: '2025' },
    { value: '2026', viewValue: '2026' },
    { value: '2027', viewValue: '2027' },
    { value: '2028', viewValue: '2028' },
    { value: '2029', viewValue: '2029' },
    { value: '2030', viewValue: '2030' }
  ];
  months: Month[] = [
    { value: 'jan', viewValue: 'January' },
    { value: 'feb', viewValue: 'February' },
    { value: 'mar', viewValue: 'March' },
    { value: 'apr', viewValue: 'April' },
    { value: 'may', viewValue: 'May' },
    { value: 'june', viewValue: 'June' },
    { value: 'july', viewValue: 'July' },
    { value: 'aug', viewValue: 'August' },
    { value: 'sept', viewValue: 'September' },
    { value: 'oct', viewValue: 'October' },
    { value: 'nov', viewValue: 'November' },
    { value: 'dec', viewValue: 'December' }
  ]
  userDetails: any;
  savings: any;
  income: any;
  expenses: any;
  //notifyService : any;


  constructor(private userService: AuthService, public router: Router, public authService: AuthService) {
    this.userDetails = { uId: this.userService.userData.uid, month: '', year: '' }
    this.savings = { user: this.userDetails, investments: '', emergencyFunds: '', others: '' },
    this.income = { user: this.userDetails, salary: '', grants: '', refunds: '', others: '' },
    this.expenses = { user: this.userDetails, personal: '', education: '', shelter: '', health: '', transportation: '', household: '', clothing: '', food: '', miscellaneous: '' }

  }

  ngOnInit(): void {
    
    var coll = document.getElementsByClassName("collapsible");
    var i;

    for (i = 0; i < coll.length; i++) {
      coll[i].addEventListener("click", function () {
        this.classList.toggle("active");
        var content = this.nextElementSibling;
        if (content.style.maxHeight) {
          content.style.maxHeight = null;
        } else {
          content.style.maxHeight = content.scrollHeight + "px";
        }
      });
    }



    
  }
  /*showToasterSuccess() : any{
    this.notifyService.showSuccess(" successfull !!", "Got")
}*/

  saveSavings(mySavings: any): any {

    console.log(mySavings);
    this.userService.saveUserSavings(this.savings).subscribe((result: any) => { console.log(result) });
    alert("SAVED!");

  }
  showForumsPage() : void {
    this.router.navigate(['forum']);
  }

  saveIncome(myIncome: any): void {
    console.log(myIncome);
    this.userService.saveUserIncome(this.income).subscribe((result: any) => { console.log(result) });
    alert("SAVED!");
  }

  saveExpenses(myExpenses: any): any {
    console.log(myExpenses);
    this.userService.saveUserExpenses(this.expenses).subscribe((result: any) => { console.log(result) });
    alert("SAVED!");

  }

  reset(mySavings: any, myIncome: any, myExpenses: any): any {
    mySavings.reset();
    myIncome.reset();
    myExpenses.reset();

  }
  showDetailsPage(): void {
    this.router.navigate(['show-details']);
    console.log(this.userService.userData.uid);
  }

  showSaveDetailsPage(): void {
    this.router.navigate(['savedetails']);
  }

  showBillsPage(): void {
    this.router.navigate(['bills']);
  }
  showAnalysisPage(): void {
    this.router.navigate(['yearly-analysis']);
  }




}

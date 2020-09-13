import { Component, OnInit } from '@angular/core';
import { AuthService } from 'src/app/shared/services/auth.service';
import {Chart} from 'chart.js';
import { Router } from '@angular/router';

interface Year {
  value: string;
  viewValue: string;
}

@Component({
  selector: 'app-yearly-analysis',
  templateUrl: './yearly-analysis.component.html',
  styleUrls: ['./yearly-analysis.component.css']
})
export class YearlyAnalysisComponent implements OnInit {

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

  userDetails :any;
  total : {jan : {total_income: '',total_savings: '',total_expenses: ''},
          feb : {total_income: '',total_savings: '',total_expenses: ''},
          mar : {total_income: '',total_savings: '',total_expenses: ''},
          apr : {total_income: '',total_savings: '',total_expenses: ''},
          may : {total_income: '',total_savings: '',total_expenses: ''},
          june : {total_income: '',total_savings: '',total_expenses: ''},
          july : {total_income: '',total_savings: '',total_expenses: ''},
          aug : {total_income: '',total_savings: '',total_expenses: ''},
          sept : {total_income: '',total_savings: '',total_expenses: ''},
          oct : {total_income: '',total_savings: '',total_expenses: ''},
          nov : {total_income: '',total_savings: '',total_expenses: ''},
          dec: {total_income: '',total_savings: '',total_expenses: ''}};
  
  constructor(private userService: AuthService, public router: Router,public authService: AuthService) { 
    this.userDetails = {uId : userService.userData.uid , year :''}
  }

  ngOnInit(): void {
  }

  showYearlyAnalysis() {
    console.log(this.userDetails)
    this.userService.getYearlyAnalysis(this.userDetails).subscribe((result : any) => {console.log(result);this.total = result;});
  }
  showDetailsPage() : void {
    this.router.navigate(['show-details']);
    console.log(this.userService.userData.uid);
  }

  showSaveDetailsPage() : void {
    this.router.navigate(['savedetails']);
  }

  showBillsPage() : void {
    this.router.navigate(['bills']);
  }
  showAnalysisPage() : void {
    this.router.navigate(['yearly-analysis']);
  }
  showForumsPage() : void {
    this.router.navigate(['forum']);
  }

  showAnalysis(){
    console.log("in show analysis");
    console.log(this.total);

    new Chart(document.getElementById("bar-chart-grouped"), {
      type: 'bar',
      data: {
        labels: ["January", "February", "March", "April","May","June","July","August","September","October","November","December"],
        datasets: [
          {
            label: "Income",
            backgroundColor: "#3e95cd",
            data: [this.total.jan.total_income,this.total.feb.total_income,this.total.mar.total_income,this.total.apr.total_income,this.total.may.total_income,this.total.june.total_income,this.total.july.total_income,this.total.aug.total_income,this.total.sept.total_income,this.total.oct.total_income,this.total.nov.total_income,this.total.dec.total_income]
          }, {
            label: "Saving",
            backgroundColor: "#8e5ea2",
            data: [this.total.jan.total_savings,this.total.feb.total_savings,this.total.mar.total_savings,this.total.apr.total_savings,this.total.may.total_savings,this.total.june.total_savings,this.total.july.total_savings,this.total.aug.total_savings,this.total.sept.total_savings,this.total.oct.total_savings,this.total.nov.total_savings,this.total.dec.total_savings]
          }, {
            label: "Expense",
            backgroundColor: "#5E0C49",
            data: [this.total.jan.total_expenses,this.total.feb.total_expenses,this.total.mar.total_expenses,this.total.apr.total_expenses,this.total.may.total_expenses,this.total.june.total_expenses,this.total.july.total_expenses,this.total.aug.total_expenses,this.total.sept.total_expenses,this.total.oct.total_expenses,this.total.nov.total_expenses,this.total.dec.total_expenses]
          }
        ]
      },
      options: {
        title: {
          display: true,
          text: 'Month-wise Budget Analysis'
        }
      }
  });



  }


}
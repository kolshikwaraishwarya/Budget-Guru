import { Component, OnInit } from '@angular/core';
import { AuthService } from 'src/app/shared/services/auth.service';
import { Chart } from 'chart.js';
import { Router } from "@angular/router";



interface Year {
  value: string;
  viewValue: string;
}
interface Month {
  value: string;
  viewValue: string;
}
@Component({
  selector: 'app-show-details',
  templateUrl: './show-details.component.html',
  styleUrls: ['./show-details.component.css']
})
export class ShowDetailsComponent implements OnInit {
  PieChart = [];
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
  userData: any;
  savings: any;
  expenses: any;
  income: any;
  total: any;

  constructor(private userService: AuthService, public router: Router,public authService: AuthService
  ) {
    this.userData = { uid: userService.userData.uid, year: '', month: '' }
  }
  ngOnInit(): void {
    
    
    
  }
  showSavings(): any {

    console.log("in method", this.userData);
    this.userService.getSavings(this.userData).subscribe((result1: any) => { console.log(result1); this.savings = result1; });
  }

  showExpenses(): any {
    this.userService.getExpenses(this.userData).subscribe((result2: any) => { console.log(result2); this.expenses = result2; });
  }
  

  showIncome(): any {
    this.userService.getIncome(this.userData).subscribe((result3: any) => { console.log(result3); this.income = result3; });

  }
  calculateTotal(): any {
    this.userService.getReport(this.userData).subscribe((result: any) => { console.log(result); this.total = result; });
  }
  showDetailsPage(): void {
    this.router.navigate(['show-details']);
    console.log(this.userService.userData.uid);
  }

  showSaveDetailsPage(): void {
    this.router.navigate(['savedetails']);
  }
  showAnalysisPage(): void {
    this.router.navigate(['yearly-analysis']);
  }
  showForumsPage() : void {
    this.router.navigate(['forum']);
  }

  showBillsPage(): void {
    this.router.navigate(['bills']);
  }
  showReport(): any {

    this.PieChart = new Chart('pieChart_total', {


      type: 'pie',


      data: {


        labels: ["Savings", "Income", "Expenses"],


        datasets: [{


          label: 'Budget',


          data: [this.total.total_savings, this.total.total_income, this.total.total_expenses],


          backgroundColor: [


            'rgba(40,23,244,0.9)',


            'rgba(192,255,0,0.9)',


            'rgba(239,23,240,0.9)',


          ],
        }]
      },


      options: {
        title: {
          Text: "Bar Chart",


          display: true
        },


        scales: {
          yAxes: [{
            ticks: {
              begainAtZero: true


            }
          }]
        }
      }
    });


  }

  showExpenseAnalysis() {

    this.PieChart = new Chart('pieChart_expenses', {


      type: 'pie',


      data: {


        labels: ["Personal", "Education", "Shelter", "Health", "Transportation", "Household", "Clothing", "Food", "Miscellaneous"],


        datasets: [{


          label: 'Budget',


          data: [this.expenses.personal, this.expenses.education, this.expenses.shelter, this.expenses.health, this.expenses.transportation, this.expenses.household, this.expenses.clothing, this.expenses.food, this.expenses.miscellaneous],


          backgroundColor: [


            'rgba(40,23,244,0.9)',


            'rgba(192,255,0,0.9)',


            'rgba(239,23,240,0.9)',

            'rgb(174, 174, 39)',

            'rgb(32, 146, 146)',

            'rgb(132, 25, 25)',

            'rgb(18, 119, 68)',

            'rgb(11, 74, 74)',

            'rgb(45, 5, 45)'


          ],
        }]
      },


      options: {
        title: {
          Text: "Bar Chart",


          display: true
        },


        scales: {
          yAxes: [{
            ticks: {
              begainAtZero: true


            }
          }]
        }
      }
    });



  }

  showSavingsAnalysis(): any {

    this.PieChart = new Chart('pieChart_savings', {


      type: 'pie',


      data: {


        labels: ["Investments", "Emergency Funds", "Others"],


        datasets: [{


          label: 'Budget',


          data: [this.savings.investments, this.savings.emergencyFunds, this.savings.others],


          backgroundColor: [


            'rgba(40,23,244,0.9)',


            'rgba(192,255,0,0.9)',


            'rgba(239,23,240,0.9)',


          ],
        }]
      },


      options: {
        title: {
          Text: "Bar Chart",


          display: true
        },


        scales: {
          yAxes: [{
            ticks: {
              begainAtZero: true


            }
          }]
        }
      }
    });

  }

  showIncomeAnalysis(): any {
    this.PieChart = new Chart('pieChart_income', {


      type: 'pie',


      data: {


        labels: ["Salary", "Grants", "Refunds", "Others"],


        datasets: [{


          label: 'Budget',


          data: [this.income.salary, this.income.grants, this.income.refunds, this.income.others],


          backgroundColor: [


            'rgba(40,23,244,0.9)',


            'rgba(192,255,0,0.9)',


            'rgba(239,23,240,0.9)',


            'rgb(174, 174, 39)',


          ],
        }]
      },


      options: {
        title: {
          Text: "Bar Chart",


          display: true
        },


        scales: {
          yAxes: [{
            ticks: {
              begainAtZero: true


            }
          }]
        }
      }
    });

  }
} 
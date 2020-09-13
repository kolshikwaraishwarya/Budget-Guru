import { Component, OnInit } from '@angular/core';
import { AuthService } from 'src/app/shared/services/auth.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-show-answers',
  templateUrl: './show-answers.component.html',
  styleUrls: ['./show-answers.component.css']
})
export class ShowAnswersComponent implements OnInit {

  question : any;
  questionId : any;
  postDetails : any;
  answers : any;

  constructor(private userService: AuthService,public router: Router,public authService: AuthService) { 
    this.postDetails = {questionId : JSON.parse(localStorage.getItem('questionId')),email : JSON.parse(localStorage.getItem('email')),answer : '',post_email : this.userService.userData.email}
  }

  ngOnInit(): void {
    this.question = JSON.parse(localStorage.getItem('question'));
    this.questionId = JSON.parse(localStorage.getItem('questionId'));
    this.userService.getAnswers(this.questionId).subscribe((result : any) => {console.log(result);this.answers = result;});

  }
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

  postAnswer(myAnswer) : any {
    
    this.userService.postAnswer(this.postDetails).subscribe((result : any) => {console.log(result)});
    alert('Thank You!')
    myAnswer.reset();
  }

}
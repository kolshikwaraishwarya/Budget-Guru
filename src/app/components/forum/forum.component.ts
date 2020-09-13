import { Component, OnInit } from '@angular/core';
import { AuthService } from 'src/app/shared/services/auth.service';
import { Router } from '@angular/router';
import { title } from 'process';
declare var jQuery: any;

@Component({
  selector: 'app-forum',
  templateUrl: './forum.component.html',
  styleUrls: ['./forum.component.css']
})
export class ForumComponent implements OnInit {

  questionDetails : any;
  answerDetails : any;
  questions : any;
  titles : any;
  questionTitle : any;

  constructor(private userService: AuthService,private router: Router, public authService: AuthService,) { 
    this.questionDetails = { email : this.userService.userData.email,question : '',title : ''},
    this.answerDetails = {question : '' ,answer:''}
    

  }

  ngOnInit(): void {
    this.userService.getQuestions().subscribe((result : any) => {console.log(result);this.questions = result;});

    this.userService.getTitles().subscribe((result : any) => {console.log(result);this.titles = result;})

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

  post(myQuestion) {
    console.log(this.questionDetails);
    this.userService.post(this.questionDetails).subscribe((result : any) => {console.log(result)});
    alert("Thank you!");
    myQuestion.reset();
    //jQuery('#postModel').modal('show');
  }

  showPostPopup() {
    jQuery('#postModel').modal('show');
  }

  showAnswers(questionId,email,question) : any {
    console.log('question',question);
    localStorage.setItem('questionId',JSON.stringify(questionId));   
    localStorage.setItem('email',JSON.stringify(email));
    localStorage.setItem('question',JSON.stringify(question));
    
    this.router.navigate(['show-answers']);

    
    
  }
  getQuestionByTitle() {
    this.userService.getQuestionsByTitle(this.questionTitle).subscribe((result : any) => {console.log(result);this.questions = result;});
  }


}
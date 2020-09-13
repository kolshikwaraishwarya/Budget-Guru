import { Component, OnInit, NgZone } from '@angular/core';
import { AuthService } from 'src/app/shared/services/auth.service';
import { Router } from '@angular/router';
declare var jQuery: any;
@Component({
  selector: 'app-user-profile',
  templateUrl: './user-profile.component.html',
  styleUrls: ['./user-profile.component.css']
})
export class UserProfileComponent implements OnInit {
  questions: any;
  answers: any;
  
  editAnswer : any;
  editQuestionDetails : any;
  editAnswerDetails : any;

  constructor(
    public authService: AuthService,
    public router: Router,
    public ngZone: NgZone,
    private userService: AuthService,
  ) {
    this.editQuestionDetails = { editQuestion :'',question:''},
    this.editAnswerDetails = { editAnswer :'' , answer:''}
   }

  ngOnInit(): void {
  }
  
  showDetailsPage(): void {
    this.router.navigate(['show-details']);
    console.log(this.userService.userData.uid);
  }

  showSaveDetailsPage(): void {
    this.router.navigate(['savedetails']);
  }
  showForumsPage(): void {
    this.router.navigate(['forum']);
  }

  showBillsPage(): void {
    this.router.navigate(['bills']);
  }
  showAnalysisPage(): void {
    this.router.navigate(['yearly-analysis']);
  }

  yourQuestions(): any {
    console.log(this.userService.userData.email);
    this.authService.getMyQuestions(this.userService.userData.email).subscribe((result: any) => { console.log(result); this.questions = result; });
  }

  yourAnswers(): any {
    this.authService.getMyAnswers(this.userService.userData.email).subscribe((result: any) => { console.log(result); this.answers = result; });
  }

  showEditPopup(question) {
    this.editQuestionDetails.question = question;
    this.editQuestionDetails.editQuestion = question;
    jQuery('#editQuestionModel').modal('show');
  }

  showEditAnsPopup(answer) {
    console.log('popup');
    this.editAnswerDetails.answer = answer;
    this.editAnswerDetails.editAnswer = answer;
    jQuery('#editAnswerModel').modal('show');
  }

  updateQuestion(): any {
    
    this.authService.updateQuestion(this.editQuestionDetails).subscribe();
  }

  updateAnswer() : any {
    this.authService.updateAnswer(this.editAnswerDetails).subscribe();
  }

  deleteQuestion(question) {
    this.authService.deleteQuestion(question).subscribe((result: any) => {
      const i = this.questions.findIndex((element: any) => element === question);
      this.questions.splice(i, 1);
    });

  }

  deleteAnswer(answer) {
    console.log(answer);
    this.authService.deleteAnswer(answer).subscribe((result: any) => {
      const i = this.answers.findIndex((element: any) => element === answer);
      this.answers.splice(i, 1);
    });

  }

}

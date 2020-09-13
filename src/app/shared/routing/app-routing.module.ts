import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';

import { SignInComponent } from '../../components/sign-in/sign-in.component';
import { SignUpComponent } from '../../components/sign-up/sign-up.component';
import { DashboardComponent } from '../../components/dashboard/dashboard.component';
import { ForgotPasswordComponent } from '../../components/forgot-password/forgot-password.component';
import { VerifyEmailComponent } from '../../components/verify-email/verify-email.component';

import { AuthGuard } from "../../shared/guard/auth.guard";
import { ShowDetailsComponent } from '../../components/show-details/show-details.component';
import { SavedetailsComponent } from 'src/app/components/savedetails/savedetails.component';
import { BillsComponent } from 'src/app/components/bills/bills.component';
import { HomeComponent } from 'src/app/components/home/home.component';
import { YearlyAnalysisComponent } from 'src/app/components/yearly-analysis/yearly-analysis.component';
import { UserProfileComponent } from 'src/app/components/user-profile/user-profile.component';
import { ForumComponent } from 'src/app/components/forum/forum.component';
import { ShowAnswersComponent } from 'src/app/components/show-answers/show-answers.component';
const routes: Routes = [
  { path: '', redirectTo: '/home', pathMatch: 'full'},
  { path: 'home', component: HomeComponent},
  { path: 'sign-in', component: SignInComponent},
  { path: 'register-user', component: SignUpComponent},
  { path: 'dashboard', component: DashboardComponent, canActivate: [AuthGuard] },
  { path: 'forgot-password', component: ForgotPasswordComponent },
  { path: 'verify-email-address', component: VerifyEmailComponent },
  { path: 'show-details' , component: ShowDetailsComponent, canActivate: [AuthGuard]},
  { path: 'savedetails' , component : SavedetailsComponent, canActivate : [AuthGuard]},
  { path: 'bills' , component : BillsComponent, canActivate : [AuthGuard]},
  { path: 'yearly-analysis', component : YearlyAnalysisComponent , canActivate : [AuthGuard]},
  { path: 'user-profile' , component : UserProfileComponent, canActivate : [AuthGuard]},
  { path: 'forum' , component : ForumComponent , canActivate : [AuthGuard]},
  { path: 'show-answers' , component : ShowAnswersComponent , canActivate : [AuthGuard]}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})

export class AppRoutingModule { }

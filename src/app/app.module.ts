import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import {HttpClientModule} from '@angular/common/http';

// Reactive Form
import { ReactiveFormsModule, FormsModule } from "@angular/forms";

// App routing modules
import { AppRoutingModule } from './shared/routing/app-routing.module';

// App components
import { AppComponent } from './app.component';
import { SignInComponent } from './components/sign-in/sign-in.component';
import { SignUpComponent } from './components/sign-up/sign-up.component';
import { DashboardComponent } from './components/dashboard/dashboard.component';
import { ForgotPasswordComponent } from './components/forgot-password/forgot-password.component';
import { VerifyEmailComponent } from './components/verify-email/verify-email.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
 
//import { ToastrModule } from 'ngx-toastr';



// Firebase services + enviorment module
import { AngularFireModule } from "@angular/fire";
import { AngularFireAuthModule } from "@angular/fire/auth";
import { AngularFirestoreModule } from '@angular/fire/firestore';
import { environment } from '../environments/environment';

// Auth service
import { AuthService } from "./shared/services/auth.service";
import { ShowDetailsComponent } from './components/show-details/show-details.component';
import { SavedetailsComponent } from './components/savedetails/savedetails.component';
import { BillsComponent } from './components/bills/bills.component';
import { HomeComponent } from './components/home/home.component';
import { YearlyAnalysisComponent } from './components/yearly-analysis/yearly-analysis.component';
import { UserProfileComponent } from './components/user-profile/user-profile.component';
import { ForumComponent } from './components/forum/forum.component';
import { ShowAnswersComponent } from './components/show-answers/show-answers.component';

@NgModule({
  declarations: [
    AppComponent,
    SignInComponent,
    SignUpComponent,
    DashboardComponent,
    ForgotPasswordComponent,
    VerifyEmailComponent,
    ShowDetailsComponent,
    SavedetailsComponent,
    BillsComponent,
    HomeComponent,
    YearlyAnalysisComponent,
    UserProfileComponent,
    ForumComponent,
    ShowAnswersComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    AngularFireModule.initializeApp(environment.firebase),
    AngularFireAuthModule,
    AngularFirestoreModule,
    ReactiveFormsModule,
    FormsModule,
    HttpClientModule,
    /*BrowserAnimationsModule, // required animations module
    ToastrModule.forRoot(), // ToastrModule added*/
    
    
  ],
  providers: [AuthService],
  bootstrap: [AppComponent]
})

export class AppModule { }
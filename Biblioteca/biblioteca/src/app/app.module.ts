import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { SessionComponent } from './session/session.component';
import { DasboardComponent } from './dasboard/dasboard.component';
import { LoginComponent } from './session/login/login.component';
import { SignupComponent } from './session/signup/signup.component';
import { HomeComponent } from './dasboard/home/home.component';

@NgModule({
  declarations: [
    AppComponent,
    SessionComponent,
    DasboardComponent,
    LoginComponent,
    SignupComponent,
    HomeComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }

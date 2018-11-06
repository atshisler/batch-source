import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';

import { AppComponent } from './app.component';
import { DisplayUserComponent } from './display-user/display-user.component';
import { RadioButtonExampleComponent } from './radio-button-example/radio-button-example.component';
import { PeopleTableComponent } from './people-table/people-table.component';
import { GrabListOfusersComponent } from './grab-list-ofusers/grab-list-ofusers.component';
import { AppRoutingModule } from './app-routing.module';
import { RouterModule } from '@angular/router';

@NgModule({
  declarations: [
    AppComponent,
    DisplayUserComponent,
    RadioButtonExampleComponent,
    PeopleTableComponent,
    GrabListOfusersComponent
  ],
  imports: [
    BrowserModule,
    FormsModule,
    AppRoutingModule,
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }

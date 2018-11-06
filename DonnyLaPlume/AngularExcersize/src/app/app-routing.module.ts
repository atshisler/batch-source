import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterModule, Routes } from '@angular/router';
import { DisplayUserComponent } from './display-user/display-user.component'
import { GrabListOfusersComponent } from './grab-list-ofusers/grab-list-ofusers.component'
import { PeopleTableComponent } from './people-table/people-table.component'
import { RadioButtonExampleComponent } from './radio-button-example/radio-button-example.component'


const routes: Routes = [
  { path: 'display-user', component: DisplayUserComponent},
  { path: 'grab-list', component: GrabListOfusersComponent },
  { path: 'people-table', component: PeopleTableComponent },
  { path: 'radio-button', component: RadioButtonExampleComponent },
  { path: '', redirectTo: "/display-user", pathMatch: 'full' }
];

@NgModule({
  declarations: [],
  imports: [
    CommonModule,
    RouterModule.forRoot(routes) 
  ],
  exports: [ RouterModule ]
})
export class AppRoutingModule { }

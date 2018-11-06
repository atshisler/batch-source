import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterModule, Routes } from '@angular/router'
import { HighlightComponent } from './highlight/highlight.component'
import { ProfileComponent } from './profile/profile.component'
import { SelectComponent } from './select/select.component'
import { TableComponent } from './table/table.component'
import { UserComponentComponent } from './user-component/user-component.component'

const routes: Routes = [
  { path: 'highlight', component: HighlightComponent},
  { path: 'select', component: SelectComponent},
  { path: 'table', component: TableComponent},
  { path: 'profile', component: ProfileComponent},
  { path: 'userComponent', component: UserComponentComponent}
];

@NgModule({
  imports: [
    CommonModule,
    RouterModule.forRoot(routes)
  ],
  exports: [ RouterModule ]
})
export class AppRoutingModule { }

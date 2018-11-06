import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterModule } from '@angular/router';
import { HighlightComponent } from 'src/app/highlight/highlight.component';
import { TableComponent } from 'src/app/table/table.component';
import { UserComponent } from 'src/app/user/user.component';
import { SelectRadiosComponent } from 'src/app/select-radios/select-radios.component';
import { ProfileComponent } from 'src/app/profile/profile.component';

const routes = [
  { path: 'highlight', component: HighlightComponent },
  { path: 'table', component: TableComponent },
  { path: 'user', component: UserComponent },
  { path: 'select-radios', component: SelectRadiosComponent },
  { path: 'profiles', component: ProfileComponent },
]

@NgModule({
  declarations: [],
  imports: [
    CommonModule,
    RouterModule.forRoot(routes),
  ],
  exports: [ RouterModule ]
})
export class NavModule { }

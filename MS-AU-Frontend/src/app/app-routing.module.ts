import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AuditComponent } from './dashboard/audit/audit.component';
import { DashboardComponent } from './dashboard/dashboard.component';
import { OpportunityComponent } from './dashboard/opportunity/opportunity.component';
import { SearchComponent } from './dashboard/search/search.component';
import { TrendComponent } from './dashboard/trend/trend.component';
import { LoginComponent } from './login/login.component';


 
const routes: Routes = [ 
  { path: 'dashboard', component: DashboardComponent,
children: [
        { path: '', redirectTo: '/dashboard/opportunity', pathMatch: 'full' },
        { path: 'opportunity', component: OpportunityComponent },
        { path: 'search', component: SearchComponent },
        { path: 'trend', component: TrendComponent },
        { path: 'audit', component: AuditComponent }
      ] },
      {path: '', pathMatch: 'full', component: LoginComponent},    
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }

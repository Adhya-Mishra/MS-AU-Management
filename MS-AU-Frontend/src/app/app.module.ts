import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { MatSliderModule } from '@angular/material/slider';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { DashboardComponent } from './dashboard/dashboard.component';
import { LoginComponent } from './login/login.component';
import { SearchComponent } from './dashboard/search/search.component';
import { TrendComponent } from './dashboard/trend/trend.component';
import { AuditComponent } from './dashboard/audit/audit.component';
import { OpportunityComponent } from './dashboard/opportunity/opportunity.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { ChartsModule } from 'ng2-charts';
import {MatFormFieldModule} from '@angular/material/form-field';
import {MatButtonModule} from '@angular/material/button';
import { MatCardModule } from '@angular/material/card';
import {MatToolbarModule} from '@angular/material/toolbar';
import {MatIconModule} from '@angular/material/icon';

import {MatMenuModule} from '@angular/material/menu';
import {MatPaginatorModule} from '@angular/material/paginator';
import {MatSelectModule} from '@angular/material/select';
import {MatInputModule} from '@angular/material/input';
import {MatSortModule} from '@angular/material/sort';
import {MatTableModule} from '@angular/material/table';
import {MatSnackBarModule} from '@angular/material/snack-bar';
import {MatDialogModule} from '@angular/material/dialog';
import {MatGridListModule} from '@angular/material/grid-list';

import {SocialAuthServiceConfig,SocialLoginModule, GoogleLoginProvider} from 'angularx-social-login';
import { SearchService } from './dashboard/search/search.service';
import { UserService } from './user.service';
import { DashboardService } from './dashboard/dashboard.service';
import { TrendService } from './dashboard/trend/trend.service';
import {  FormsModule, ReactiveFormsModule } from '@angular/forms';
import {  HttpClientModule } from '@angular/common/http';
import { RouterModule, ROUTES } from '@angular/router';
import { LoginService } from './login/login.service';
import { OpportunityService } from './dashboard/opportunity/opportunity.service';

import { BarChartComponent } from './dashboard/bar-chart/bar-chart.component';

@NgModule({
  declarations: [
    AppComponent,
    DashboardComponent,
    LoginComponent,
    SearchComponent,
    TrendComponent,
    AuditComponent,
    OpportunityComponent,

    BarChartComponent
  ],
  imports: [
    BrowserModule,
  
    AppRoutingModule,
    FormsModule,
     ReactiveFormsModule,
   BrowserAnimationsModule,
    MatSliderModule,
    MatButtonModule,
    MatToolbarModule,
    MatIconModule,
    MatCardModule,
    MatMenuModule,
    MatPaginatorModule,
    MatSelectModule,
    MatInputModule,
    MatSortModule,
    MatTableModule,
    MatSnackBarModule,
    MatDialogModule,
    ChartsModule,
    MatGridListModule,
    HttpClientModule,
    
    MatFormFieldModule,
    SocialLoginModule
    
  ],
  providers: [
    {
      provide: 'SocialAuthServiceConfig',
      useValue: {
        autoLogin: false,
        providers: [
          {
            id: GoogleLoginProvider.PROVIDER_ID,
            provider: new GoogleLoginProvider(
              '41519741740-6vrjgqdov7nn4ljam2iu04plidhv17eu.apps.googleusercontent.com'
            )
          },
        ]
      } as SocialAuthServiceConfig,
    },UserService, DashboardService,SearchService,LoginService,OpportunityService
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }

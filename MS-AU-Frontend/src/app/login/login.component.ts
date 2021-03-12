import { Component, ElementRef, NgZone, OnInit, TemplateRef, ViewChild } from '@angular/core';
import { FormBuilder, FormControl, FormGroup, NgModel, Validators } from '@angular/forms';
import { Router } from '@angular/router';

import { HttpClient} from '@angular/common/http';
import { SocialAuthService } from "angularx-social-login";
import { SocialUser} from "angularx-social-login";
import{GoogleLoginProvider} from 'angularx-social-login';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.scss']
})
export class LoginComponent implements OnInit {

  user: SocialUser=new SocialUser() ;

  
  constructor(private authService: SocialAuthService,private router: Router){}
  signInWithGoogle(): void {
    this.authService.signIn(GoogleLoginProvider.PROVIDER_ID).then((user)=>{
      localStorage.setItem('idToken', user.idToken);
      localStorage.setItem('userId', user.id);
      this.router.navigate(['/dashboard']);

    });
  }
  signOut(): void {
    this.authService.signOut().then(()=>{
      localStorage.removeItem('idToken');
      localStorage.removeItem('userId');
      console.log("removed")
    }, error => {
      console.log(error); 
    });
  }

  ngOnInit(): void {
    if (localStorage.getItem('idToken')){
      this.router.navigate(['/dashboard']);
    }

    this.authService.authState.subscribe((user)=>{
      this.user=user;

      console.log(user);
    })

    }
  
}
    
  




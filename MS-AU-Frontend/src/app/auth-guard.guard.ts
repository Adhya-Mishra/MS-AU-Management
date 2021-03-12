import { Injectable } from '@angular/core';
import { CanActivate, ActivatedRouteSnapshot, RouterStateSnapshot, UrlTree, Router } from '@angular/router';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class AuthGuardGuard implements CanActivate {
  constructor( private router: Router) {}
  canActivate(
    route: ActivatedRouteSnapshot,
   
    state: RouterStateSnapshot): boolean {
     
      if (localStorage.getItem('idToken')){
        return true;
      }
      this.router.navigate(['']);
      return false;  
  }
  
}

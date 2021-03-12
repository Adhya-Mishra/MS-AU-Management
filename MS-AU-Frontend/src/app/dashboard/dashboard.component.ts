import { ViewChild } from '@angular/core';
import { Component, OnInit, TemplateRef } from '@angular/core';
import { MatDialog, MatDialogConfig, MatDialogRef } from '@angular/material/dialog';
import { Router } from '@angular/router';
import { LoginService } from '../login/login.service';
import { UserService } from '../user.service';

@Component({
  selector: 'app-dashboard',
  templateUrl: './dashboard.component.html',
  styleUrls: ['./dashboard.component.scss']
})
export class DashboardComponent implements OnInit {
  ImageURL:any;
  public isActive1!: boolean;
  public isActive2!:boolean;
  public isActive3!:boolean;
  public isActive4!:boolean;
  public isClicked:boolean[] | undefined;
  public User!: UserInfo;

  @ViewChild('Display')
  detailTemplate!: TemplateRef<any>;
  private detailDialog!: MatDialogRef<TemplateRef<any>>;

  @ViewChild('Query')
  queryTemplate!: TemplateRef<any>;
  private queryDialog!: MatDialogRef<TemplateRef<any>>;
  id: any;
  
  constructor( private router: Router, public dialog: MatDialog, private loginservice: LoginService, private userService: UserService) { }
  Email:any;
  
  ngOnInit(): void {
 
    this.Email = localStorage.getItem('email');
    this.ImageURL = localStorage.getItem('ImageURL');
    this.isActive2=true;
  }

 

  public myProfile(){
    this.userService.getCurrentUser().subscribe((user:any)=>{  
      this.User = new UserInfo(user.userId,user.gid,this.ImageURL,user.name,this.Email);
      const dialogConfig = new MatDialogConfig();
      dialogConfig.restoreFocus = false;
      dialogConfig.autoFocus = false;
      dialogConfig.role = 'dialog';
      dialogConfig.disableClose = true;
      this.detailDialog= this.dialog.open(this.detailTemplate, dialogConfig);
    });
  };

  public logOut(){
 
    alert("Are you sure you want to log out?");
    localStorage.clear();
    this.router.navigate(['']);
  }
}

class UserInfo{
  UserName:string;
  UserId: string;
  UserImage: string;
  UserGid: string;
  UserEmail: string;
  constructor(userId:any, gid:any, image:any, name:any, email:any ){
    this.UserId = userId;
    this.UserGid= gid;
    this.UserImage = image;
    this.UserName = name;
    this.UserEmail=email;
  }

}

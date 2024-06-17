import { Component, OnInit } from '@angular/core';
import { Router, RouterOutlet } from '@angular/router';
import { RouterLink } from '@angular/router';
import { RouterLinkActive } from '@angular/router';
import { LoginService } from '../../Services/login.service';

@Component({
  selector: 'app-header',
  standalone: true,
  imports: [RouterOutlet,RouterLink,RouterLinkActive],
  templateUrl: './header.component.html',
  styleUrl: './header.component.css'
})
export class HeaderComponent implements OnInit {
  username:any;
constructor(private router:Router, public loginService:LoginService ){

}

  ngOnInit(): void {
     this.username=localStorage.getItem("username")

    
    
  }
  


}

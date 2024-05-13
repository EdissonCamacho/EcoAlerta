import { Component } from '@angular/core';
import { RouterOutlet } from '@angular/router';
import { CarruselComponent } from './components/carrusel/carrusel.component';
import { FooterComponent } from './components/footer/footer.component';
import { HeaderComponent } from './components/header/header.component';
import { NavComponent } from './components/nav/nav.component';
import { SeccionComponent } from './components/seccion/seccion.component';
@Component({
  selector: 'app-root',
  standalone: true,
  imports: [RouterOutlet, HeaderComponent, NavComponent, CarruselComponent, SeccionComponent, FooterComponent],
  templateUrl: './app.component.html',
  styleUrl: './app.component.css'
})
export class AppComponent {
  title = 'ecoalerta';
}

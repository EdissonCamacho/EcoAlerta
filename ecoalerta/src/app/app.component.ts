import { Component } from '@angular/core';
import { RouterOutlet } from '@angular/router';
import { CarruselComponent } from './components/carrusel/carrusel.component';
@Component({
  selector: 'app-root',
  standalone: true,
  imports: [RouterOutlet, CarruselComponent],
  templateUrl: './app.component.html',
  styleUrl: './app.component.css'
})
export class AppComponent {
  title = 'ecoalerta';
}

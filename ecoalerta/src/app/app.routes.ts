import { Routes } from '@angular/router';
import { CarruselComponent } from './components/carrusel/carrusel.component';
import { PaginationComponent } from './components/pagination/pagination.component';

export const routes: Routes = [
    {
        path:"",component:CarruselComponent
    },
    {path:"referencias",component:PaginationComponent}


];

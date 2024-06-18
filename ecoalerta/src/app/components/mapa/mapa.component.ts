import { Component } from '@angular/core';
import * as L from 'leaflet';

@Component({
  selector: 'app-mapa',
  standalone: true,
  imports: [],
  templateUrl: './mapa.component.html',
  styleUrl: './mapa.component.css'
})
export class MapaComponent {

  title = 'mapas';
  map: any
  ngOnInit(): void {
    var map = L.map('map').setView([5.57, -73.42], 8);
    L.tileLayer('https://tile.openstreetmap.org/{z}/{x}/{y}.png', {
      maxZoom: 19,
      attribution: '&copy; <a href="http://www.openstreetmap.org/copyright">OpenStreetMap</a>'
    }).addTo(map);

    //iconos


    //markers
    var marker = L.marker([5.11, -73.14]).addTo(map)
      .bindPopup("Capital del Departamento de Boyacá").openPopup();
    var circle = L.circle([4.5333, -73.7], {
      color: 'red',
      fillColor: '#f03',
      fillOpacity: 0.5,
      radius: 1000
    }).addTo(map).bindPopup("Area Protegida Laguna Sucunca");

    var treeDown = L.icon({
      iconUrl: 'assets/images/arbolCaido.png',


      iconSize: [38, 95], // size of the icon
      shadowSize: [50, 64], // size of the shadow
      iconAnchor: [22, 94], // point of the icon which will correspond to marker's location
      shadowAnchor: [4, 62],  // the same for the shadow
      popupAnchor: [-3, -76] // point from which the popup should open relative to the iconAnchor
    });

    var marker3 = L.marker([5.9667, -74.5833], { icon: treeDown }).addTo(map).bindPopup("Puerto Boyaca, Perdida:8.83 kha ").openPopup();
    var marker4 = L.marker([5.6577, -74.1805], { icon: treeDown }).addTo(map).bindPopup("Otanche, Perdida:3.01 kha ").openPopup();
    var marker5 = L.marker([7.0000, -72.1080], { icon: treeDown }).addTo(map).bindPopup("Cubará, Perdida:2.12 kha ").openPopup();
    var marker6 = L.marker([5.6252, -72.4238], { icon: treeDown }).addTo(map).bindPopup("Paya, Perdida:2.11 kha ").openPopup();
    var marker7 = L.marker([5.5633, -72.5775], { icon: treeDown }).addTo(map).bindPopup("Labranzagrande, Perdida:1.16 kha ").openPopup();



    var areaProtegida = L.icon({
      iconUrl: 'assets/images/areaProtegida.png',


      iconSize: [50, 50], // size of the icon
      shadowSize: [50, 64], // size of the shadow
      iconAnchor: [22, 94], // point of the icon which will correspond to marker's location
      shadowAnchor: [4, 62],  // the same for the shadow
      popupAnchor: [-3, -76] // point from which the popup should open relative to the iconAnchor
    });
    
    var marker7 = L.marker([5.196388, -73.14444], { icon: areaProtegida }).addTo(map).bindPopup("Area Protegida,La Cuchilla de Sucuncuca").openPopup();
    var marker8 = L.marker([5.4921073, -73.4954797], { icon: areaProtegida }).addTo(map).bindPopup("Area Protegida,El malmo").openPopup();
    var marker8 = L.marker([5.6397737, -72.8323404], { icon: areaProtegida }).addTo(map).bindPopup("Area Protegida,Siscunsí-Ocetá").openPopup();
    var marker8 = L.marker([5.4172221, -73.5663889], { icon: areaProtegida }).addTo(map).bindPopup("Area Protegida,Paramo Rabanal").openPopup();



  }





}

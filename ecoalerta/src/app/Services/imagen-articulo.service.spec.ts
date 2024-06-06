import { TestBed } from '@angular/core/testing';

import { ImagenArticuloService } from './imagen-articulo.service';

describe('ImagenArticuloService', () => {
  let service: ImagenArticuloService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(ImagenArticuloService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});

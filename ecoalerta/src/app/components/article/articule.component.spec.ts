import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ArticuleComponent } from './articule.component';

describe('ArticuleComponent', () => {
  let component: ArticuleComponent;
  let fixture: ComponentFixture<ArticuleComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [ArticuleComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(ArticuleComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

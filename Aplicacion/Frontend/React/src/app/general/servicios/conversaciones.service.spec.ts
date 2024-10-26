/* tslint:disable:no-unused-variable */

import { TestBed, async, inject } from '@angular/core/testing';
import { ConversacionesService } from './conversaciones.service';

describe('Service: Conversaciones', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [ConversacionesService]
    });
  });

  it('should ...', inject([ConversacionesService], (service: ConversacionesService) => {
    expect(service).toBeTruthy();
  }));
});

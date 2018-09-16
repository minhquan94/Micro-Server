import { Injectable } from '@angular/core';

@Injectable()
export class CommonService {

  constructor() { }

  getWebTile() {
    return 'WebFlux Angular 6';
  }
}

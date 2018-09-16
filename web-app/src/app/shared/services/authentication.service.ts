import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { map } from 'rxjs/operators';
import { User } from '../../core/model/users';

@Injectable({
  providedIn: 'root'
})
export class AuthenticationService {

  constructor(private httpClient: HttpClient) { }

  login(userLogin: User): Observable<any> {
    const username = userLogin.username;
    const password = userLogin.password;
    return this.httpClient.post<any>('http://localhost:8080/rest/login/admin', userLogin).pipe(map(user => {
      // login successful if there's a jwt token in the response
      if (user && user.token) {
        // store user details and jwt token in local storage to keep user logged in between page refreshes
        localStorage.setItem('currentUser', JSON.stringify(user));
      }
      return user;
    }));
  }

  logout() {
    localStorage.removeItem('currentUser');
    return this.httpClient.post<any>('http://localhost:8080/rest/login/logout', null).pipe(map(user => {
      // login successful if there's a jwt token in the response
      if (user && user.token) {
        // store user details and jwt token in local storage to keep user logged in between page refreshes
        localStorage.setItem('currentUser', JSON.stringify(user));
      }
      return user;
    }));
  }
}

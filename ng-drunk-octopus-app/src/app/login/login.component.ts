import { Component, OnInit } from '@angular/core';
import { Headers, Http } from "@angular/http";

import { User } from '../user'

@Component({
    selector: 'login',
    templateUrl: './login.component.html'
})
export class LoginComponent implements OnInit{
    private headers = new Headers({'Content-Type': 'application/json'});
    ngOnInit(): void {
    }
    constructor(private http: Http){

    }

    login(username: string, password: string): Promise<User> {
        console.log("doing login method angular side");
        return this.http
        .post('test', JSON.stringify({username: username, password: password}), {headers: this.headers})
        .toPromise()
        .then(res => res.json() as User)
        .catch(this.handleError);
    }

    private handleError(error: any): Promise<any> {
        console.error('An error occurred', error); //for demo purposes
        return Promise.reject(error.message || error);
    }
}
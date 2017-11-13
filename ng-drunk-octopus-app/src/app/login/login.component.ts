import { Component, OnInit } from '@angular/core';
import { Headers, Http } from "@angular/http";

import { User } from '../user'

@Component({
    selector: 'the-login',
    templateUrl: './login.component.html'
})
export class LoginComponent implements OnInit{
    user: User;
    users: User[];
    test: User;
    private headers = new Headers({'Content-Type': 'application/json'});
    ngOnInit(): void {
        this.getData();
        this.getUsers().then(userList => this.users = userList);
    }
    constructor(private http: Http){

    }

    testAdd(): void {
        this.test = {id: 1, firstName: "Ima", lastName: "Test", username: "herpa", password: "derpa"}
        this.users.push(this.test);
    }

    login(username: string, password: string): Promise<User> {
        console.log("doing login method angular side");
        console.log("input: "+username+" "+password);
        return this.http
        .get('login-service/test')
        .toPromise()
        .then(res => res.json() as User)
        .catch(this.handleError);
        // .post('login-service/test', JSON.stringify({username: username, password: password}), {headers: this.headers})
        // .toPromise()
        // .then(res => res.json() as User)
        // .catch(this.handleError);
    }

    getUsers(): Promise<User[]> {
        return this.http.get('login-service/getAllUsers')
            .toPromise()
            .then(response => response.json() as User[])
            .catch(this.handleError);
    }

    addUser(firstName: string, lastName: string, username: string, password: string): void {
        this.register(firstName, lastName, username, password).then(user => this.users.push(user));
    }

    register(firstName: string, lastName: string, username: string, password: string): Promise<User> {
        return this.http
            .post('login-service/addUser', JSON.stringify({firstName: firstName, lastName: lastName, 
                username: username, password: password}), {headers: this.headers})
            .toPromise()
            .then(res => res.json() as User)
            .catch(this.handleError);
    }

    getData(): void {
        this.login("some", "data").then(user => this.user = user);
    }

    private handleError(error: any): Promise<any> {
        console.error('An error occurred', error); //for demo purposes
        return Promise.reject(error.message || error);
    }
}
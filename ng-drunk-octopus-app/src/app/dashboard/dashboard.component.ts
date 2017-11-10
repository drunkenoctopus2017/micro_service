import { Component, OnInit } from '@angular/core';


@Component({
    selector: 'my-dashboard',
    templateUrl: './dashboard.component.html',//'<h3>My Dashboard</h3>'
    styleUrls: ['./dashboard.component.css'],
})
export class DashboardComponent implements OnInit{
    ngOnInit(): void {
    }
    constructor() {}
}
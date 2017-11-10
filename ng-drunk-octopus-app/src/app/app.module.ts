import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule }    from '@angular/forms'; // <--ngModel lives here!
import { HttpModule }     from '@angular/http';

import { AppComponent } from './app.component';
import { DashboardComponent }   from './dashboard/dashboard.component';

@NgModule({
  declarations: [
    AppComponent
  ],
  imports: [
    BrowserModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }

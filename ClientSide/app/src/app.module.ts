import {NgModule} from '@angular/core';
import {BrowserModule} from '@angular/platform-browser';
import {FormsModule} from '@angular/forms';
import {HttpModule} from '@angular/http';
import {CustomerSearchComponent} from "./customer.component";
import {LoginComponent} from "./login.component"
import {configuredRoutes} from "./routes.config";
import {AppComponent} from "./app.component";
import {AccessoriesComponent} from "./accessories.component";
import {ReportComponent} from "./report.component";


@NgModule({
    imports: [BrowserModule, FormsModule, HttpModule, configuredRoutes],
    declarations: [CustomerSearchComponent, LoginComponent, AppComponent,AccessoriesComponent,ReportComponent],
    bootstrap: [AppComponent]
})
export class AppModule {
}


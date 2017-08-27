import {Routes, RouterModule} from '@angular/router';
import {CustomerSearchComponent} from "./customer.component";
import {LoginComponent} from "./login.component";
import {AccessoriesComponent} from "./accessories.component";
import {ReportComponent} from "./report.component";


let routes: Routes = [
    {path: 'login', component: LoginComponent},
    {path: 'customer/:mid', component: CustomerSearchComponent},
    {path: 'accessories', component: AccessoriesComponent,data:{vin:'',model:'',make:'',price:'',trim:'',year:'',logo:''}},
    {path: 'report/:vin', component: ReportComponent},
    {path: '', redirectTo: '/login', pathMatch: 'full'}
];

export const configuredRoutes = RouterModule.forRoot(routes);
import {Component, Input, OnInit} from "@angular/core";
import {Http,Headers,RequestOptions} from "@angular/http";

import {Car} from "./car";
import {Customer} from "./customer";
import {ActivatedRoute, Router} from "@angular/router";

@Component({
    selector:'customer',
    templateUrl:'../partials/customer.component.html',
    styleUrls:['../css/customer.component.styles.css'],
})
export class CustomerSearchComponent implements  OnInit{

   customers:Customer[];
    uid:number;
    selectedCar:string;
    carToPass:Car;
    @Input() customer:Customer;

    constructor(private http:Http,private activatedRoute:ActivatedRoute,private router: Router) {

        this.activatedRoute.params.subscribe((prms)=>{
            this.uid = parseInt(prms['mid']);
        });

    }

    ngOnInit(){
        //calling rest api
        this.showCustomers();
    }

    showCustomers() {

       //rest URL
       var searchURL = "http://localhost:5000/rest/customer/"+this.uid;
       var requestHeaders = new Headers({'Accept': 'application/json'});
       var options = new RequestOptions({headers: requestHeaders});

       //wrapping for multiple elements in json[]

        this.http.get(searchURL, options).subscribe(res => {this.customers = [res.json()];
            console.log('getting list of cars of a customer'); //list of customer and its cars
        });
    }
    goToAccessories() {
        this.router.navigate(['/accessories', this.carToPass]);
        console.log('going to accessory page');
    }

    logout() {
        this.router.navigate(['/login']);
        console.log('logging out !');
    }
    status(car:Car){
        this.carToPass = car;
        this.selectedCar = car.make +'-' +car.model;
    }
}



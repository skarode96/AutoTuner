import {Component, OnInit} from "@angular/core";
import {Headers, Http, RequestOptions} from "@angular/http";

import {ActivatedRoute, Router} from "@angular/router";
import {Task} from "./Task";
import {forEach} from "@angular/router/src/utils/collection";



@Component({
    selector: 'report',
    templateUrl: '../partials/report.component.html',
    styleUrls: ['../css/report.component.styles.css'],
})
export class ReportComponent implements OnInit {

    title: String = "Customization Report";
    taskDetails: Task[];
    successMessage: string;
    errorMessage: string;
    vin: number;
    totalPrice: number = 0;

    calculate() {
        this.totalPrice = 0;
        this.taskDetails.forEach(element =>{
            this.totalPrice = this.totalPrice + element.price;
        });
        console.log('calculating total',this.totalPrice);
    }

    constructor(private http: Http, private activatedRoute: ActivatedRoute, private router: Router) {
        this.activatedRoute.params.subscribe((prms) => {
            this.vin = parseInt(prms['vin']);
        });
        this.totalPrice = 0;
    }

    ngOnInit() {
        //hit rest URL for getting report
        this.reportGeneration();
        console.log(this.taskDetails);
    }

    reportGeneration() {

        var addUrl = "http://localhost:5000/rest/report/"+this.vin;
        var requestHeaders = new Headers({'Accept': 'application/json'});
        var options = new RequestOptions({headers: requestHeaders});

        this.http.get(addUrl, options).subscribe(res => {
            this.taskDetails = res.json();
            console.log("in get " ,res.json());
            console.log("checking task details",this.taskDetails);
            this.calculate();
        });
    }
}




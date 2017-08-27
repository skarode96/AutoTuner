import {Component, OnInit} from "@angular/core";
import {Http, Headers, RequestOptions} from "@angular/http";
import {Customizer} from "./customizer";
import {ActivatedRoute, Router} from "@angular/router";

@Component({
    selector: 'customizer',
    templateUrl: '../partials/customizer.component.html',
    styleUrls: ['../css/customizer.component.styles.css'],
})
export class CustomizerComponent implements OnInit {

    customizers: Customizer[];
    selectedCustomizer: string;

    constructor(private http: Http,private router: Router) {

    }

    ngOnInit() {
        this.showCustomizers();
    }

    showCustomizers() {
        console.log("Inside showCustomizers()!!!!");
        // console.log(this.uid);

        var searchURL = "http://localhost:5000/rest/customizers";


        var requestHeaders = new Headers({'Accept': 'application/json'});
        var options = new RequestOptions({headers: requestHeaders});

        this.http.get(searchURL, options).subscribe(res => {
            this.customizers = res.json(); //customizer list
            console.log(this.customizers);
        });

    }

    logout() {
        this.router.navigate(['/login']);
    }

    status(customizer: Customizer) {
        this.selectedCustomizer = customizer.name + ' with rating ' + customizer.rating + ' has been selected';
        console.log("car", customizer);
    }
}



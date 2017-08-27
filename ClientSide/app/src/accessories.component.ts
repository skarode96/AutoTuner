import {Component, Optional} from "@angular/core";
import {Http, Headers, RequestOptions} from "@angular/http";
import {Accessories} from "./accessories";
import {ActivatedRoute, Router} from "@angular/router";
import {Car} from "./car";
import {Customizer} from "./customizer";
import {Task} from "./Task";
import {forEach} from "@angular/router/src/utils/collection";


@Component({
    selector: 'accessories',
    templateUrl: '../partials/accessories.component.html',
    providers: [Task],
})
export class AccessoriesComponent {


    title: string = "Accessories Form";
    accessories: Accessories;
    successMessage: string;
    errorMessage: string;
    tyres: string;
    paintJob: string;
    engine: string;
    music: string;
    brakes: string;
    headLights: string;
    wheels: string;
    sideMirrors: string;
    car: Car;
    flag: number;
    // flag1:number;
    customizers: Customizer[];
    selectedCustomizer: string[];
    artist: string;
    accessoryCustomizers: Customizer[];
    artistPrice: number;


    constructor(private http: Http, private router: Router, private activatedRoute: ActivatedRoute, private task: Task) {
        this.accessories = new Accessories(this.tyres, this.paintJob, this.engine, this.music, this.brakes, this.headLights, this.wheels, this.sideMirrors);
        this.activatedRoute
            .params
            .subscribe(v => {
                this.car = <Car>v;
            });
        this.artist = 'default';
        this.artistPrice = 0;
        console.log("Inside constructor...." + this.task);


    }


    onChange(arr: string[]) {
        console.log(arr);
        var customizerDetails = arr[0];
        var arr1 = customizerDetails.replace(']', '').substr(arr[0].indexOf(',') + 1);
        var arr2 = arr1.split(',');
        var id = customizerDetails.substr(1, customizerDetails.indexOf(',') - 1);
        this.artist = arr2[0];
        this.artistPrice = parseInt(arr2[1]);
        //Generating task json
        this.task.cId = parseInt(id);
        this.task.taskName = arr[1];
        this.task.vin = parseInt(arr[2]);
        this.task.price = this.artistPrice;
        // hit rest api for updating task
        this.updateTask(this.task);

    }

    updateTask(task: Task) {
        let addUrl = "http://localhost:5000/rest/addtask";
        var requestHeaders = new Headers({'Content-Type': 'application/json'});
        var options = new RequestOptions({headers: requestHeaders});
        this.http.post(addUrl, this.task, options).subscribe(
            res => {
                this.successMessage = res.toString();
                console.log(res.text());
                this.errorMessage = ""
            },
            error => {
                this.errorMessage = <any>error;
                this.successMessage = ""
            });
    }

    goToReport() {
        this.router.navigate(['/report/' + this.car.vin]);
    }

    getAccessoryCustomizers(category: string) {

        this.accessoryCustomizers = []; // clearing previous data in accessory customizer array
        var searchURL = "http://localhost:5000/rest/customizer/category/" + category;
        var requestHeaders = new Headers({'Accept': 'application/json'});
        var options = new RequestOptions({headers: requestHeaders});
        this.http.get(searchURL, options).subscribe(res => {
            this.accessoryCustomizers = res.json(); //customizer list
        });
    }

    customize(category: string) {
        console.log("Calling rest for " + category + " customizer");
        if (category == 'Tyres') {
            if (this.flag != 1) {
                this.flag = 1;
                this.getAccessoryCustomizers(category);
                this.artist = 'default';
            }
            else {
                this.flag = 0;
            }

        }
        if (category == 'Paint Job') {
            if (this.flag != 2) {
                this.flag = 2;
                this.getAccessoryCustomizers(category);
                this.artist = 'default';
            }
            else {
                this.flag = 0;
            }
        }
        if (category == 'Engine') {
            if (this.flag != 3) {
                this.flag = 3;
                this.getAccessoryCustomizers(category);
                this.artist = 'default';
            }
            else {
                this.flag = 0;
            }
        }
        if (category == 'Music') {
            if (this.flag != 4) {
                this.flag = 4;
                this.getAccessoryCustomizers(category);
                this.artist = 'default';
                this.artist = 'default';
            }
            else {
                this.flag = 0;
            }
        }
        if (category == 'Brakes') {
            if (this.flag != 5) {
                this.flag = 5;
                this.getAccessoryCustomizers(category);
                this.artist = 'default';
            }
            else {
                this.flag = 0;
            }
        }
        if (category == 'HeadLights') {
            if (this.flag != 6) {
                this.flag = 6;
                this.getAccessoryCustomizers(category);
                this.artist = 'default';
            }
            else {
                this.flag = 0;
            }
        }
        if (category == 'Wheels') {
            if (this.flag != 7) {
                this.flag = 7;
                this.getAccessoryCustomizers(category);
                this.artist = 'default';
            }
            else {
                this.flag = 0;
            }
        }
        if (category == 'SideMirrors') {
            if (this.flag != 8) {
                this.flag = 8;
                this.getAccessoryCustomizers(category);
                this.artist = 'default';
            }
            else {
                this.flag = 0;
            }
        }
    }
}




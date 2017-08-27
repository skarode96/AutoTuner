import {Component} from "@angular/core";
import {Http,Headers,RequestOptions} from "@angular/http";
import {ActivatedRoute, Router} from "@angular/router";

@Component({
    selector:'login',
    templateUrl:'../partials/login.component.html',
    styleUrls:['../css/login.component.styles.css'],
})
export class LoginComponent{
    username:string;
    password:string;
    title:string ="Login Form";

    loginDB = {"Sameer":{"password":"sameer123","uid":"13"},
                    "Yateesha":{"password":"yateesha123","uid":"12"},
                    "Snigdha":{"password":"snigdha123","uid":"14"},
                    "12":{"password":"12","uid":"13"}
    }

    successMessage:string = "";
    errorMessage:string = "";

    constructor(private http:Http, private router: Router) {

    }

    validate() {

        if (this.loginDB[this.username]["password"] == this.password) {
            console.log("login successful");
            this.successMessage = "Login successful";
            this.errorMessage = "";
            //uid to be caught using prms in subscribe
            this.router.navigate(['/customer/'+this.loginDB[this.username]["uid"]]);

    }else{
            this.errorMessage = "Login failed";
            this.successMessage = "";
        }

    }
}



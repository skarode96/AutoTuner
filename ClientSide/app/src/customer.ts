import {Car} from "./car";

export class Customer{


    uid:number;
    name:string = "";
    emailId:string = "";
    cars:Car[];


    constructor(uid: number, name: string, emailId: string, cars:Car[]) {
        this.uid = uid;
        this.name = name;
        this.emailId = emailId;
        this.cars = cars;
    }

}
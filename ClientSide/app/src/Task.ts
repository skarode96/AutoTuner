export class Task{

    taskName:string="";
    vin:number=0;
    cId:number=0;
    price:number=0;


    constructor(taskName: string = "", vin: number = 0, cId: number = 0,price:number = 0) {
        this.taskName = taskName;
        this.vin = vin;
        this.cId = cId;
        this.price = price;
    }
}
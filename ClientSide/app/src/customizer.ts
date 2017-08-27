
export class Customizer{
    cId:number;
    name:string = "";
    category:string = "";
    rating:number;
    price:number;

    constructor(cId: number, name: string, category: string, rating: number,price:number) {
        this.cId = cId;
        this.name = name;
        this.category = category;
        this.rating = rating;
        this.price = price;
    }

}
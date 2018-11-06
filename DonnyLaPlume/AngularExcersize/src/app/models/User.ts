export class Users {
    id : number;
    name : string;
    username : string;
    email : string;
    address : object;
    phone : number;
    website : string;
    company : object;

    constructor(i : number,j : number, n : string, o : string, p : string, q : string)
    {
        this.id = i;
        this.phone = j;
        this.name  = n;
        this.username = o;
        this.email = p;
        this.website = q;
    }
}
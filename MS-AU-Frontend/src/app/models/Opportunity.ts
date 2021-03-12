export class Opportunity {
    public opportunityId!: number;
    public description!: String;
    public date!: String;
    public skills: any;
    public location!: String;
    public exp!: number;
    public demand!: number;
    public constructor() {

    }

    public: any
    default () {
        this.opportunityId = 0;
        this.description = "";
        this.date = "";
        this.skills = "";
        this.location = "";
        this.exp = 0;
        this.demand = 0;
    }
}
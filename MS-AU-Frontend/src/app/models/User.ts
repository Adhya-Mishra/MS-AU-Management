export class User {
    public userId: number;
    public name: String;
    public email: string;
    public password: string;
    public gid: string;
    public constructor(userId: number, name: String, email: string, pass: string, gid: string) {
        this.userId = userId;
        this.email = email;
        this.password = pass;
        this.gid = gid;
        this.name = name;
    }
}

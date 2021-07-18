package TestingSystem;

public class Account {
    int accountID;
    String email;
    String username;
    String fullname;
    int departmentID;
    int positionID;
    String createDate;

    public Account(int accountID, String email, String username, String fullname, int departmentID, int positionID, String createDate) {
        this.accountID = accountID;
        this.email = email;
        this.username = username;
        this.fullname = fullname;
        this.departmentID = departmentID;
        this.positionID = positionID;
        this.createDate = createDate;
    }
}

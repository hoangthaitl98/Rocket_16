package TestingSystem;

import java.time.LocalDate;

public class Group {
    int groupID;
    String groupName;
    int creatorID;
    LocalDate createDate;

    public Group(int groupID, String groupName, int creatorID, LocalDate createDate) {
        this.groupID = groupID;
        this.groupName = groupName;
        this.creatorID = creatorID;
        this.createDate = createDate;
    }
}

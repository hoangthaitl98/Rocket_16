package TestingSystem;

import java.util.Date;

public class Group {
    int groupID;
    String groupName;
    int creatorID;
    String createDate;

    public Group(int groupID, String groupName, int creatorID, String createDate) {
        this.groupID = groupID;
        this.groupName = groupName;
        this.creatorID = creatorID;
        this.createDate = createDate;
    }
}

package TestingSystem;

import java.util.Date;

public class Question {
    int questionID;
    String content;
    int categoryID;
    int typeID;
    int creatorID;
    String createDate;

    public Question(int questionID, String content, int categoryID, int typeID, int creatorID, String createDate) {
        this.questionID = questionID;
        this.content = content;
        this.categoryID = categoryID;
        this.typeID = typeID;
        this.creatorID = creatorID;
        this.createDate = createDate;
    }
}

package TestingSystem;

import java.time.LocalDate;
import java.util.Date;

public class Exam {
    int examID;
    String code;
    String title;
    int categoryID;
    int duration;
    int creatorID;
    LocalDate createDate;

    public Exam(int examID, String code, String title, int categoryID, int duration, int creatorID, LocalDate createDate) {
        this.examID = examID;
        this.code = code;
        this.title = title;
        this.categoryID = categoryID;
        this.duration = duration;
        this.creatorID = creatorID;
        this.createDate = createDate;
    }
}

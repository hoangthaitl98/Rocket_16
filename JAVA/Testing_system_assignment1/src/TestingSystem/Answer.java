package TestingSystem;

import java.util.Date;

public class Answer {
    int answerID;
    String content;
    int questionID;
    boolean isCorrect;

    public Answer(int answerID, String content, int questionID, boolean isCorrect) {
        this.answerID = answerID;
        this.content = content;
        this.questionID = questionID;
        this.isCorrect = isCorrect;
    }
}

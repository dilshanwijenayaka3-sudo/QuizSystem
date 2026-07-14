public class Question {

    int questionId;
    String lesson;
    String questionText;
    String optionA;
    String optionB;
    String optionC;
    String optionD;
    char correctAnswer;

    public Question(int questionId, String lesson, String questionText,
                    String optionA, String optionB, String optionC,
                    String optionD, char correctAnswer) {

        this.questionId = questionId;
        this.lesson = lesson;
        this.questionText = questionText;
        this.optionA = optionA;
        this.optionB = optionB;
        this.optionC = optionC;
        this.optionD = optionD;
        this.correctAnswer = correctAnswer;
    }
}
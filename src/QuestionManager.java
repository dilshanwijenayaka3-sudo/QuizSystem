import java.util.ArrayList;
import java.util.Stack;

public class QuestionManager {

    private ArrayList<Question> questionList;
    private FileManager fileManager;
    private Stack<Question> deletedQuestions = new Stack<>();

    // Constructor
    public QuestionManager() {

        fileManager = new FileManager();

        // Load questions from file
        questionList = fileManager.loadQuestions("data/questions.txt");

        if (questionList == null) {
            questionList = new ArrayList<>();
        }
    }

    // Save questions to file
    public void saveQuestions() {
        fileManager.saveQuestions(questionList, "data/questions.txt");
    }

    // Add new question
    public void addQuestion(Question question) {

        questionList.add(question);
        saveQuestions();

        System.out.println("Question added successfully.");
    }

    // Return all questions
    public ArrayList<Question> getQuestions() {
        return questionList;
    }

    // Display all questions
    public void displayQuestions() {

        if (questionList.isEmpty()) {

            System.out.println("No questions available.");
            return;
        }

        for (Question q : questionList) {

            System.out.println("-----------------------------------");
            System.out.println("Question Num : " + q.questionId);
            System.out.println("Lesson      : " + q.lesson);
            System.out.println("Question    : " + q.questionText);
            System.out.println("A. " + q.optionA);
            System.out.println("B. " + q.optionB);
            System.out.println("C. " + q.optionC);
            System.out.println("D. " + q.optionD);
            System.out.println("Answer      : " + q.correctAnswer);
        }
    }

    // Display available lessons
    public void displayLessons() {

        ArrayList<String> lessonList = new ArrayList<>();

        for (Question q : questionList) {

            if (!lessonList.contains(q.lesson)) {
                lessonList.add(q.lesson);
            }
        }

        if (lessonList.isEmpty()) {

            System.out.println("No lessons available.");
            return;
        }

        System.out.println("\n========== AVAILABLE LESSONS ==========");

        for (int i = 0; i < lessonList.size(); i++) {
            System.out.println((i + 1) + ". " + lessonList.get(i));
        }
    }

    // Get questions only for selected lesson
    public ArrayList<Question> getQuestionsByLesson(String lesson) {

        ArrayList<Question> lessonQuestions = new ArrayList<>();

        for (Question q : questionList) {

            if (q.lesson.equalsIgnoreCase(lesson)) {
                lessonQuestions.add(q);
            }
        }

        return lessonQuestions;
    }

    // Display questions of selected lesson
    public void displayQuestionsByLesson(String lesson) {

        boolean found = false;

        for (Question q : questionList) {

            if (q.lesson.equalsIgnoreCase(lesson)) {

                found = true;

                System.out.println("-----------------------------------");
                System.out.println("Question Num : " + q.questionId);
                System.out.println("Question    : " + q.questionText);
                System.out.println("A. " + q.optionA);
                System.out.println("B. " + q.optionB);
                System.out.println("C. " + q.optionC);
                System.out.println("D. " + q.optionD);
                System.out.println("Answer      : " + q.correctAnswer);
            }
        }

        if (!found) {
            System.out.println("No questions found for this lesson.");
        }
    }

    // Search question by ID
    public Question searchQuestion(int id) {

        for (Question q : questionList) {

            if (q.questionId == id) {
                return q;
            }
        }

        return null;
    }

    // Delete question
    public void deleteQuestion(int id) {

        Question question = searchQuestion(id);

        if (question != null) {

            deletedQuestions.push(question);

            questionList.remove(question);

            saveQuestions();

            System.out.println("Question deleted successfully.");

        } else {

            System.out.println("Question not found.");
        }
    }

    // Undo deleted question
    public void undoDeleteQuestion() {

        if (!deletedQuestions.isEmpty()) {

            Question question = deletedQuestions.pop();

            questionList.add(question);

            saveQuestions();

            System.out.println("Question restored successfully.");

        } else {

            System.out.println("No deleted questions to restore.");
        }
    }
}

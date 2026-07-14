import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class QuizManager {

    private QuestionManager questionManager;
    private ResultManager resultManager;
    private LessonManager lessonManager;

    public QuizManager(QuestionManager questionManager,
                       ResultManager resultManager,
                       LessonManager lessonManager) {

        this.questionManager = questionManager;
        this.resultManager = resultManager;
        this.lessonManager = lessonManager;
    }

    // Start Quiz
    public void startQuiz() {

        Scanner input = new Scanner(System.in);

        if (questionManager.getQuestions().isEmpty()) {
            System.out.println("No questions available.");
            return;
        }

        System.out.println("\n========== START QUIZ ==========");

        // Get student name
        System.out.print("Enter Student Name : ");
        String studentName = input.nextLine();

        // Display available lessons
        lessonManager.displayLessons();

        System.out.print("\nEnter Lesson Num : ");
        String lesson = input.nextLine();

        // Get questions of selected lesson
        ArrayList<Question> lessonQuestions =
                questionManager.getQuestionsByLesson(lesson);
                System.out.println("Questions Found : " + lessonQuestions.size());

        if (lessonQuestions.isEmpty()) {
            System.out.println("No questions found for this lesson.");
            return;
        }

        int score = 0;

        // Queue Data Structure
        Queue<Question> quizQueue = new LinkedList<>();

        for (Question q : lessonQuestions) {
            quizQueue.offer(q);
        }

        while (!quizQueue.isEmpty()) {

            Question q = quizQueue.poll();

            System.out.println("\n--------------------------------");
            System.out.println(q.questionText);
            System.out.println("A. " + q.optionA);
            System.out.println("B. " + q.optionB);
            System.out.println("C. " + q.optionC);
            System.out.println("D. " + q.optionD);

            System.out.print("Your Answer (A/B/C/D) : ");
            char answer = Character.toUpperCase(input.next().charAt(0));

            if (answer == Character.toUpperCase(q.correctAnswer)) {
                score++;
            }
        }

        Student student = new Student(studentName, lesson, score);

        resultManager.addResult(student);
        resultManager.saveResults("data/results.txt");

        System.out.println("\n========== QUIZ RESULT ==========");
        System.out.println("Student Name : " + studentName);
        System.out.println("Lesson       : " + lesson);
        System.out.println("Marks        : " + score + " / " + lessonQuestions.size());
    }
}
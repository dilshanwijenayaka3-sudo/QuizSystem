import java.util.Scanner;

public class Main {

    public static void main(String[] args) {


        Scanner input = new Scanner(System.in);

        // Create Objects
        QuestionManager questionManager = new QuestionManager();
        ResultManager resultManager = new ResultManager();
        LessonManager lessonManager = new LessonManager();

        QuizManager quizManager = new QuizManager(
                questionManager,
                resultManager,
                lessonManager);

        Admin admin = new Admin("ICT", "1234");

        int choice;

        do {

            System.out.println("\n==================================");
            System.out.println("        ONLINE QUIZ SYSTEM");
            System.out.println("==================================");
            System.out.println("1. Admin Login");
            System.out.println("2. Student Quiz");
            System.out.println("3. View Results");
            System.out.println("4. Exit");
            System.out.print("Enter Choice : ");

            choice = input.nextInt();
            input.nextLine();

            switch (choice) {

                case 1:
                    admin.login(questionManager, lessonManager, input);
                    break;

                case 2:
                    quizManager.startQuiz();
                    break;

                case 3:
                    resultManager.loadResults("data/results.txt");
                    resultManager.displayResults();
                    break;

                case 4:
                    System.out.println("Thank You!");
                    break;

                default:
                    System.out.println("Invalid Choice.");
            }

        } while (choice != 4);

        input.close();
    }
}
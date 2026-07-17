import java.util.Scanner;

public class Admin {

    String username;
    String password;

    public Admin(String username, String password) {
        this.username = username;
        this.password = password;
    }

    // Admin Login
    public void login(QuestionManager questionManager, LessonManager lessonManager, Scanner input) {

        System.out.print("Username : ");
        String user = input.nextLine();

        System.out.print("Password : ");
        String pass = input.nextLine();

        if (!user.equals(username) || !pass.equals(password)) {
            System.out.println("Invalid Username or Password.");
            return;
        }

        System.out.println("\nLogin Successful!");

        int choice;

        do {

            System.out.println("\n========== ADMIN MENU ==========");
            System.out.println("1. Add Lesson");
            System.out.println("2. View Lessons");
            System.out.println("3. Add Question");
            System.out.println("4. View All Questions");
            System.out.println("5. View Questions by Lesson");
            System.out.println("6. Delete Question");
            System.out.println("7. Logout");
            System.out.print("Enter Choice : ");

            choice = input.nextInt();
            input.nextLine();

            switch (choice) {

                case 1:

                    System.out.print("Enter Lesson Num : ");
                    String newLesson = input.nextLine();

                    lessonManager.addLesson(newLesson);

                    break;

                case 2:

                    lessonManager.displayLessons();

                    break;

                case 3:

                    if (lessonManager.getLessons().isEmpty()) {
                        System.out.println("No lessons available.");
                        break;
                    }

                    lessonManager.displayLessons();

                    System.out.print("Enter Lesson Name : ");
                    String lesson = input.nextLine();

                    System.out.print("Question ID : ");
                    int id = input.nextInt();
                    input.nextLine();

                    System.out.print("Question : ");
                    String question = input.nextLine();

                    System.out.print("Option A : ");
                    String a = input.nextLine();

                    System.out.print("Option B : ");
                    String b = input.nextLine();

                    System.out.print("Option C : ");
                    String c = input.nextLine();

                    System.out.print("Option D : ");
                    String d = input.nextLine();

                    System.out.print("Correct Answer (A/B/C/D) : ");
                    char answer = input.next().toUpperCase().charAt(0);

                    Question q = new Question(id, lesson, question,
                            a, b, c, d, answer);

                    questionManager.addQuestion(q);

                    break;

                case 4:

                    questionManager.displayQuestions();

                    break;

                case 5:

                    System.out.print("Enter Lesson Name : ");
                    String lessonName = input.nextLine();

                    questionManager.displayQuestionsByLesson(lessonName);

                    break;

                case 6:

                    System.out.print("Enter Question ID : ");
                    int deleteId = input.nextInt();

                    questionManager.deleteQuestion(deleteId);

                    break;

                case 7:

                    System.out.println("Logged Out.");

                    break;

                default:

                    System.out.println("Invalid Choice.");
            }

        } while (choice != 7);
    }
}

import java.util.ArrayList;
import java.io.*;

public class LessonManager {

    private ArrayList<Lesson> lessonList;

    // Constructor
    public LessonManager() {

        lessonList = new ArrayList<>();
        loadLessons();
    }

    // Add new lesson
    public void addLesson(String lessonName) {

        lessonList.add(new Lesson(lessonName));
        saveLessons();

        System.out.println("Lesson added successfully.");
    }

    // Display all lessons
    public void displayLessons() {

        if (lessonList.isEmpty()) {
            System.out.println("No lessons available.");
            return;
        }

        System.out.println("\n===== AVAILABLE LESSONS =====");

        for (int i = 0; i < lessonList.size(); i++) {
            System.out.println((i + 1) + ". " + lessonList.get(i).lessonName);
        }
    }

    // Return lesson list
    public ArrayList<Lesson> getLessons() {
        return lessonList;
    }

    // Save lessons
    public void saveLessons() {

        try (PrintWriter writer = new PrintWriter(new FileWriter("data/lessons.txt"))) {

            for (Lesson lesson : lessonList) {
                writer.println(lesson.lessonName);
            }

        } catch (IOException e) {
            System.out.println("Error saving lessons.");
        }
    }

    // Load lessons
    public void loadLessons() {

        lessonList.clear();

        try (BufferedReader reader = new BufferedReader(new FileReader("data/lessons.txt"))) {

            String line;

            while ((line = reader.readLine()) != null) {
                lessonList.add(new Lesson(line));
            }

        } catch (IOException e) {
            System.out.println("Lesson file not found.");
        }
    }
}
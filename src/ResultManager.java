import java.io.*;
import java.util.ArrayList;

public class ResultManager {

    private ArrayList<Student> students;

    // Constructor
    public ResultManager() {
        students = new ArrayList<>();
    }

    // Add result
    public void addResult(Student student) {
        students.add(student);
    }

    // Display all results
    public void displayResults() {

        if (students.isEmpty()) {
            System.out.println("No Results Available.");
            return;
        }

        System.out.println("\n========== QUIZ RESULTS ==========");

        for (Student s : students) {

            System.out.println("--------------------------------");
            System.out.println("Student Name : " + s.studentName);
            System.out.println("Lesson       : " + s.lesson);
            System.out.println("Score        : " + s.score);
        }
    }

    // Save results to file
    public void saveResults(String fileName) {

        try (PrintWriter writer = new PrintWriter(new FileWriter(fileName))) {

            for (Student s : students) {
                writer.println(s.studentName + "," + s.lesson + "," + s.score);
            }

            System.out.println("Results saved successfully.");

        } catch (IOException e) {
            System.out.println("Error saving results.");
        }
    }

    // Load results from file
    public void loadResults(String fileName) {

        students.clear();

        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {

            String line;

            while ((line = reader.readLine()) != null) {

                String[] data = line.split(",");

                Student student = new Student(
                        data[0],                      // Student Name
                        data[1],                      // Lesson
                        Integer.parseInt(data[2])     // Score
                );

                students.add(student);
            }

        } catch (IOException e) {
            System.out.println("Result file not found.");
        }
    }

    // Return all results
    public ArrayList<Student> getResults() {
        return students;
    }
}
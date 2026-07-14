import java.io.*;
import java.util.ArrayList;

public class FileManager {

    // Save Questions
    public void saveQuestions(ArrayList<Question> questions, String fileName) {

        try (PrintWriter writer = new PrintWriter(new FileWriter(fileName))) {

            for (Question q : questions) {

                // Save in the format:
                // Lesson,QuestionID,Question,A,B,C,D,Answer
                writer.println(
                        q.lesson + "," +
                        q.questionId + "," +
                        q.questionText + "," +
                        q.optionA + "," +
                        q.optionB + "," +
                        q.optionC + "," +
                        q.optionD + "," +
                        q.correctAnswer
                );
            }

            System.out.println("Questions saved successfully.");

        } catch (IOException e) {
            System.out.println("Error saving questions.");
        }
    }

    // Load Questions
    public ArrayList<Question> loadQuestions(String fileName) {

        ArrayList<Question> questions = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {

            
            String line;

            while ((line = reader.readLine()) != null) {
                 // Skip empty lines
              if (line.trim().isEmpty()) {
              continue;
              }

        String[] data = line.split(",");

    if (data.length != 8) {
        System.out.println("Invalid line: " + line);
        continue;
    }
     
                // Read in the same order:
                // Lesson,QuestionID,Question,A,B,C,D,Answer
                Question question = new Question(
                        Integer.parseInt(data[1]), // Question ID
                        data[0],                   // Lesson
                        data[2],                   // Question
                        data[3],                   // A
                        data[4],                   // B
                        data[5],                   // C
                        data[6],                   // D
                        data[7].charAt(0)          // Answer
                );

                questions.add(question);
            }

        } catch (IOException e) {
            System.out.println("Question file not found.");
        }

        return questions;
    }
}


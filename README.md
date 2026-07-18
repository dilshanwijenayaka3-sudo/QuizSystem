# Online ICT Quiz System

## Project Overview

The **Online ICT Quiz System** is a Java console-based application developed using Object-Oriented Programming (OOP). The system allows an administrator to manage ICT lessons and quiz questions, while students can attempt quizzes by selecting a lesson. Quiz results are automatically saved and can be viewed later. The application uses text files for permanent data storage.

---

## Features

### Administrator

* Secure Admin Login
* Add New Lessons
* View Available Lessons
* Add Quiz Questions
* View All Questions
* View Questions by Lesson
* Delete Questions
* Undo Deleted Question (Stack)
* Save Data Automatically

### Student

* Enter Student Name
* Select a Lesson
* Answer Multiple Choice Questions (MCQs)
* View Final Score

### Results

* Save Student Results
* View Previous Quiz Results

---

## Data Structures Used

This project uses the following data structures:

1. **ArrayList**

   * Stores lessons and quiz questions.
   * Provides dynamic storage and easy access to data.

2. **Queue (LinkedList)**

   * Displays quiz questions in **First In First Out (FIFO)** order during the quiz.

3. **Stack**

   * Stores deleted questions and supports the **Undo Delete** feature using the **Last In First Out (LIFO)** principle.

---

## Technologies Used

* Java
* Object-Oriented Programming (OOP)
* File Handling
* ArrayList
* Queue (LinkedList)
* Stack
* Exception Handling

---

## Project Structure

```text
OL-ICT-Quiz-System
│
├── src
│   ├── Main.java
│   ├── Admin.java
│   ├── Student.java
│   ├── Question.java
│   ├── QuestionManager.java
│   ├── QuizManager.java
│   ├── Lesson.java
│   ├── LessonManager.java
│   ├── ResultManager.java
│   └── FileManager.java
│
├── data
│   ├── lessons.txt
│   ├── questions.txt
│   └── results.txt
│
└── README.md
```

---

## File Description

| File                 | Description                                        |
| -------------------- | -------------------------------------------------- |
| Main.java            | Starts the application and displays the main menu. |
| Admin.java           | Handles administrator login and menu operations.   |
| Student.java         | Stores student details and quiz scores.            |
| Question.java        | Represents a quiz question.                        |
| QuestionManager.java | Manages questions and Undo Delete using Stack.     |
| QuizManager.java     | Conducts quizzes and calculates scores.            |
| Lesson.java          | Represents lesson information.                     |
| LessonManager.java   | Manages lesson records.                            |
| ResultManager.java   | Saves and displays quiz results.                   |
| FileManager.java     | Reads from and writes to text files.               |

---

## Data Files

| File          | Purpose                        |
| ------------- | ------------------------------ |
| lessons.txt   | Stores lesson names.           |
| questions.txt | Stores quiz questions.         |
| results.txt   | Stores students' quiz results. |

---

## How to Run

1. Open the project in NetBeans, Eclipse, IntelliJ IDEA, or any Java IDE.
2. Compile all Java source files.
3. Run **Main.java**.
4. Select one of the following options:

   * Admin Login
   * Student Quiz
   * View Results
   * Exit

---

## OOP Concepts Used

* Classes and Objects
* Constructors
* Encapsulation
* Methods
* Object Interaction

---

## Future Improvements

* Graphical User Interface (GUI)
* MySQL Database Integration
* Student Login System
* Quiz Timer
* Random Question Generation
* Performance Reports

---

## Author

**Dilshan Wijenayaka**

---

## Conclusion

The Online ICT Quiz System demonstrates the practical application of Java Object-Oriented Programming, file handling, and data structures. It provides an efficient solution for managing ICT lessons, quiz questions, and student results while implementing **ArrayList**, **Queue**, and **Stack** to satisfy data structure requirements.

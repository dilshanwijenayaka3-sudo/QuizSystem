# Online ICT Quiz System

## Project Description

The **Online ICT Quiz System** is a Java console-based application developed using Object-Oriented Programming (OOP). The system allows an administrator to manage ICT quiz questions and lessons, while students can attempt quizzes by selecting a lesson. All data is stored using text files.

---

# Features

### Admin Functions

* Admin Login
* Add New Questions
* View All Questions
* Delete Questions
* View Questions by Lesson
* Manage Lessons

### Student Functions

* Enter Student Name
* Select a Lesson
* Answer Multiple Choice Questions (MCQs)
* View Final Score

### Result Management

* Save Quiz Results
* View Previous Results
* Store Results in Text Files

---

# Technologies Used

* Java
* Object-Oriented Programming (OOP)
* ArrayList
* Queue (LinkedList)
* File Handling
* Exception Handling

---

# Project Structure

```text
OL-ICT-Quiz-System/

├── src/
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
├── data/
│   ├── lessons.txt
│   ├── questions.txt
│   └── results.txt
```

---

# File Description

### Java Files

| File                 | Description                                        |
| -------------------- | -------------------------------------------------- |
| Main.java            | Starts the application and displays the main menu. |
| Admin.java           | Handles administrator login and management tasks.  |
| Student.java         | Stores student details and quiz information.       |
| Question.java        | Represents a quiz question and its options.        |
| QuestionManager.java | Manages adding, viewing and deleting questions.    |
| QuizManager.java     | Controls the quiz process and score calculation.   |
| Lesson.java          | Represents lesson information.                     |
| LessonManager.java   | Manages available lessons.                         |
| ResultManager.java   | Saves and displays quiz results.                   |
| FileManager.java     | Handles reading and writing text files.            |

### Data Files

| File          | Purpose                        |
| ------------- | ------------------------------ |
| lessons.txt   | Stores lesson information.     |
| questions.txt | Stores quiz questions.         |
| results.txt   | Stores students' quiz results. |

---

# How to Run

1. Open the project using NetBeans, Eclipse or IntelliJ IDEA.
2. Compile the project.
3. Run **Main.java**.
4. Select one of the available options from the main menu.
5. Login as Admin or start the Student Quiz.

---

# Concepts Used

* Classes and Objects
* Encapsulation
* Constructors
* Methods
* ArrayList
* Queue (LinkedList)
* File Handling
* Exception Handling
* Loops
* Conditional Statements

---

# Future Improvements

* Graphical User Interface (GUI)
* MySQL Database Integration
* Student Login System
* Quiz Timer
* Random Question Generation
* Score Reports and Analytics

---

# Author

**Dilshan Wijenayaka**

---

# Conclusion

This project demonstrates the practical implementation of Java Object-Oriented Programming concepts together with file handling and collections. It provides an efficient system for managing ICT quiz questions and conducting quizzes while maintaining student results in text files.

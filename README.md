# CODSOFT_TASKNO_05
Java Student Course Registration System developed as part of my CodSoft internship Task 5. The application manages courses and students, displays available courses, allows students to register or drop courses, tracks available slots, and validates student and course details. Built using Java, OOP concepts, ArrayList, methods, and user input.
# 🎓 Student Course Registration System

## 📌 Internship Task

This project is developed as **Task 5** of the **CodSoft Java Development Internship**.

## 📖 Project Description

The Student Course Registration System is a Java-based console application designed to manage student course registrations.

The system stores course information such as course code, title, description, capacity, and schedule. It also manages student information and their registered courses.

Students can view available courses, register for courses, drop registered courses, view their registered courses, and add new students through a menu-driven interface.

## ✨ Features

- 📚 View available courses
- 👨‍🎓 Add new students
- 📝 Register students for courses
- ❌ Drop registered courses
- 📋 View a student's registered courses
- 🎯 Display course details
- 👥 Track registered students
- 🔢 Display course capacity
- 🪑 Display available slots
- 🚫 Prevent registration when a course is full
- 🚫 Prevent duplicate course registration
- ⚠️ Validate student and course details
- 🔄 Menu-driven interface

## 🛠️ Technologies Used

- **Java**
- **ArrayList**
- **Scanner**
- **Classes and Objects**
- **Constructors**
- **Methods**
- **Encapsulation**
- **Loops**
- **Conditional Statements**
- **Switch Statement**
- **User Input Validation**

## 🏗️ Classes Used

### 1. Course Class

The `Course` class stores and manages course-related information.

It contains:

- Course code
- Course title
- Course description
- Course capacity
- Course schedule
- Registered students

It also provides methods to:

- Register a student
- Remove a student
- Calculate available slots
- Retrieve course information

### 2. Student Class

The `Student` class stores student-related information.

It contains:

- Student ID
- Student name
- Registered courses

It provides methods to:

- Add a course
- Remove a course
- Display registered courses

### 3. StudentCourseRegistration Class

The `StudentCourseRegistration` class contains the `main()` method and controls the complete registration system.

It provides functionality to:

- Display the menu
- Display available courses
- Register students
- Remove courses
- Display student courses
- Add students
- Search for students and courses

## 📚 Sample Courses

The application includes sample courses such as:

| Course Code | Course | Capacity | Schedule |
|-------------|--------|---------:|----------|
| JAVA101 | Java Programming | 30 | Monday - 10:00 AM |
| PYTHON101 | Python Programming | 25 | Tuesday - 11:00 AM |
| DB101 | Database Management | 20 | Wednesday - 2:00 PM |
| WEB101 | Web Development | 25 | Thursday - 3:00 PM |

## 📋 Main Menu

```text
==========================================
                MENU
==========================================
1. View Available Courses
2. Register for Course
3. Drop Course
4. View My Courses
5. Add Student
6. Exit
==========================================
```
# 🔄 How the System Works
View Courses

The user can view all available courses along with:
- Course code
- Course title
- Description
- Capacity
- Available slots
- Schedule

Register for a Course
1. Enter the Student ID.
2. The system verifies that the student exists.
3. Available courses are displayed.
4. Enter the Course Code.
5. The system checks course availability.
6. The student is registered if a slot is available.
7. A registration confirmation is displayed.

Drop a Course
1. Enter the Student ID.
2. Enter the Course Code.
3. The system checks whether the student is registered.
4. The course is removed from the student's registration.
5. A confirmation message is displayed.

View Registered Courses
The user can enter a Student ID to view:
- Student ID
- Student Name
- Registered Courses

Add Student
The application allows a new student to be added by entering:
- Student ID
- Student Name
The system also prevents duplicate Student IDs.

🛡️ Validation

The application performs several validations:
- Checks whether the student exists.
- Checks whether the course exists.
- Prevents duplicate course registration.
- Prevents registration when the course is full.
- Prevents dropping a course that the student is not registered for.
- Prevents duplicate Student IDs.



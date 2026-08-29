import java.util.ArrayList;
import java.util.Scanner;

// Course Class
class Course {

    private String courseCode;
    private String title;
    private String description;
    private int capacity;
    private String schedule;

    private ArrayList<String> registeredStudents;

    // Constructor
    public Course(String courseCode, String title,
                  String description, int capacity,
                  String schedule) {

        this.courseCode = courseCode;
        this.title = title;
        this.description = description;
        this.capacity = capacity;
        this.schedule = schedule;

        registeredStudents = new ArrayList<>();
    }

    public String getCourseCode() {
        return courseCode;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public int getCapacity() {
        return capacity;
    }

    public String getSchedule() {
        return schedule;
    }

    public int getAvailableSlots() {
        return capacity - registeredStudents.size();
    }

    // Register student
    public boolean registerStudent(String studentId) {

        if (registeredStudents.contains(studentId)) {
            return false;
        }

        if (registeredStudents.size() >= capacity) {
            return false;
        }

        registeredStudents.add(studentId);
        return true;
    }

    // Remove student
    public boolean removeStudent(String studentId) {

        return registeredStudents.remove(studentId);
    }
}


// Student Class
class Student {

    private String studentId;
    private String name;

    private ArrayList<String> registeredCourses;

    // Constructor
    public Student(String studentId, String name) {

        this.studentId = studentId;
        this.name = name;

        registeredCourses = new ArrayList<>();
    }

    public String getStudentId() {
        return studentId;
    }

    public String getName() {
        return name;
    }

    // Add course
    public void addCourse(String courseCode) {

        if (!registeredCourses.contains(courseCode)) {
            registeredCourses.add(courseCode);
        }
    }

    // Remove course
    public boolean removeCourse(String courseCode) {

        return registeredCourses.remove(courseCode);
    }

    // Display registered courses
    public void displayCourses() {

        if (registeredCourses.isEmpty()) {

            System.out.println("No courses registered.");

        } else {

            System.out.println("Registered Courses:");

            for (String course : registeredCourses) {
                System.out.println("- " + course);
            }
        }
    }
}

 // Main Registration System
public class StudentCourseRegistration {

    static Scanner sc = new Scanner(System.in);

    static ArrayList<Course> courses = new ArrayList<>();
    static ArrayList<Student> students = new ArrayList<>();

    public static void main(String[] args) {

        // Add sample courses
        addSampleCourses();

        // Add sample student
        students.add(
                new Student("S101", "Suresh")
        );

        System.out.println("==========================================");
        System.out.println("     STUDENT COURSE REGISTRATION SYSTEM");
        System.out.println("==========================================");

        int choice;

        do {

            displayMenu();

            System.out.print("Enter your choice: ");
            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {

                case 1:
                    displayCourses();
                    break;

                case 2:
                    registerStudent();
                    break;

                case 3:
                    removeCourse();
                    break;

                case 4:
                    displayStudentCourses();
                    break;

                case 5:
                    addStudent();
                    break;

                case 6:
                    System.out.println(
                            "Thank you for using the system!"
                    );
                    break;

                default:
                    System.out.println(
                            "Invalid choice!"
                    );
            }

        } while (choice != 6);

        sc.close();
    }


    // Add sample courses
    public static void addSampleCourses() {

        courses.add(
                new Course(
                        "JAVA101",
                        "Java Programming",
                        "Learn Java programming and OOP concepts",
                        30,
                        "Monday - 10:00 AM"
                )
        );

        courses.add(
                new Course(
                        "PYTHON101",
                        "Python Programming",
                        "Learn Python programming fundamentals",
                        25,
                        "Tuesday - 11:00 AM"
                )
        );

        courses.add(
                new Course(
                        "DB101",
                        "Database Management",
                        "Learn SQL and database concepts",
                        20,
                        "Wednesday - 2:00 PM"
                )
        );

        courses.add(
                new Course(
                        "WEB101",
                        "Web Development",
                        "Learn HTML, CSS and JavaScript",
                        25,
                        "Thursday - 3:00 PM"
                )
        );
    }


    // Display menu
    public static void displayMenu() {

        System.out.println("\n==========================================");
        System.out.println("                MENU");
        System.out.println("==========================================");
        System.out.println("1. View Available Courses");
        System.out.println("2. Register for Course");
        System.out.println("3. Drop Course");
        System.out.println("4. View My Courses");
        System.out.println("5. Add Student");
        System.out.println("6. Exit");
        System.out.println("==========================================");
    }


    // Display available courses
    public static void displayCourses() {

        System.out.println("\n==========================================");
        System.out.println("           AVAILABLE COURSES");
        System.out.println("==========================================");

        for (Course course : courses) {

            System.out.println(
                    "Course Code : " + course.getCourseCode()
            );

            System.out.println(
                    "Title       : " + course.getTitle()
            );

            System.out.println(
                    "Description : " + course.getDescription()
            );

            System.out.println(
                    "Capacity    : " + course.getCapacity()
            );

            System.out.println(
                    "Available   : " + course.getAvailableSlots()
            );

            System.out.println(
                    "Schedule    : " + course.getSchedule()
            );

            System.out.println("------------------------------------------");
        }
    }


    // Register student
    public static void registerStudent() {

        System.out.print("Enter Student ID: ");
        String studentId = sc.nextLine();

        Student student = findStudent(studentId);

        if (student == null) {

            System.out.println(
                    "Student not found!"
            );

            return;
        }

        displayCourses();

        System.out.print(
                "Enter Course Code to register: "
        );

        String courseCode =
                sc.nextLine().toUpperCase();

        Course course =
                findCourse(courseCode);

        if (course == null) {

            System.out.println(
                    "Course not found!"
            );

            return;
        }

        if (course.getAvailableSlots() <= 0) {

            System.out.println(
                    "Course is full!"
            );

            return;
        }

        if (course.registerStudent(studentId)) {

            student.addCourse(courseCode);

            System.out.println(
                    "Course registration successful!"
            );

        } else {

            System.out.println(
                    "Registration failed. " +
                    "Student may already be registered."
            );
        }
    }


    // Remove course
    public static void removeCourse() {

        System.out.print("Enter Student ID: ");
        String studentId = sc.nextLine();

        Student student = findStudent(studentId);

        if (student == null) {

            System.out.println(
                    "Student not found!"
            );

            return;
        }

        System.out.print(
                "Enter Course Code to drop: "
        );

        String courseCode =
                sc.nextLine().toUpperCase();

        Course course =
                findCourse(courseCode);

        if (course == null) {

            System.out.println(
                    "Course not found!"
            );

            return;
        }

        if (course.removeStudent(studentId)) {

            student.removeCourse(courseCode);

            System.out.println(
                    "Course dropped successfully!"
            );

        } else {

            System.out.println(
                    "Student is not registered for this course."
            );
        }
    }


    // Display student's courses
    public static void displayStudentCourses() {

        System.out.print("Enter Student ID: ");
        String studentId = sc.nextLine();

        Student student = findStudent(studentId);

        if (student == null) {

            System.out.println(
                    "Student not found!"
            );

            return;
        }

        System.out.println(
                "\nStudent ID : " + student.getStudentId()
        );

        System.out.println(
                "Student Name : " + student.getName()
        );

        student.displayCourses();
    }


    // Add a new student
    public static void addStudent() {

        System.out.print("Enter Student ID: ");
        String id = sc.nextLine();

        if (findStudent(id) != null) {

            System.out.println(
                    "Student ID already exists!"
            );

            return;
        }

        System.out.print("Enter Student Name: ");
        String name = sc.nextLine();

        students.add(
                new Student(id, name)
        );

        System.out.println(
                "Student added successfully!"
        );
    }


    // Find student
    public static Student findStudent(String studentId) {

        for (Student student : students) {

            if (student.getStudentId()
                    .equalsIgnoreCase(studentId)) {

                return student;
            }
        }

        return null;
    }


    // Find course
    public static Course findCourse(String courseCode) {

        for (Course course : courses) {

            if (course.getCourseCode()
                    .equalsIgnoreCase(courseCode)) {

                return course;
            }
        }

        return null;
    }
}
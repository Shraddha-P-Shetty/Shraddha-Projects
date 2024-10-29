import java.util.ArrayList;
import java.util.Scanner;

class Course {
    String code, title;
    int capacity, registered;
    
    Course(String code, String title, int capacity) {
        this.code = code;
        this.title = title;
        this.capacity = capacity;
        this.registered = 0;
    }
    
    boolean isFull() {
        return registered >= capacity;
    }

    void registerStudent() {
        if (!isFull()) {
            registered++;
            System.out.println("Registered successfully.");
        } else {
            System.out.println("Course is full.");
        }
    }

    void removeStudent() {
        if (registered > 0) {
            registered--;
            System.out.println("Removed from the course.");
        } else {
            System.out.println("You are not registered in this course.");
        }
    }

    void displayCourse() {
        System.out.println(code + ": " + title + " (" + registered + "/" + capacity + " students)");
    }
}

class Student {
    String id, name;
    ArrayList<Course> registeredCourses = new ArrayList<>();

    Student(String id, String name) {
        this.id = id;
        this.name = name;
    }

    void registerForCourse(Course course) {
        if (!course.isFull() && !registeredCourses.contains(course)) {
            registeredCourses.add(course);
            course.registerStudent();
        } else {
            System.out.println("Already registered or course is full.");
        }
    }

    void dropCourse(Course course) {
        if (registeredCourses.contains(course)) {
            registeredCourses.remove(course);
            course.removeStudent();
        } else {
            System.out.println("You are not registered in this course.");
        }
    }

    void displayRegisteredCourses() {
        if (registeredCourses.isEmpty()) {
            System.out.println("\nNo courses registered.");
        } else {
            System.out.println("\nRegistered Courses:");
            for (Course c : registeredCourses) {
                c.displayCourse();
            }
        }
    }
}

public class CourseRegistrationSystem {
    static ArrayList<Course> courses = new ArrayList<>();
    static ArrayList<Student> students = new ArrayList<>();
    static Scanner scanner = new Scanner(System.in);
    
    public static void main(String[] args) {
        
        courses.add(new Course("CS101", "Introduction to Computer Science", 3));
        courses.add(new Course("MTH101", "Calculus I", 2));
        courses.add(new Course("ENG101", "English Literature", 1));

        Student student = new Student("S001", "Vighneshwar H");
        students.add(student);
        
        boolean running = true;
        
        while (running) {
            System.out.println("\n1. View Courses\n2. Register for Course\n3. Drop Course\n4. View Registered Courses\n5. Exit");
            System.out.print("Choose an option: ");
            int option = scanner.nextInt();
            
            switch (option) {
                case 1:
                    listCourses();
                    break;
                case 2:
                    registerCourse(student);
                    break;
                case 3:
                    dropCourse(student);
                    break;
                case 4:
                    student.displayRegisteredCourses();
                    break;
                case 5:
                    running = false;
                    break;
                default:
                    System.out.println("Invalid option.");
            }
        }
    }
    
    static void listCourses() {
        System.out.println("\nAvailable Courses:\n");
        for (Course c : courses) {
            c.displayCourse();
        }
    }

    static void registerCourse(Student student) {
        System.out.print("Enter course code to register: ");
        String code = scanner.next();
        Course course = findCourse(code);

        if (course != null) {
            student.registerForCourse(course);
        } else {
            System.out.println("Course not found.");
        }
    }

    static void dropCourse(Student student) {
        System.out.print("Enter course code to drop: ");
        String code = scanner.next();
        Course course = findCourse(code);

        if (course != null) {
            student.dropCourse(course);
        } else {
            System.out.println("Course not found.");
        }
    }
    
    static Course findCourse(String code) {
        for (Course c : courses) {
            if (c.code.equalsIgnoreCase(code)) {
                return c;
            }
        }
        return null;
    }
}

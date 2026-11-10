import java.util.*;
public class StudentService {

    // Store student ID and Student object
    private HashMap<Integer, Student> students = new HashMap<>();

    // 1. Add Student
    public void addStudent(Student student) {

        if (students.containsKey(student.getId())) {
            System.out.println("Student ID already exists!");
            return;
        }

        students.put(student.getId(), student);
        System.out.println("Student Added Successfully!");
    }

    // 2. Display All Students
    public void displayAllStudents() {

        if (students.isEmpty()) {
            System.out.println("No Students Found!");
            return;
        }

        System.out.println("\n===== All Student Details =====");

        for (Map.Entry<Integer, Student> entry : students.entrySet()) {

            entry.getValue().displayStudent();

            System.out.println("Grade: "
                    + calculateGrade(entry.getValue().getMarks()));

            System.out.println("----------------------");
        }
    }

    // 3. Search Student By ID
    public void searchById(int id) {

        if (students.containsKey(id)) {

            System.out.println("Student Found!");

            Student student = students.get(id);
            student.displayStudent();

        } else {
            System.out.println("Student Not Found!");
        }
    }

    // 4. Search Student By Name
    public void searchByName(String name) {

        boolean found = false;

        for (Student student : students.values()) {

            if (student.getName().equalsIgnoreCase(name)) {

                System.out.println("\nStudent Found!");
                student.displayStudent();

                found = true;
            }
        }

        if (!found) {
            System.out.println("Student Not Found!");
        }
    }

    // 5. Update Student Marks
    public void updateMarks(int id, double marks) {

        if (marks < 0 || marks > 100) {
            System.out.println("Invalid Marks! Enter 0 to 100.");
            return;
        }

        if (students.containsKey(id)) {

            Student student = students.get(id);
            student.setMarks(marks);

            System.out.println("Marks Updated Successfully!");

        } else {
            System.out.println("Student Not Found!");
        }
    }

    // 6. Update Attendance
    public void updateAttendance(int id, int attendance) {

        if (attendance < 0 || attendance > 100) {
            System.out.println("Invalid Attendance!");
            return;
        }

        if (students.containsKey(id)) {

            Student student = students.get(id);
            student.setAttendance(attendance);

            System.out.println("Attendance Updated Successfully!");

        } else {
            System.out.println("Student Not Found!");
        }
    }

    // 7. Remove Student
    public void removeStudent(int id) {

        if (students.containsKey(id)) {

            students.remove(id);

            System.out.println("Student Removed Successfully!");

        } else {
            System.out.println("Student Not Found!");
        }
    }

    // 8. Find Topper
    public void findTopper() {

        if (students.isEmpty()) {
            System.out.println("No Students Found!");
            return;
        }

        Student topper = null;

        for (Student student : students.values()) {

            if (topper == null ||
                    student.getMarks() > topper.getMarks()) {

                topper = student;
            }
        }

        System.out.println("\n===== Topper Details =====");
        topper.displayStudent();
    }

    // 9. Calculate Grade
    public String calculateGrade(double marks) {

        if (marks >= 90) {
            return "A";
        } else if (marks >= 80) {
            return "B";
        } else if (marks >= 70) {
            return "C";
        } else if (marks >= 60) {
            return "D";
        } else if (marks >= 50) {
            return "E";
        } else {
            return "Fail";
        }
    }
}

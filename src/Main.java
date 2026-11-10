import java.util.*;
public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        StudentService service = new StudentService();
        int choice;
        do {
            System.out.println("\n===== STUDENT MANAGEMENT SYSTEM =====");
            System.out.println("1. Add Student");
            System.out.println("2. Display All Students");
            System.out.println("3. Search Student By ID");
            System.out.println("4. Search Student By Name");
            System.out.println("5. Update Student Marks");
            System.out.println("6. Update Attendance");
            System.out.println("7. Remove Student");
            System.out.println("8. Find Topper");
            System.out.println("9. Exit");
            System.out.print("\nEnter Your Choice: ");
            choice = sc.nextInt();
            sc.nextLine();
            switch (choice) {
                // Add Student
                case 1:
                    System.out.print("Enter Student ID: ");
                    int id = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Enter Student Name: ");
                    String name = sc.nextLine();

                    System.out.print("Enter Email: ");
                    String email = sc.nextLine();

                    System.out.print("Enter Marks: ");
                    double marks = sc.nextDouble();

                    System.out.print("Enter Attendance: ");
                    int attendance = sc.nextInt();

                    System.out.println("Select Student Status:");
                    System.out.println("1. ACTIVE");
                    System.out.println("2. INACTIVE");
                    System.out.println("3. COMPLETED");

                    System.out.print("Enter Status: ");
                    int statusChoice = sc.nextInt();

                    StudentStatus status;

                    switch (statusChoice) {
                        case 1:
                            status = StudentStatus.ACTIVE;
                            break;

                        case 2:
                            status = StudentStatus.INACTIVE;
                            break;

                        case 3:
                            status = StudentStatus.COMPLETED;
                            break;

                        default:
                            System.out.println("Invalid Status! Using ACTIVE.");
                            status = StudentStatus.ACTIVE;
                    }

                    if (marks < 0 || marks > 100 ||
                            attendance < 0 || attendance > 100) {

                        System.out.println("Invalid Marks or Attendance!");

                    } else {

                        Student student = new Student(
                                id, name, email,
                                marks, attendance, status
                        );
                        
                        service.addStudent(student);
                    }
                    break;

                // Display All Students
                case 2:

                    service.displayAllStudents();

                    break;

                // Search By ID
                case 3:

                    System.out.print("Enter Student ID: ");
                    id = sc.nextInt();

                    service.searchById(id);

                    break;

                // Search By Name
                case 4:

                    System.out.print("Enter Student Name: ");
                    name = sc.nextLine();

                    service.searchByName(name);

                    break;

                // Update Marks
                case 5:

                    System.out.print("Enter Student ID: ");
                    id = sc.nextInt();

                    System.out.print("Enter New Marks: ");
                    marks = sc.nextDouble();

                    service.updateMarks(id, marks);

                    break;

                // Update Attendance
                case 6:

                    System.out.print("Enter Student ID: ");
                    id = sc.nextInt();

                    System.out.print("Enter New Attendance: ");
                    attendance = sc.nextInt();

                    service.updateAttendance(id, attendance);

                    break;

                // Remove Student
                case 7:

                    System.out.print("Enter Student ID: ");
                    id = sc.nextInt();

                    service.removeStudent(id);

                    break;

                // Find Topper
                case 8:

                    service.findTopper();

                    break;

                // Exit
                case 9:

                    System.out.println("Thank You!");
                    System.out.println("Student Management System Closed.");

                    break;

                default:

                    System.out.println("Invalid Choice! Try Again.");
            }

        } while (choice != 9);
    }
}

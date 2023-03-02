
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class RegistrationForm {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("WELCOME TO THE SCHOOL PORTAL!");
        System.out.println("============================");

        boolean continueRegistration = true;
        while (continueRegistration) {
            registerStudent(scanner);
            System.out.print("\nDo you want to register another student? (Y/N): ");
            String input = scanner.nextLine().trim();
            continueRegistration = input.equalsIgnoreCase("Y");

        }
        System.out.println("\n=======================================");
        System.out.println("THANK YOU FOR USING THE SCHOOL PORTAL!");
    }

    public static void registerStudent(Scanner scanner) {
        System.out.println("\nRegister Here!\nPlease provide following details:\n");

        // Get user input for first name
        String firstName = "";
        boolean isValidFirstName = false;
        while (!isValidFirstName) {
            System.out.print("First Name: ");
            firstName = scanner.nextLine().trim();
            isValidFirstName = Validator.isValidFirstName(firstName);
            if (!isValidFirstName) {
                System.out.println("Invalid first name. Please try again.");
            }
        }

        // Get user input for last name
        String lastName = "";
        boolean isValidLastName = false;
        while (!isValidLastName) {
            System.out.print("Last Name: ");
            lastName = scanner.nextLine().trim();
            isValidLastName = Validator.isValidLastName(lastName);
            if (!isValidLastName) {
                System.out.println("Invalid last name. Please try again.");
            }
        }

        // Get user input for last name
        LocalDate birthday = null;
        boolean isValidBirthday = false;
        while (!isValidBirthday) {
            System.out.print("Birthday (yyyy/mm/dd): ");
            String birthdayString = scanner.nextLine().trim();
            isValidBirthday = Validator.isValidBirthday(birthdayString);
            if (!isValidBirthday) {
                System.out.println("Please try again.");
            } else {
                birthday = LocalDate.parse(birthdayString, DateTimeFormatter.ofPattern("yyyy/MM/dd"));
            }
        }

        // Get user input for course
        String course = "";
        boolean isValidCourse = false;
        while (!isValidCourse) {
            System.out.print("Course: ");
            course = scanner.nextLine().trim();
            isValidCourse = Validator.isValidCourse(course);
            if (!isValidCourse) {
                System.out.println("Invalid course name. Please try again.");
            }
        }

        // Get user input for email address
        String emailAddress = "";
        boolean isValidEmailAddress = false;
        while (!isValidEmailAddress) {
            System.out.print("Email Address: ");
            emailAddress = scanner.nextLine().trim();
            isValidEmailAddress = Validator.isValidEmailAddress(emailAddress);

            if (!isValidEmailAddress) {
                System.out.println("Invalid email address. Please try again.");
            }
        }

        // Create student object and print student number
        Student student = new Student(firstName, lastName, birthday, course, emailAddress);
        System.out.println("\n============================");
        System.out.println("Registration successful!");
        System.out.println("\nRegistered student:");
        System.out.println("Name: " + student.getFirstName() + " " + student.getLastName());
        System.out.println("Birthday: " + student.getBirthday());
        System.out.println("Course: " + student.getCourse());
        System.out.println("Email address: " + student.getEmailAddress());
        System.out.println("Student number: " + student.getStudentNumber());
    }

}

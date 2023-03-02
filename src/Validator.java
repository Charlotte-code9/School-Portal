import java.time.Month;

public class Validator {
    public static boolean isValidFirstName(String firstName) {
        if (firstName.length() > 50) {
            return false;
        }
        return firstName.matches("[a-zA-Z]+");
    }

    public static boolean isValidLastName(String lastName) {
        if (lastName.length() > 50) {
            return false;
        }
        return lastName.matches("[a-zA-Z]+");
    }

    public static boolean isValidBirthday(String birthday) {
        if (!birthday.matches("[0-9/]+")) {
            System.out.println("Input contains non-digit or non-slash characters.");
            return false;
        }

        String[] parts = birthday.split("/");
        if (parts.length != 3) {
            return false;
        }

        int year = Integer.parseInt(parts[0]);
        int month = Integer.parseInt(parts[1]);
        int day = Integer.parseInt(parts[2]);

        if (year < (java.time.LocalDate.now().getYear() - 30) || year > (java.time.LocalDate.now().getYear() - 16)) {
            System.out.println("Birthday is not within acceptable range for college age.");
            return false;
        }

        if (month < 1 || month > 12) {
            System.out.println("Invalid value for month (valid values 1-12): " + month);
            return false;
        }

        if (day < 1 || day > 31) {
            System.out.println("Invalid value for month (valid values 1-31): "+ day);
            return false;
        }

        if ((month == 4 || month == 6 || month == 9 || month == 11) && day == 31) {
            System.out.println("The month of " + Month.of(month).name() + " only has 30 days.");
            return false;
        }

        if (month == 2) {
            boolean isLeapYear = (year % 4 == 0 && (year % 100 != 0 || year % 400 == 0));
            if (day > 29 || (day == 29 && !isLeapYear)) {
                System.out.println("February only has 28 days in a non-leap year and 29 days in a leap year.");
                return false;
            }
        }

        return true;
    }

    public static boolean isValidCourse(String course) {
        if (course.length() > 50) {
            return false;
        }
        return !course.matches(".*\\d.*");
    }

    public static boolean isValidEmailAddress(String email) {
        String emailRegex = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$";
        return email.matches(emailRegex);
    }


}

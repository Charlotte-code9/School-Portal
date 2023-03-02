import java.time.LocalDate;

public class Student {

    private String firstName;
    private String lastName;
    private LocalDate birthday;
    private String course;
    private String emailAddress;

    public Student(String firstName, String lastName, LocalDate birthday, String course, String emailAddress) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthday = birthday;
        this.course = course;
        this.emailAddress = emailAddress;
    }

    public String getFirstName() {

        return firstName;
    }

    public String getLastName() {

        return lastName;
    }


    public LocalDate getBirthday() {

        return birthday;
    }


    public String getCourse() {

        return course;
    }


    public String getEmailAddress() {

        return emailAddress;
    }


    public String getStudentNumber() {
        String year = Integer.toString(LocalDate.now().getYear());
        String day = String.format("%02d", birthday.getDayOfMonth());
        String surnameInitial = Character.toString(lastName.charAt(0));
        return year + "-" + day + "01-" + surnameInitial;
    }

}

// Jad Seaidoun - 200340278
package registrationsystem;

import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Student extends Person {
    //variables
    private int stID;
    private LocalDate start;
    private boolean inGoodStanding;
    private Map<Course, Integer> completed;

    // CONSTRUCTOR ---------------------------------------------------------------------------------------------
    public Student(String first, String last, String address, String city, String zip, String cty, int stID, LocalDate start, LocalDate dob) {
        if (Period.between(dob, LocalDate.now()).getYears() >= 100) {
            throw new IllegalArgumentException("Please check the year entered, student cannot be over 100 years old");
        }
        this.first = first;
        this.last = last;
        this.address = address;
        this.city = city;
        this.zip = zip;
        this.stID = stID;
        this.start = start;
        this.dob = dob;
        this.inGoodStanding = true;
        this.completed = new HashMap<>();
    }

    // SETTERS AND GETTERS ------------------------------------------------------------------------------------
    public LocalDate getStudentBirthday() {
        return this.dob;
    }

    public int getStudentAge() {
        return this.getAge();
    }

    public String getStudentAddress() {
        return this.getAddress(" ");
    }

    public boolean studentInGoodStanding() {
        return this.inGoodStanding;
    }

    public void suspendStudent() {
        this.inGoodStanding = false;
    }

    public void reinstateStudent() {
        this.inGoodStanding = true;
    }

    public int getNoOfYearEnrolled() {
        return this.start.getYear();
    }

    public void setBirthday(LocalDate dob) {
        this.dob = dob;
    }

    public int getStudentNumber() {
        return this.stID;
    }

    // METHODS -----------------------------------------------------------------------------------------------
    /**
     * if the grade is a pass, but under 100 and over 0, it adds it to the map of completed courses
     *
     * @param course course that the student completed
     * @param grade grade student received
     * @return adds the course and grade to a map if student has passed
     * @author Jad Seaidoun
     * @since 1.1
     */
    public void addCompletedCourse(Course course, int grade) {
        if (grade > 100 || grade < 0) {
            throw new IllegalArgumentException("grade must be 0-100 inclusive");
        }
        this.completed.put(course, grade);
    }

    /**
     * lists the courses completed from the map with grades and returns as a string
     *
     * @return List with delimiter and string to match the test output
     * @author Jad Seaidoun
     * @since 1.1
     */
    public String getCoursesCompleted() {
        List<String> courses = new ArrayList<>();
        for (Map.Entry<Course, Integer> entry: this.completed.entrySet()) {
            courses.add(entry.getKey() + " grade=" + entry.getValue());
        }
        return "[" + String.join(", ", courses) + "]";
    }

    /**
     * checks to see if completed course from the map is a pass (over 50)
     *
     * @param course a list of courses completed
     * @return return true if the student successfully passes a class
     * @author Jad Seaidoun
     * @since 1.1
     */
    public boolean hasCompleted(String course) {
        for(Map.Entry<Course, Integer> entry: this.completed.entrySet()) {
            if (entry.getKey().getName().equals(course) && entry.getValue() >= 50) {
                return true;
            }
        }
        return false;
    }

    /**
     * toString
     *
     * @author Jad Seaidoun
     * @since 1.1
     */
    @Override
    public String toString() {
        StringBuilder sb = this.stringBuilder();
        sb.append(", student number: ");
        sb.append(this.stID);
        return sb.toString();
    }
}

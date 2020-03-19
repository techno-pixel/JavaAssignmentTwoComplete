// Jad Seaidoun - 200340278
package registrationsystem;

import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Instructor extends Person {
    //variables
    private LocalDate start;
    private Set<String> subjects;

    // CONSTRUCTOR ---------------------------------------------------------------------------------------------
    public Instructor(String first, String last, int emID, String address, String city, String zip, LocalDate start, LocalDate dob) {
        if (Period.between(dob, LocalDate.now()).getYears() >= 100) {
            throw new IllegalArgumentException("Please check the year entered, instructor cannot be over 100 years old");
        }
        if (Period.between(start, LocalDate.now()).getYears() >= 80) {
            throw new IllegalArgumentException(start + " as a hire date would mean " + first + " started working over 80 years ago");
        }
        this.first = first;
        this.last = last;
        this.address = address;
        this.city = city;
        this.zip = zip;
        this.start = start;
        this.dob = dob;
        this.subjects = new HashSet<>();
    }

    // SETTERS AND GETTERS ------------------------------------------------------------------------------------
    public int getAgeInYears() {
        return this.getAge();
    }

    public int noOfYearsAtCollege() {
        return Period.between(start, LocalDate.now()).getYears();
    }

    public String getInstructorAddress() {
        return this.getAddress(", ");
    }

    public void setBirthday(LocalDate dob) {
        this.dob = dob;
    }

    public boolean instructorCanTeach(String course) {
        return this.subjects.contains(course);
    }

    // METHODS -----------------------------------------------------------------------------------------------
    /**
     * checks if the teacher is qualified to teach a course
     *
     * @author Jad Seaidoun
     */
    public String listOfSubjectsCertifiedToTeach() {
        if (this.subjects.size() == 0) {
            return "not qualified to teach courses yet.";
        }
        return "[" + String.join(", ", this.subjects) + "]";
    }

    /**
     * adds courses into a set
     *
     * @author Jad Seaidoun
     */
    public void addCourseToInstructorAbilities(String course) {

        this.subjects.add(course);
    }

    /**
     * toString
     *
     * @author Jad Seaidoun
     */
    @Override
    public String toString() {
        return this.stringBuilder().toString();
    }
}

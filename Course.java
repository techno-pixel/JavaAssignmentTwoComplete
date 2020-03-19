// Jad Seaidoun - 200340278
package registrationsystem;


import java.time.*;
import java.util.ArrayList;
import java.util.List;

public class Course {
    //variables
    private Instructor instructor;
    private String name;
    private String title;
    private String room;
    private DayOfWeek day;
    private LocalTime time;
    private int size;
    private String prereq;
    private List<Student> students;

    // CONSTRUCTOR ---------------------------------------------------------------------------------------------
    public Course(Instructor instructor, String name, String title, String room, DayOfWeek day, LocalTime time, int size, String prereq) {
        if (!instructor.instructorCanTeach(name)) {
            throw new IllegalArgumentException("Professor " + instructor + " is not qualified to teach " + name);
        }
        if (time.isAfter(LocalTime.parse("18:00")) || time.isBefore(LocalTime.parse("08:00"))) {
            throw new IllegalArgumentException("The lab start time must be between 08:00-18:00");
        }
        this.instructor = instructor;
        this.name = name;
        this.title = title;
        this.room = room;
        this.day = day;
        this.time = time;
        this.students = new ArrayList<>();
        this.prereq = prereq;
        this.size = size;
    }

    // SETTERS AND GETTERS ------------------------------------------------------------------------------------
    public String getClassRoom() {
        return this.room;
    }

    public String getCourseDayAndTime() {
        return this.day.name() + "'s, starting at " + this.time.toString();
    }

    public Instructor getInstructorToTeach() {
        return this.instructor;
    }

    // METHODS -----------------------------------------------------------------------------------------------

    /**
     * addStudent(Student student) takes the object of the student created, and checks for 3 things:
     * if the student is in good standing, if he has a prereq complete when being registered for a course that has
     * a prereq, and if there is room in the classroom
     *
     * @author Jad Seaidoun
     */
    public String addStudent(Student student) {
        if (!student.studentInGoodStanding()) {
            return "The Student is not in good standing and cannot join the course.";
        }
        if (this.prereq != this.name && !student.hasCompleted(this.prereq)) {
            return "Student has not completed the prerequisite course: " + this.prereq;
        }
        if (students.size() <= this.size) {
            this.students.add(student);
            return null;
        }
        return "Student was not added because the course is full";
    }

    /**
     * displayTheClassList adds the student registered in the course into a list
     *
     * @author Jad Seaidoun
     */
    public String displayTheClassList() {
        List<String> st = new ArrayList<>();
        for (Student s: this.students) {
            st.add(s.toString());
        }
        return String.join(", ", st);
    }

    /**
     * setClassSize is to set the max number of students that a class can hold
     *
     * @author Jad Seaidoun
     */
    public String setClassSize(int size) {
        if (size > 40) {
            this.size = 40;
            return "Max class size = 40, it has been set to 40";
        }
        this.size = size;
        return null;
    }

    /**
     * returns the class size
     *
     * @author Jad Seaidoun
     */
    public int getClassSize() {
        return this.size;
    }

    /**
     * matureClass checks if the students ages average to over or under 25
     * it grabs the students from the studentsList and adds up their age into a sum variable
     * if the sum is > 25 it will set it to true and vice versa
     *
     * @author Jad Seaidoun
     */
    public boolean matureClass() {
        int sum = 0;
        for (Student s: this.students) {
            sum += s.getAge();
        }
        return (sum/this.students.size()) > 25;
    }

    /**
     * checks prereq from the constructor
     *
     * @author Jad Seaidoun
     */
    public String checkPrerequisite() {
        return this.prereq;
    }

    /**
     * returns course name
     *
     * @author Jad Seaidoun
     */
    public String getName() {
        return this.name;
    }

    /**
     * toString course code and title
     *
     * @author Jad Seaidoun
     */
    @Override
    public String toString() {
        return this.name + "-" + this.title;
    }
}

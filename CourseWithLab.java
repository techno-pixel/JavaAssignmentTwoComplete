// Jad Seaidoun - 200340278
package registrationsystem;

import java.time.DayOfWeek;
import java.time.LocalTime;

public class CourseWithLab extends Course {
    //variables
    private DayOfWeek labDay;
    private LocalTime labTime;
    private String labRoom;
    private Instructor labInst;

    // CONSTRUCTOR ---------------------------------------------------------------------------------------------
    public CourseWithLab(Instructor instructor, String name, String title, String room, DayOfWeek day, LocalTime time, int size, Instructor labInst, String labRoom, DayOfWeek labDay, LocalTime labTime) {
        this(instructor, name, title, room, day, time, size, "", labInst, labRoom, labDay, labTime);
    }

    // CONSTRUCTOR ---------------------------------------------------------------------------------------------
    public CourseWithLab(Instructor instructor, String name, String title, String room, DayOfWeek day, LocalTime time, int size, String prereq, Instructor labInst, String labRoom, DayOfWeek labDay, LocalTime labTime) {
        super(instructor, name, title, room, day, time, size, prereq);
        if (labTime.isAfter(LocalTime.parse("18:00")) || labTime.isBefore(LocalTime.parse("08:00"))) {
            throw new IllegalArgumentException("The lab start time must be between 08:00-18:00");
        }
        if (!labInst.instructorCanTeach(name+"-LAB")) {
            throw new IllegalArgumentException("The Lab Tech is not qualified to host the lab");
        }
        this.labDay = labDay;
        this.labTime = labTime;
        this.labRoom = labRoom;
        this.labInst = labInst;
    }

    // SETTERS AND GETTERS ------------------------------------------------------------------------------------
    public String getLabClassAndTime() {
        return "room: " + this.labRoom + ", " + this.labDay.name() + " starting at " + this.labTime.toString();
    }

    public Instructor getLabTech() {
        return this.labInst;
    }

    // METHODS -----------------------------------------------------------------------------------------------
    /**
     * returns the course course and title + with lab if it is a lab course
     *
     * @author Jad Seaidoun
     * @since 1.1
     */
    @Override
    public String toString() {
        return super.toString() + " with lab";
    }
}

package models;

public class Student extends Person{
    private String university;
    private int course;

    public Student(String firstName, String lastName, String university, int course) {
        super(firstName, lastName);
        this.university = university;
        this.course = course;
    }

    public String getUniversity() {
        return university;
    }

    public void setUniversity(String university) {
        this.university = university;
    }

    public int getCourse() {
        return course;
    }

    public void setCourse(int course) {
        this.course = course;
    }
}

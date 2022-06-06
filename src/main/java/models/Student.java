package models;

public class Student extends Learner {
    private final String faculty;
    private final int course;
    private final String group;

    public Student(int id, String name, String faculty, int course, String group) {
        super(id, name);
        this.faculty = faculty;
        this.course = course;
        this.group = group;
    }

    public String getFaculty() {
        return faculty;
    }

    public int getCourse() {
        return course;
    }

    public String getGroup() {
        return group;
    }

}

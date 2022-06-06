package models;

public class SchoolChild extends Learner {
    private String educationalClass;

    public SchoolChild(int id, String name, String educationalClass) {
        super(id, name);
        this.educationalClass = educationalClass;
    }

    public String getEducationalClass() {
        return educationalClass;
    }

    public void setEducationalClass(String educationalClass) {
        this.educationalClass = educationalClass;
    }

}

package data;

public class Student {

    private String studentID;
    private String studentName;

    public Student() {
    }

    public Student(String studentID) {
        this.studentID = studentID;
    }

    public Student(String studentID, String studentName) {
        this.studentID = studentID;
        this.studentName = studentName;
    }

    public String getStudentID() {
        return studentID;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public boolean equals(Student that) {
        return this.studentID.equalsIgnoreCase(that.studentID);
    }

    @Override
    public String toString() {
        return studentID + ", " + studentName;
    }

    public void display() {
        System.out.println("Student ID: " + studentID + ", student's name: " + studentName);
    }
}

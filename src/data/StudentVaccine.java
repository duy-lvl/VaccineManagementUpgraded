package data;

public class StudentVaccine {

    private String injectionID;
    private Student student;
    private Vaccine vaccine;
    private String place1 = null;
    private String date1 = null;
    private String place2 = null;
    private String date2 = null;

    public StudentVaccine() {
    }

    public StudentVaccine(Student student) {
        this.student = student;
    }

    public StudentVaccine(Vaccine vaccine) {
        this.vaccine = vaccine;
    }

    public StudentVaccine(String injectionID) {
        this.injectionID = injectionID;
    }

    public StudentVaccine(String injectionID, Student student) {
        this.injectionID = injectionID;
        this.student = student;
    }

    public StudentVaccine(String injectionID, Student std, Vaccine vac, String place1, String date1) {
        this.injectionID = injectionID;
        this.student = std;
        this.vaccine = vac;
        this.place1 = place1;
        this.date1 = date1;
    }

    public StudentVaccine(String injectionID, Student std, Vaccine vac, String place1, String date1, String place2, String date2) {
        this.injectionID = injectionID;
        this.student = std;
        this.vaccine = vac;
        this.place1 = place1;
        this.date1 = date1;
        this.place2 = place2;
        this.date2 = date2;
    }

    public String getInjectionID() {
        return injectionID;
    }

    public String getPlace1() {
        return place1;
    }

    public void setPlace1(String place1) {
        this.place1 = place1;
    }

    public String getDate1() {
        return date1;
    }

    public void setDate1(String date1) {
        this.date1 = date1;
    }

    public String getPlace2() {
        return place2;
    }

    public void setPlace2(String place2) {
        this.place2 = place2;
    }

    public String getDate2() {
        return date2;
    }

    public void setDate2(String date2) {
        this.date2 = date2;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Vaccine getVaccine() {
        return vaccine;
    }

    public void setVaccine(Vaccine vaccine) {
        this.vaccine = vaccine;
    }

    public boolean equals(StudentVaccine that) {
        return this.getInjectionID().equalsIgnoreCase(that.getInjectionID());
    }

    @Override
    public String toString() {
        return injectionID + ", " + student + ", " + vaccine + ", " + place1 + ", "
                + date1 + ", " + place2 + ", " + date2;
    }

    public void display() {
//        System.out.printf("|%-12s|%-10s|%-20s|%-10s|%-12s|%-10s|%-12s|%-10s|\n",
//                "Injection ID", "Student ID", "Student's name",
//                "Vaccine ID", "Place 1", "Date 1", "Place 2", "Date 2");
        System.out.printf("|%-12s|%-10s|%-20s|%-10s|%-12s|%-10s|%-12s|%-10s|\n",
                injectionID, student.getStudentID(), student.getStudentName(),
                vaccine.getVaccineID(), place1, date1, place2, date2);
    }

}

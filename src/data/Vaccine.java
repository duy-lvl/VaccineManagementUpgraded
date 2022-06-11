package data;

public class Vaccine {

    private String vaccineID;
    private String vaccineName;

    public Vaccine(String vaccineID, String vaccineName) {
        this.vaccineID = vaccineID;
        this.vaccineName = vaccineName;
    }

    public Vaccine() {
    }

    public Vaccine(String vaccineID) {
        this.vaccineID = vaccineID;
    }

    public String getVaccineID() {
        return vaccineID;
    }

    public void setVaccineID(String vaccineID) {
        this.vaccineID = vaccineID;
    }

    public String getVaccineName() {
        return vaccineName;
    }

    public void setVaccineName(String vaccineName) {
        this.vaccineName = vaccineName;
    }

    public boolean equals(Vaccine that) {
        return this.getVaccineID().equalsIgnoreCase(that.getVaccineID());
    }

    @Override
    public String toString() {
        return vaccineID;
    }
    
    public void display() {
        System.out.println("Vaccine ID: " + vaccineID + ", vaccine name: " + vaccineName);
    }
}

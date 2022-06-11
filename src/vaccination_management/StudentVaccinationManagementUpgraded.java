package vaccination_management;

import data.StudentVaccineList;
import util.Utils;

public class StudentVaccinationManagementUpgraded {

    public static void main(String[] args) {
        final String STUDENT_VACCINE_OUT = "injection-out.txt";
        final String STUDENT_LIST = "student.txt";
        final String VACCINE_LIST = "vaccine.txt";
        final String STUDENT_VACCINE_IN = "injection.txt";
        int choice;
        StudentVaccineList list = new StudentVaccineList();
        System.out.println("Welcome to vaccination management with Real time processing and Information Encryption!");
        try {
            do {
                Utils.printMenu();
                choice = Utils.getChoice("Your choice: ", 1, 7, "Your choice must be a number in [1..6]");

                switch (choice) {
                    case 1: //Show information all students have been injected.
                        list.readFromFileIn(STUDENT_VACCINE_IN);
                        list.formattedDisplay();
                        System.out.println();
                        break;
                    case 2: //Add student's vaccine injection information.
                        list.readFromFileIn(STUDENT_VACCINE_IN);
                        list.addInjectionInformation(STUDENT_LIST, VACCINE_LIST);
                        System.out.println();
                        list.writeToFileOut(STUDENT_VACCINE_OUT);
                        list.writeToFileIn(STUDENT_VACCINE_IN);
                        break;
                    case 3: //Updating information of students' vaccine injection.
                        list.readFromFileIn(STUDENT_VACCINE_IN);
                        list.update();
                        System.out.println();
                        list.writeToFileOut(STUDENT_VACCINE_OUT);
                        list.writeToFileIn(STUDENT_VACCINE_IN);
                        break;
                    case 4: //Delete student vaccine injection information.
                        list.readFromFileIn(STUDENT_VACCINE_IN);
                        list.delete();
                        System.out.println();
                        list.writeToFileOut(STUDENT_VACCINE_OUT);
                        list.writeToFileIn(STUDENT_VACCINE_IN);
                        break;
                    case 5: //Search for injection information by student ID.
                        list.readFromFileIn(STUDENT_VACCINE_IN);
                        Utils.printCase5Submenu();
                        int subChoice = Utils.getChoice("Enter your choice: ", 1, 2, "Your choice must be 1 or 2!");
                        if (subChoice == 1) {
                            list.searchByStudentID();
                        }
                        if (subChoice == 2) {
                            list.searchByStudentName();
                        }
                        System.out.println();
                        break;
                    case 6: //write to file
                        if (list.writeToFileOut(STUDENT_VACCINE_OUT)) {
                            System.out.println("Successfully write to the file.");
                        } else {
                            System.out.println("Fail!");
                        }
                        list.writeToFileIn(STUDENT_VACCINE_IN);
                        System.out.println();
                        break;

                }

            } while (choice > 0 && choice < 7);
        } catch (Exception e) {
        }

    }

}

package data;

import security.SymmetricSecurity;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;
import util.Utils;

public class StudentVaccineList {
    
    private ArrayList<StudentVaccine> list = new ArrayList();
    private final int N_POS = 3;
    private SymmetricSecurity shifter = new SymmetricSecurity(N_POS);
    //--------1----------------
    private int checkInjectionID(String ID) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getInjectionID().equalsIgnoreCase(ID)) {
                return i;
            }
        }
        return -1;
    }

    public void readFromFileOut(String fileIn) {
        try {
            File vaccineFile = new File(fileIn);
            if (!vaccineFile.exists()) {
                System.out.println("File does not exist.");
                return;
            }
            FileReader fr = new FileReader(vaccineFile);
            BufferedReader br = new BufferedReader(fr);
            String detail;
            while ((detail = shifter.decodeComplex(br.readLine())) != null) {
                
                StringTokenizer stk = new StringTokenizer(detail, ",");

                String stdID, stdName, vacID, injectionID,
                        place1, date1, place2, date2;

                injectionID = stk.nextToken().trim().toUpperCase();//Injection ID
                if (checkInjectionID(injectionID) < 0) {
                    stdID = stk.nextToken().trim().toUpperCase();// student ID

                    stdName = stk.nextToken().trim().toUpperCase();//Student Name

                    Student std = new Student(stdID, stdName);

                    if (!stk.hasMoreTokens()) {
                        list.add(new StudentVaccine(injectionID, std));
                    } else {
                        vacID = stk.nextToken().trim().toUpperCase();//Vaccine ID

                        Vaccine vaccine = new Vaccine(vacID);

                        place1 = stk.nextToken().trim().toUpperCase();
                        date1 = stk.nextToken().trim().toUpperCase();

                        if (!stk.hasMoreTokens()) {
                            list.add(new StudentVaccine(injectionID, std, vaccine, place1, date1));
                        } else {
                            place2 = stk.nextToken().trim().toUpperCase();
                            date2 = stk.nextToken().trim().toUpperCase();

                            list.add(new StudentVaccine(injectionID, std, vaccine, place1, date1, place2, date2));
                        }
                    }
                } else {

                }
            }
        } catch (Exception e) {
        }
    }

    //--------
    public void readFromFileIn(String fileIn) {
        try {
            File vaccineFile = new File(fileIn);
            if (!vaccineFile.exists()) {
                System.out.println("File does not exist.");
                return;
            }
            FileReader fr = new FileReader(vaccineFile);
            BufferedReader br = new BufferedReader(fr);
            String detail;
            while ((detail = br.readLine()) != null) {
                
                StringTokenizer stk = new StringTokenizer(detail, ",");

                String stdID, stdName, vacID, injectionID,
                        place1, date1, place2, date2;

                injectionID = stk.nextToken().trim().toUpperCase();//Injection ID
                if (checkInjectionID(injectionID) < 0) {
                    stdID = stk.nextToken().trim().toUpperCase();// student ID

                    stdName = stk.nextToken().trim().toUpperCase();//Student Name

                    Student std = new Student(stdID, stdName);

                    if (!stk.hasMoreTokens()) {
                        list.add(new StudentVaccine(injectionID, std));
                    } else {
                        vacID = stk.nextToken().trim().toUpperCase();//Vaccine ID

                        Vaccine vaccine = new Vaccine(vacID);

                        place1 = stk.nextToken().trim().toUpperCase();
                        date1 = stk.nextToken().trim().toUpperCase();

                        if (!stk.hasMoreTokens()) {
                            list.add(new StudentVaccine(injectionID, std, vaccine, place1, date1));
                        } else {
                            place2 = stk.nextToken().trim().toUpperCase();
                            date2 = stk.nextToken().trim().toUpperCase();

                            list.add(new StudentVaccine(injectionID, std, vaccine, place1, date1, place2, date2));
                        }
                    }
                } else {

                }
            }
        } catch (Exception e) {
        }
    }
    //--------
    public void display() {
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
    }

    //---------2----------------------------------
    public void addInjectionInformation(String STUDENT_LIST, String VACCINE_LIST) {
        if (list.isEmpty()) {
            System.out.println("The list is empty!");
            return;
        }
        String choice;
        do {
            StudentList stdList = new StudentList();
            VaccineList vacList = new VaccineList();
            stdList.readFromFile(STUDENT_LIST);
            vacList.readFromFile(VACCINE_LIST);
            //----Show student list that need to be vaccinated
            ArrayList<Student> studentList = new ArrayList();
            for (int i = 0; i < stdList.getList().size(); i++) {
                boolean checkExist = false;
                for (int j = 0; j < list.size(); j++) {
                    if (stdList.getList().get(i).equals(list.get(j).getStudent())) {
                        checkExist = true;
                        break;
                    }
                }
                if (!checkExist) {
                    studentList.add(stdList.getList().get(i));
                }
            }

            for (int i = 0; i < studentList.size(); i++) {
                studentList.get(i).display();
            }
            //Add injection information
            String injID, stdID, stdName, vacID, place1, date1;
            Student std = null;
            Vaccine vac = null;
            injID = this.addInjectionID();
            boolean check = false;

            //Add student information
            while (!check) {
                stdID = Utils.getString("Enter student ID: ");
                for (int i = 0; i < studentList.size(); i++) {
                    if (stdID.equalsIgnoreCase(studentList.get(i).getStudentID())) {
                        check = true;
                        std = new Student(stdID, studentList.get(i).getStudentName());
                        break;
                    }
                }
                if (!check) {
                    System.out.println("This ID is not in the list.");
                }
            }
            //Add vaccine information

            for (int i = 0; i < vacList.getList().size(); i++) {
                vacList.getList().get(i).display();
            }
            check = false;
            while (!check) {
                vacID = Utils.getString("Enter vaccine ID: ");
                for (int i = 0; i < vacList.getList().size(); i++) {
                    if (vacID.equalsIgnoreCase(vacList.getList().get(i).getVaccineID())) {
                        check = true;
                        vac = new Vaccine(vacID);
                        break;
                    }
                }
                if (!check) {
                    System.out.println("This ID is not in the list.");
                }
            }

            //Add place 1
            place1 = Utils.getString("Enter place 1: ");

            //Add date 1
            while (true) {
                date1 = Utils.getString("Enter date 1: ");
                if (Utils.toDate(date1) == -1) {
                    System.out.println("Invalid date!");
                } else {
                    break;
                }
            }

            //----add second injection
            String cont = Utils.getChoice("Do you want to continue adding second injection (y/n)? ", "y/n please!");
            if (cont.equals("y")) {
                String date2 = null, place2;
                place2 = Utils.getString("Enter place 2: ");
                check = false;
                while (!check) {
                    date2 = Utils.getString("Enter date 2: ");
                    check = Utils.toDate(date2) - Utils.toDate(date1) >= Utils.oneWeek() * 4
                            && Utils.toDate(date2) - Utils.toDate(date1) <= Utils.oneWeek() * 12;
                    if (!check) {
                        System.out.println("The second dose of vaccine must be given 4 to 12 weeks after the first injection.");
                    }
                }

                list.add(new StudentVaccine(injID, std, vac, place1, date1, place2, date2));

                System.out.println("Student has completed 2 injections!");

            } else {
                list.add(new StudentVaccine(injID, std, vac, place1, date1));
                System.out.println("Added successfully!");
            }
            choice = Utils.getChoice("Do you want to continue adding new injection (y/n)? ", "y/n please!");
        } while (choice.equals("y"));

    }

    public String addInjectionID() {
        do {
            String injID = Utils.getString("Enter injection ID: ");
            if (checkInjectionID(injID) < 0) {
                return injID;
            } else {
                System.out.println("ID duplicated!");
            }
        } while (true);

    }

    //-------------3-----------------------
    public void update() {
        if (list.isEmpty()) {
            System.out.println("The list is empty!");
            return;
        }
        
        ArrayList<StudentVaccine> tmpList = new ArrayList();
        for (int i = 0; i < list.size(); i++) {
            if (!list.get(i).getDate1().equals("NULL") && list.get(i).getDate2().equals("NULL")) {
                tmpList.add(list.get(i));
            }
        }
        if (tmpList.isEmpty()) {
            System.out.println("There are no available injection.");
            return;
        }
        for (int i = 0; i < tmpList.size(); i++) {
            System.out.println(tmpList.get(i).toString());
        }
        //check injection ID
        boolean check = false;
        String injectionID;
        do {
            injectionID = Utils.getString("Enter injection ID: ");
            for (int i = 0; i < tmpList.size(); i++) {
                if (injectionID.equalsIgnoreCase(tmpList.get(i).getInjectionID())) {
                    check = true;
                    break;
                }
            }
            if (!check) {
                System.out.println("This ID does not exist!");
            }
        } while (!check);

        //-----------
        int index = -1;
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getInjectionID().equalsIgnoreCase(injectionID)) {
                index = i;
                break;
            }
        }

        StudentVaccine s = list.get(index);
        String date2, place2;

        check = false;
        while (!check) {
            date2 = Utils.getString("Enter date 2: ");
            check = Utils.toDate(date2) - Utils.toDate(s.getDate1()) >= Utils.oneWeek() * 4
                    && Utils.toDate(date2) - Utils.toDate(s.getDate1()) <= Utils.oneWeek() * 12;
            if (check) {
                s.setDate2(date2);
            } else {
                System.out.println("The second dose of vaccine must be given 4 to 12 weeks after the first injection.");
            }
        }

        place2 = Utils.getString("Enter place 2: ");
        s.setPlace2(place2);
        System.out.println("Student has completed 2 injections!");
    }

    //-----------------4--------------------
    public void delete() {
        if (list.isEmpty()) {
            System.out.println("The list is empty!");
            return;
        }
        
        String injectionID = Utils.getString("Enter injection ID that will be deleted: ").toUpperCase();
        int index = -1;
        String choice = Utils.getChoice("Delete confirm (y/n): ", "(y/n) please!");
        if (choice.equals("y")) {
            for (int i = 0; i < list.size(); i++) {
                if (list.get(i).getInjectionID().equalsIgnoreCase(injectionID)) {
                    index = i;
                    break;
                }
            }

            if (index < 0) {
                System.out.println("Delete fail! Injection ID not found.");
            } else {
                list.remove(index);
                System.out.println("Delete successfully");
            }
        } else {
            System.out.println("Delete fail.");
        }
    }

    //-----------5.1---------------------
    public void searchByStudentID() {
        if (list.isEmpty()) {
            System.out.println("The list is empty!");
            return;
        }
        String stdID = Utils.getString("Enter student ID that you want to search: ");
        boolean check = false;
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getStudent().equals(new Student(stdID))) {
                check = true;
                break;
            }
        }

        if (!check) {
            System.out.println("Not found!");
        }
    }

    //------------------5.2------------
    public void searchByStudentName() {
        if (list.isEmpty()) {
            System.out.println("The list is empty!");
            return;
        }
        String stdName = Utils.getString("Enter student's name that you want to search: ");
        boolean check = false;
        for (int i = 0; i < list.size(); i++) {
            if (contains(list.get(i).getStudent().getStudentName(), stdName)) {
                check = true;
            }
        }
        if (check) {
            System.out.printf("|%-12s|%-10s|%-20s|%-10s|%-12s|%-10s|%-12s|%-10s|\n",
                    "Injection ID", "Student ID", "Student's name",
                    "Vaccine ID", "Place 1", "Date 1", "Place 2", "Date 2");
            for (int i = 0; i < list.size(); i++) {
                if (contains(list.get(i).getStudent().getStudentName(), stdName)) {
                    list.get(i).display();
                }
            }
        }
        if (!check) {
            System.out.println("Not found!");
        }
    }

    //-----------5.2
    public boolean contains(String fullName, String name) {
        boolean check = false;
        StringTokenizer stk = new StringTokenizer(fullName, " ");
        ArrayList<String> nameList = new ArrayList();
        while (stk.hasMoreTokens()) {
            nameList.add(stk.nextToken());
        }
        for (int i = 0; i < nameList.size(); i++) {
            if (name.equalsIgnoreCase(nameList.get(i))) {
                check = true;
            }
        }
        return check;
    }

    //---------------------
    public void formattedDisplay() {
        for (int i = 0; i < 105; i++) {
            System.out.print("-");
        }

        System.out.println();
        System.out.printf("|%-12s|%-31s|%10s|%-23s|%-23s|\n", "", "Student Information", "",
                "First Injection", "Second Injection");
        System.out.printf("|Injection ID|", "");
        for (int i = 0; i < 31; i++) {
            System.out.print("-");
        }
        System.out.print("|Vaccine ID|");
        for (int i = 0; i < 23; i++) {
            System.out.print("-");
        }
        System.out.print("|");
        for (int i = 0; i < 23; i++) {
            System.out.print("-");
        }
        System.out.print("|");
        System.out.println();

        System.out.printf("|%-12s|%-10s|%-20s|%-10s|%-12s|%-10s|%-12s|%-10s|\n",
                "", "Student ID", "Student's Name", "", "Place 1",
                "Date 1", "Place 2", "Date 2");

        System.out.print("|");
        for (int i = 0; i < 12; i++) {
            System.out.print("-");
        }
        System.out.print("|");
        for (int i = 0; i < 31; i++) {
            System.out.print("-");
        }
        System.out.print("|----------|-----------------------|-----------------------|");
        System.out.println();

        for (int i = 0; i < list.size(); i++) {
            System.out.printf("|%-12s|%-10s|%-20s|%-10s|%-12s|%-10s|%-12s|%-10s|\n",
                    list.get(i).getInjectionID(), list.get(i).getStudent().getStudentID(),
                    list.get(i).getStudent().getStudentName(), list.get(i).getVaccine().getVaccineID(),
                    list.get(i).getPlace1(), list.get(i).getDate1(), list.get(i).getPlace2(),
                    list.get(i).getDate2());
        }
        for (int i = 0; i < 105; i++) {
            System.out.print("-");
        }
        System.out.println();
    }

    //-------------6-------------------
    public boolean writeToFileOut(String fileName) {
        if (list.isEmpty()) {
            //System.out.println("The list is empty.\n");
            return false;
        }
        
        try {
            FileWriter studentVaccineFile = new FileWriter(fileName);
            for (StudentVaccine x : list) {
                studentVaccineFile.write(shifter.encodeComplex(x.toString()) + "\n");
            }
            studentVaccineFile.close();
            return true;
        } catch (Exception e) {
        }
        return false;
    }
    
    public boolean writeToFileIn(String fileName) {
        if (list.isEmpty()) {
            //System.out.println("The list is empty.\n");
            return false;
        }
        
        try {
            FileWriter studentVaccineFile = new FileWriter(fileName);
            for (StudentVaccine x : list) {
                studentVaccineFile.write(x.toString().toUpperCase() + "\n");
            }
            studentVaccineFile.close();
            //System.out.println("Successfully wrote to the file.\n");
            return true;
        } catch (Exception e) {
        }
        return false;
    }
    //---------------7----------------

    //-----------8----------------
}

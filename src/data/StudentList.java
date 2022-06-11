package data;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class StudentList {

    private ArrayList<Student> list = new ArrayList();

    public ArrayList<Student> getList() {
        return list;
    }

    public String getStudentName(String stdID) {
        return list.get(search(stdID)).getStudentName();
    }

    public int search(String stdID) {
        if (list.isEmpty()) {
            return -1;
        }
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getStudentID().equalsIgnoreCase(stdID)) {
                return i;
            }
        }
        return -1;
    }

    public void add(Student std) {
        if (list.isEmpty()) {
            this.add(std);
            return;
        }

        if (search(std.getStudentID()) >= 0) {
            return;
        }

        this.add(std);
    }

    public void readFromFile(String fileIn) {
        try {
            File studentFile = new File(fileIn);
            if (!studentFile.exists()) {
                System.out.println("File does not exist.");
                return;
            }
            FileReader fr = new FileReader(studentFile);
            BufferedReader br = new BufferedReader(fr);
            String detail;
            while ((detail = br.readLine()) != null) {
                StringTokenizer stk = new StringTokenizer(detail, ",");

                String id = stk.nextToken().trim().toUpperCase();
                String name = stk.nextToken().trim().toUpperCase();

                list.add(new Student(id, name));
            }
        } catch (Exception e) {
        }
    }

}

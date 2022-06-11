package data;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class VaccineList {

    private ArrayList<Vaccine> list = new ArrayList();

    public ArrayList<Vaccine> getList() {
        return list;
    }

    public String getVaccineName(String vacID) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getVaccineID().equalsIgnoreCase(vacID))
                return list.get(i).getVaccineName();
        }
        return null;
    }
    
    public int search(String vacID) {
        if (list.isEmpty()) {
            return -1;
        }
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getVaccineID().equalsIgnoreCase(vacID)) {
                return i;
            }
        }
        return -1;
    }

    public void add(Vaccine vac) {
        if (list.isEmpty()) {
            list.add(vac);
            return;
        }

        if (search(vac.getVaccineID()) >= 0) {
            return;
        }

        list.add(vac);
    }

    public void readFromFile(String fileIn) {
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

                String id = stk.nextToken().trim().toUpperCase();
                String name = stk.nextToken().trim().toUpperCase();

                list.add(new Vaccine(id, name));
            }
        } catch (Exception e) {
        }
    }
}

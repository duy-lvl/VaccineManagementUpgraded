package util;

import java.util.Calendar;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Utils {

    private static Scanner sc = new Scanner(System.in);

    public static void printMenu() {
        System.out.println("1. Show information all students have been injected.");
        System.out.println("2. Add student's vaccine injection information.");
        System.out.println("3. Updating information of students' vaccine injection.");
        System.out.println("4. Delete student vaccine injection information.");
        System.out.println("5. Search for injection information.");
        System.out.println("6. Store data to file.");
//        System.out.println("7. Real time update processing.");
//        System.out.println("8. Information Encryption");
        System.out.println("7. Quit.");
        System.out.println("================================");
    }

    public static void printCase5Submenu() {
        System.out.println("1. Search for injection information by student ID.");
        System.out.println("2. Search for injection information by student name.");
        System.out.println("================================");
    }

    public static int getChoice(String msg, int min, int max, String errorMsg) {
        int choice = 0;
        do {
            choice = getAnInteger(msg);
            if (choice < min || choice > max) {
                System.out.println(errorMsg);
            }
        } while (choice < min || choice > max);

        return choice;
    }

    public static String getChoice(String msg, String errMsg) {
        String choice = null;
        do {
            choice = getString(msg).toUpperCase();
            if (choice.equals("Y")) {
                return "y";
            }
            if (choice.equals("N")) {
                return "n";
            }
            System.out.println(errMsg);
        } while (!(choice.equals("n") || choice.equals("y")));
        return choice;
    }

    public static int getAnInteger(String msg) {
        int result = 0;
        while (true) {
            try {
                System.out.print(msg);
                result = Integer.parseInt(sc.nextLine());
                return result;
            } catch (Exception e) {
            }
        }
    }

    public static double getADouble(String msg) {
        double result = 0;
        while (true) {
            try {
                System.out.print(msg);
                result = Double.parseDouble(sc.nextLine());
                return result;
            } catch (Exception e) {
            }
        }
    }

    public static String getString(String msg) {
        String result;

        while (true) {
            System.out.print(msg);
            result = sc.nextLine().trim();
            if (result != null && !result.isEmpty()) {
                return result;
            }
        }

    }

    public static String getString(String msg, String errorMsg) {
        String result;

        while (true) {
            System.out.print(msg);
            result = sc.nextLine().trim();
            if (result != null && !result.isEmpty()) {
                return result;
            } else {
                System.out.println(errorMsg);
            }
        }

    }

    public static boolean isLeap(int yyyy) {
        if ((yyyy % 400 == 0) || ((yyyy % 4 == 0) && !(yyyy % 100 == 0))) {
            return true;
        }
        return false;
    }

    public static boolean isValidDate(int dd, int mm, int yyyy) {
        int maxD;
        if (mm > 12 || mm < 1 || dd < 1 || dd > 31) {
            return false;
        }
        if (mm == 4 || mm == 6 || mm == 9 || mm == 11) {
            maxD = 30;
        } else if (mm != 2) {
            maxD = 31;
        } else if (isLeap(yyyy)) {
            maxD = 29;
        } else {
            maxD = 28;
        }
        return (dd < maxD);
    }

    public static long toDate(String ddmmyyyy) {
        StringTokenizer stk = new StringTokenizer(ddmmyyyy, "/-");
        int dd = Integer.parseInt(stk.nextToken());
        int mm = Integer.parseInt(stk.nextToken());
        int yyyy = Integer.parseInt(stk.nextToken());
        if (!isValidDate(dd, mm, yyyy)) {
            return -1;
        }
        Calendar cal = Calendar.getInstance();
        cal.set(yyyy, mm - 1, dd);
        long t = cal.getTime().getTime();
        return t;
    }

    public static long oneWeek() {
        Calendar cal = Calendar.getInstance();
        cal.set(2021, 9, 22);
        long t1 = cal.getTime().getTime();
        cal.set(2021, 9, 29);
        long t2 = cal.getTime().getTime();
        return t2 - t1;
    }

    //test
    public static void main(String[] args) {
        String choice;
        do {
            choice = Utils.getChoice("Do you want to continue adding new injection (y/n)? ", "y/n please!");
        } while (choice.equals("y"));

    }
}

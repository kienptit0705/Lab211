package view;

import java.util.HashMap;

public class StudentView {

    private String header;
    private String body;
    private HashMap<String, Integer> report;

    public void setHeader(String header) {
        this.header = header;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public void setMap(HashMap<String, Integer> map) {
        this.report = map;
    }
    public void displayHeader(){
        System.out.println(header);
    }
    public void displayStudent() {
        System.out.println(body);
    }

    public void displayReport() {
        System.out.println("\n-------Report Info--------");
        for (String key : report.keySet()) {
            System.out.printf("%s|%20d", key, report.get(key));
            System.out.println();
        }
    }
    //Show menu
    public static void menu() {
        System.out.println(" 1. Create");
        System.out.println(" 2. Find and Sort");
        System.out.println(" 3. Update/Delete");
        System.out.println(" 4. Report");
        System.out.println(" 5. Exit");
        System.out.print(" Enter your choice: ");
    }
}

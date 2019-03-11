package main.java.tools;

import java.util.Scanner;

public class Input {
    public String getNumber() {
        Scanner scanner = new Scanner(System.in);
        String number = scanner.nextLine();
        return number;
    }
    public String getStudent() {
        Scanner scanner = new Scanner(System.in);
        String studentString=scanner.nextLine();
        return studentString;
    }
    public String getId() {
        Scanner scanner=new Scanner(System.in);
        String idString=scanner.nextLine();
        return idString;
    }
}

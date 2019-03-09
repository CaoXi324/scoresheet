package main.java.tools;

import java.util.Scanner;

public class Input {
    public String getNumber() {
        Scanner scanner = new Scanner(System.in);
        String number = scanner.nextLine();
        return number;
    }
}

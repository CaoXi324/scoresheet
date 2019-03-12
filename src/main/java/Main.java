package main.java;

import main.java.model.Note;
import main.java.model.Student;
import main.java.service.Service;
import main.java.tools.Input;
import main.java.tools.PrintScoreSheet;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws Exception {
        Service service = new Service();
        Input input = new Input();
        Note note = new Note();
        PrintScoreSheet printScoreSheet = new PrintScoreSheet();
        boolean quit = false;
        do {
            service.showMainInterface();
            String number = input.getNumber();

            switch (number) {
                case "1":
                    System.out.println(note.getHint());
                    String studentString = input.getStudent();

                    while (!service.judgeStudentFormat(studentString)) {
                        studentString = service.getCorrectStudent();
                    }
                    Student student = service.getStudentClass(studentString);
                    List<Student> studentFromFile = service.outputStudent();
                    if (studentFromFile == null) {
                        List<Student> originStudentList = new ArrayList<>();
                        originStudentList.add(student);
                        service.saveStudentFile(originStudentList);
                    } else {
                        studentFromFile.add(student);
                        service.saveStudentFile(studentFromFile);
                    }
                    break;

                case "2":
                    System.out.println(note.getHintId());
                    String idString = input.getId();

                    while (!service.judgeIdFormat(idString)) {
                        idString = service.gerCorrectId();
                    }
                    List<Student> neededStudent = service.getNeededStudents(idString);
                    printScoreSheet.printScoreSheet(neededStudent);
                    break;

                case "3":
                    quit = true;

            }

        } while (!quit);
    }
}

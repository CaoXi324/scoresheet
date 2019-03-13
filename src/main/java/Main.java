package main.java;

import main.java.model.Note;
import main.java.model.Student;
import main.java.service.Service;
import main.java.tools.Input;
import main.java.tools.PrintScoreSheet;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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
                    List<Student> originStudentList = new ArrayList<>();
                    List<Student> originStudentFromFile = Optional.ofNullable(studentFromFile).orElseGet(() -> originStudentList);
                    originStudentFromFile.add(student);
                    service.saveStudentFile(originStudentFromFile);
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

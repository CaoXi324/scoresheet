package main.java.service;

import main.java.model.Note;
import main.java.model.Scores;
import main.java.model.Student;
import main.java.tools.Input;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Service {
    static Note note = new Note();
    static Input input = new Input();
    public List<Double> getClassTotalScoreAverageAndMedian() throws Exception {
        List<Student> studentList = outputStudent();
        List<Double> totalScoreList = studentList.stream().map(ele -> ele.getTotalScore())
                .collect(Collectors.toList());
        int number = totalScoreList.size();
        Double classTotalScoreAverage = totalScoreList.stream().reduce(0.0, (a, b) -> a + b) / totalScoreList.size();
        Double classTotalScoreMedian = number % 2 == 0 ? (totalScoreList.get(number / 2) +
                totalScoreList.get(number / 2 - 1)) / 2 :
                totalScoreList.get((number - 1) / 2);
        List<Double> classTotalScoreAverageAndMedian = new ArrayList<>();
        classTotalScoreAverageAndMedian.add(classTotalScoreAverage);
        classTotalScoreAverageAndMedian.add(classTotalScoreMedian);
        return classTotalScoreAverageAndMedian;
    }

    public void showMainInterface() {
        System.out.println(note.getMainInterface());
    }

    public boolean judgeStudentFormat(String studentString) {
        List<String> studentList = Arrays.asList(studentString.split("，"));
        if (studentList.size() > 2) {
            return true;
        } else {
            return false;
        }
    }

    public boolean judgeIdFormat(String idString) {
        List<String> idList = Arrays.asList(idString.split(","));
        boolean ifRight = true;
        for (String str : idList) {
            for (int i = 0; i < str.length(); i++) {
                if (!Character.isDigit(str.charAt(i))) {
                    ifRight = false;
                    break;
                }
            }
        }
        return ifRight;
    }

    public String gerCorrectId() {
        System.out.println(note.getHintIdWhenWrong());
        return input.getId();
    }

    public String getCorrectStudent() {
        System.out.println(note.getHintWhenWrong());
        return input.getStudent();
    }

    public List<Student> getNeededStudents(String ids) throws Exception {
        List<Student> allStudentsList = outputStudent();
        List<String> idString = Arrays.asList(ids.split(","));

        List<Student> neededStudentsList= allStudentsList.stream().filter(ele -> idString.contains(ele.getId())).collect(Collectors.toList());
        System.out.println(neededStudentsList.size());
        return neededStudentsList;
    }

    public Student getStudentClass(String studentString) {
        List<String> studentList = Arrays.asList(studentString.split("，"));
        ArrayList<Scores> scoresList = new ArrayList<>();
        for (int i = 2; i < studentList.size(); i++) {
            String subject = studentList.get(i).split("：")[0];
            Double score = Double.valueOf(studentList.get(i).split("：")[1]);
            scoresList.add(new Scores(subject, score));
        }
        Student student = new Student(studentList.get(0), studentList.get(1), scoresList);
        return student;

    }

    public void saveStudentFile(List<Student> studentsList) throws IOException {

        File file = new File("./src/main/java/student.txt");

        try (ObjectOutputStream outputFile = new ObjectOutputStream(new FileOutputStream(file))) {
            outputFile.writeObject(studentsList);
            outputFile.flush();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {


            System.out.println("学生" + studentsList.get(studentsList.size() - 1).getName() + "的成绩被添加");
        }
    }

    static public List<Student> outputStudent() throws Exception {
        List<Student> StudentDeserializable = null;
        File file = new File("./src/main/java/student.txt");
        if (!file.exists()) {
            file.createNewFile();
        }
        try (ObjectInputStream inputFile = new ObjectInputStream((new FileInputStream(file)))) {
            StudentDeserializable = (ArrayList<Student>) inputFile.readObject();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {

            return StudentDeserializable;
        }
    }
}


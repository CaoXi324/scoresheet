package main.java.tools;

import main.java.model.Student;
import main.java.service.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class PrintScoreSheet {
    public void printScoreSheet(List<Student> neededStudentList) throws Exception {
        Service service = new Service();
        final String FIRSTLINE = "成绩单";
        final String SHORTLINES = "========================";
        List<Double> totalScoreAverageAndMedian = service.getClassTotalScoreAverageAndMedian();
        String subjectListString = neededStudentList.get(0).getScores().stream().map(ele -> ele.getSubject())
                .collect(Collectors.joining("|"));
        System.out.println(FIRSTLINE);
        List<String> nameAndScore = new ArrayList<>();
        for (Student student : neededStudentList) {
            nameAndScore.add(student.getName() + "|" + student.getScores().stream().map(ele -> ele.getScore().toString())
                    .collect(Collectors.joining("|")) +
                    student.getAverageScore().toString() + "|" + student.getTotalScore().toString());
        }
        System.out.println("姓名|" + subjectListString + "|平均分|" + "总分");
        System.out.println(SHORTLINES);
        for (String element : nameAndScore) {
            System.out.println(element);
        }
        System.out.println(SHORTLINES);
        System.out.println("全班总分平均数："+totalScoreAverageAndMedian.get(0));
        System.out.println("全班总分中位数："+totalScoreAverageAndMedian.get(1));

    }
}

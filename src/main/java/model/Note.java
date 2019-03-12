package main.java.model;

public class Note {
     private final String mainInterface = "1. 添加学生" + "\n" + "2. 生成成绩单" + "\n" + "3. 退出" + "\n";

     private final String hint = "请输入学生信息（格式：姓名，学号，学科: 成绩， ...），按回车提交：";
     private final String hintWhenWrong = "请按正确的格式输入（格式：姓名，学号，学科: 成绩， ...）：";
     private final String hintIdWhenWrong="请按正确的格式输入要打印的学生的学号（格式： 学号，学号,...），按回车提交：";
     private final String hintId="请输入要打印的学生的学号（格式： 学号，学号，...），按回车提交：";

    //    private final String hintWhenRight="学生"+student.name+"的成绩被添加";
     public String getMainInterface() {
        return mainInterface;
    }

     public String getHint() {
        return hint;
    }


     public String getHintWhenWrong() {
        return hintWhenWrong;
    }

    public String getHintIdWhenWrong() {
        return hintIdWhenWrong;
    }

    public String getHintId() {
        return hintId;
    }
}

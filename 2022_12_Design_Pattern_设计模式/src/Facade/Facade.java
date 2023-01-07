package Facade;

public class Facade {
    //被委托的对象,报名,排队,体检,检录
    SignUp sign;
    LineUp line;
    Exam exam;
    CheckIn check;

    //外观设计模式创建新的报名，排队等过程
    public Facade() {
        sign = new SignUp();
        line = new LineUp();
        exam = new Exam();
        check = new CheckIn();
    }

    //提供给外部访问的方法，做这四个工作
    public void method_Signup() {
        this.sign.dosomething();
    }

    public void method_LineUp() {
        this.line.dosomething();
    }

    public void method_Exam() {
        this.exam.dosomething();
    }

    public void method_CheckIn() {
        this.check.dosomething();
    }


    //外观设计的四个method
    public void method() {
        method_Signup();
        method_LineUp();
        method_Exam();
        method_CheckIn();
    }
}

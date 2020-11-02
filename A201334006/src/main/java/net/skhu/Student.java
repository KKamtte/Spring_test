package net.skhu;

public class Student {
    int id;
    String studentNumber;
    String studentName;
    String email;

    public Student(int id, String number, String name, String email) {
        this.id = id;
        this.studentNumber = number;
        this.studentName = name;
        this.email = email;
    }

    public Student() {
    }

    public int getid() {
        return id;
    }

    public void setid(int id) {
        this.id = id;
    }

    public String getstudentNumber() {
        return studentNumber;
    }

    public void setstudentNumber(String number) {
        this.studentNumber = number;
    }

    public String getstudentName() {
        return studentName;
    }

    public void setstudentName(String name) {
        this.studentName = name;
    }

    public String getemail() {
        return email;
    }

    public void setemail(String email) {
        this.email = email;
    }
}
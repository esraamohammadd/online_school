package com.example.school.pojo;

public class TeatcherModel {

    private  String name;
    private  String phone;
    private String subject;
    private String c1;
    private String c2;
    private String c3;

    public TeatcherModel() {
    }

    public TeatcherModel(String name, String phone,
                         String subject, String c1, String c2, String c3) {
        this.name = name;
        this.phone = phone;
        this.subject = subject;
        this.c1 = c1;
        this.c2 = c2;
        this.c3 = c3;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getC1() {
        return c1;
    }

    public void setC1(String c1) {
        this.c1 = c1;
    }

    public String getC2() {
        return c2;
    }

    public void setC2(String c2) {
        this.c2 = c2;
    }

    public String getC3() {
        return c3;
    }

    public void setC3(String c3) {
        this.c3 = c3;
    }
}

package com.example.schoolapp.pojo;

public class TeatcherData {
    private String fullName;
    private String phone_No;
    private String class1;
    private String class2;
    private String class3;
    private String ssn;
    private String subject1;
    private String userName;
    private String password;
    private String tech_id;
    private String address;





    public TeatcherData() {
    }

    public TeatcherData(String fullName , String phone_No , String class1 , String class2 ,
                        String class3 , String ssn , String subject1
                        , String userName , String password, String tech_id, String address) {
        this.fullName = fullName;
        this.phone_No = phone_No;
        this.class1 = class1;
        this.class2 = class2;
        this.class3 = class3;
        this.ssn = ssn;
        this.subject1 = subject1;
        this.userName = userName;
        this.password = password;
        this.tech_id =tech_id;
        this.address=address;

    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getPhone_No() {
        return phone_No;
    }

    public void setPhone_No(String phone_No) {
        this.phone_No = phone_No;
    }

    public String getClass1() {
        return class1;
    }

    public void setClass1(String class1) {
        this.class1 = class1;
    }

    public String getClass2() {
        return class2;
    }

    public void setClass2(String class2) {
        this.class2 = class2;
    }

    public String getSsn() {
        return ssn;
    }

    public void setSsn(String ssn) {
        this.ssn = ssn;
    }

    public String getSubject1() {
        return subject1;
    }

    public void setSubject1(String subject1) {
        this.subject1 = subject1;
    }


    public String getClass3() {
        return class3;
    }

    public void setClass3(String class3) {
        this.class3 = class3;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getTech_id() {
        return tech_id;
    }

    public void setTech_id(String tech_id) {
        this.tech_id = tech_id;
    }
}

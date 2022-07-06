package com.example.school.pojo;

public class StudentData
{
    private String fullName;
    private String student_phone;
    private String year;
    private String ssn;
    private String parent_phone;
    private String id;
    private String address;
    private String password;
    private String user_name;




    public StudentData() {
    }

    public StudentData(String fullName , String student_phone ,
                       String year , String ssn , String parent_phone , String id ,
                       String address , String password , String user_name) {
        this.fullName = fullName;
        this.student_phone = student_phone;
        this.year = year;
        this.ssn = ssn;
        this.parent_phone = parent_phone;
        this.id = id;
        this.address = address;
        this.password = password;
        this.user_name = user_name;
    }

    public StudentData(String fullName , String year ,
                       String ssn , String parent_phone , String id ,
                       String address , String password , String user_name) {
        this.fullName = fullName;
        this.year = year;
        this.ssn = ssn;
        this.parent_phone = parent_phone;
        this.id = id;
        this.address = address;
        this.password = password;
        this.user_name = user_name;
    }

    public StudentData(String fullName , String year ,
                       String ssn , String id , String address
            , String password , String user_name) {
        this.fullName = fullName;
        this.year = year;
        this.ssn = ssn;
        this.id = id;
        this.address = address;
        this.password = password;
        this.user_name = user_name;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getStudent_phone() {
        return student_phone;
    }

    public void setStudent_phone(String student_phone) {
        this.student_phone = student_phone;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getSsn() {
        return ssn;
    }

    public void setSsn(String ssn) {
        this.ssn = ssn;
    }

    public String getParent_phone() {
        return parent_phone;
    }

    public void setParent_phone(String parent_phone) {
        this.parent_phone = parent_phone;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }
}

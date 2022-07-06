package com.example.schoolapp.pojo;


public class StudentModel  {

    private  String name;
    private  String classs;
    private  String img;
    private  String phone;
    private  String parent_phone;

    public StudentModel() {
    }

    public StudentModel(String name, String classs, String img, String phone, String parent_phone) {
        this.name = name;
        this.classs = classs;
        this.img = img;
        this.phone = phone;
        this.parent_phone = parent_phone;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getClasss() {
        return classs;
    }

    public void setClasss(String classs) {
        this.classs = classs;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getParent_phone() {
        return parent_phone;
    }

    public void setParent_phone(String parent_phone) {
        this.parent_phone = parent_phone;
    }
}

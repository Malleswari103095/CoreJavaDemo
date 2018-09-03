package com.corejavademo.oops;

import java.util.Date;

class Student {

    private String name;

    private int age;

    private Date dob;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) throws Exception {

        if (age < 0 || age > 20)
            throw new Exception("Invalid age : " + age);

        this.age = age;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) throws Exception {

        if (dob.getYear() < 1990 || dob.getYear() > 2000)
            throw new Exception("Invalid date of birth year : " + dob.getYear());

        this.dob = dob;
    }

    public String toString() {
        return "Name : " + this.getName() + ", Age : " + this.getAge() + ", DOB : " + this.getDob();
    }
}

public class Encapsulation {

    public static void main(String[] args) {

        try {
            Student student1 = new Student();
            student1.setName("John");
            student1.setAge(56);
            student1.setDob(new Date());

            System.out.println("Student1 : " + student1.toString());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        try {
            Student student2 = new Student();
            student2.setName("John");
            student2.setAge(15);
            student2.setDob(new Date(1993, 6, 24));

            System.out.println("Student2 : " + student2.toString());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}

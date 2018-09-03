package com.corejavademo.oops;

import java.util.Date;

class Person {

    public String name;

    public int age;

    public Date dob;

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
        this.age = age;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public String toString() {
        return "Name : " + this.getName() + ", Age : " + this.getAge() + ", DOB : " + this.getDob();
    }
}

public class NoEncapsulation {

    public static void main(String[] args) throws Exception {

        Person person1 = new Person();
        person1.setName("John");
        person1.setAge(-1);
        person1.setDob(new Date());

        System.out.println("Person1 : " + person1.toString());


        Person person2 = new Person();
        person2.name = "Bob";
        person2.age = 150;
        person2.dob = new Date();

        System.out.println("Person2 : " + person2.toString());
    }
}

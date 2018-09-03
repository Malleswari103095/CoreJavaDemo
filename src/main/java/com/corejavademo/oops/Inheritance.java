package com.corejavademo.oops;

class Teacher extends Person {

    private String qualification;

    public String getQualification() {
        return qualification;
    }

    public void setQualification(String qualification) {
        this.qualification = qualification;
    }

    @Override
    public void setAge(int age) throws Exception {

        if (age < 20 || age > 50)
            throw new Exception("Invalid age : " + age);

        this.age = age;
    }
}

public class Inheritance {

    public static void main(String args[]) {

        try {
            Teacher teacher1 = new Teacher();
            teacher1.setQualification("M.Tech");

            teacher1.setAge(10);

            System.out.println(teacher1.toString());

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }


}

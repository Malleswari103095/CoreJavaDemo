package com.corejavademo.oops;

interface PersonDao {

    String fetchPersonName(String id);
}

class StudentDaoImpl implements PersonDao {

    @Override
    public String fetchPersonName(String id) {

        // Fetch from cache

        // if not, fetch from db

        // if not found, fetch through network

        return new Student().getName();
    }
}

public class Abstraction {

    public static void main(String[] args) {

//        StudentDao studentDao = new StudentDaoImpl();
//
//        studentDao.fetchStudentName("123");
    }

}

package com.csye6225.spring2020.courseservice.service;

import com.csye6225.spring2020.courseservice.datamodel.InMemoryDatabase;
import com.csye6225.spring2020.courseservice.datamodel.Student;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class StudentsService {
    static HashMap<Long, Student> studentDB = InMemoryDatabase.getStudentDB();

    public StudentsService() {
    }

    // GET "..webapi/students"
    public List<Student> getAllStudents() {
        //Getting the list
        ArrayList<Student> list = new ArrayList<>();
        for (Student student : studentDB.values()) {
            list.add(student);
        }
        return list ;
    }

    public Student addStudent(Student student) {
        // Next Id
        long nextAvailableId = studentDB.size() + 1;
        student.setId(nextAvailableId);

        studentDB.put(nextAvailableId, student);

        return student;
    }


    public Student getStudent(Long studentID) {

        //Simple HashKey Load
        Student student = studentDB.get(studentID);
        System.out.println("Item retrieved:");
        System.out.println(student.toString());

        return student;
    }

    public Student deleteStudent(Long studentID) {
        Student deletedStudentDetails = studentDB.get(studentID);
        studentDB.remove(studentID);
        return deletedStudentDetails;
    }

    public Student updateStudentInformation(Long studentID, Student student) {
        student.setId(studentID);
        studentDB.put(studentID, student);
        return student;
    }
}

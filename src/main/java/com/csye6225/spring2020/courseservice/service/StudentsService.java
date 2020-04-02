package com.csye6225.spring2020.courseservice.service;

import com.amazonaws.services.dynamodbv2.datamodeling.TransactionWriteRequest;
import com.amazonaws.services.dynamodbv2.model.TransactionCanceledException;
import com.csye6225.spring2020.courseservice.datamodel.Course;
import com.csye6225.spring2020.courseservice.datamodel.Student;
import com.csye6225.spring2020.courseservice.utils.ResponseWrapper;

import java.util.HashSet;

public class StudentsService extends RestService<Student>{
    private CoursesService coursesService;
    public StudentsService() {
        super(Student.class);
        this.coursesService = new CoursesService();
    }

    public ResponseWrapper registerCourse(String studentId, String courseId) {
        Student student = get(studentId).getBody();

        if (student == null) {
            return ResponseWrapper.ofErr(1, "student does not exist");
        }
        if (student.getRegisteredCourses() == null) {
            student.setRegisteredCourses(new HashSet<>());
        }
        if (student.getRegisteredCourses().contains(courseId)) {
            return ResponseWrapper.ofErr(1, "already registered");
        }
        Course course = coursesService.get(courseId).getBody();

        if (course == null) {
            return ResponseWrapper.ofErr(1, "course does not exist");
        }
        if (course.getEnrolledStudents() == null) {
            course.setEnrolledStudents(new HashSet<>());
        }
        if (course.getEnrolledStudents().contains(studentId)) {
            return ResponseWrapper.ofErr(1, "alreay enrolled");
        }

        student.getRegisteredCourses().add(courseId);
        course.getEnrolledStudents().add(studentId);

        try {
            TransactionWriteRequest transactionWriteRequest = new TransactionWriteRequest();
            transactionWriteRequest.addUpdate(student);
            transactionWriteRequest.addUpdate(course);
            mapper.transactionWrite(transactionWriteRequest);
        } catch (TransactionCanceledException tce) {
            return ResponseWrapper.ofErr(1, "internal error, please try again");
        }

        return ResponseWrapper.ofSuc();
    }

}

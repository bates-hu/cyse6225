package com.csye6225.spring2020.courseservice.resources;

import com.csye6225.spring2020.courseservice.datamodel.Student;
import com.csye6225.spring2020.courseservice.service.StudentsService;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("students")
public class StudentsResource {
    StudentsService studentsService = new StudentsService();

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Student> getStudents() {
        return studentsService.getAllStudents();
    }

//    @GET
//    @Produces(MediaType.APPLICATION_JSON)
//    public List<Student> getStudentsByDeparment(
//            @QueryParam("department") String department			) {
//
//        if (department == null) {
//            return profService.getAllStudents();
//        }
//        return profService.getStudentsByDepartment(department);
//
//    }

    // ... webapi/student/1
    @GET
    @Path("/{studentId}")
    @Produces(MediaType.APPLICATION_JSON)
    public Student getStudent(@PathParam("studentId") Long studentID) {
        System.out.println("Student Resource: Looking for: " + studentID);
        return studentsService.getStudent(studentID);
    }

    @DELETE
    @Path("/{studentId}")
    @Produces(MediaType.APPLICATION_JSON)
    public Student deleteStudent(@PathParam("studentId") Long studentId) {
        return studentsService.deleteStudent(studentId);
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Student addStudent(Student student) {
        return studentsService.addStudent(student);
    }

    @PUT
    @Path("/{studentId}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Student updateStudent(@PathParam("studentId") Long profId,
                                 Student prof) {
        return studentsService.updateStudentInformation(profId, prof);
    }
}

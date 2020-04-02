package com.csye6225.spring2020.courseservice.resources;

import com.csye6225.spring2020.courseservice.datamodel.Student;
import com.csye6225.spring2020.courseservice.service.StudentsService;
import com.csye6225.spring2020.courseservice.utils.ResponseWrapper;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Path("students")
public class StudentsResource extends RestResourceTemplate<Student, StudentsService>{

    public StudentsResource() {
        super(new StudentsService());
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public ResponseWrapper<List<Student>> getStudents(
            @QueryParam("department") String department,
            @QueryParam("firstName") String firstName,
            @QueryParam("lastName") String lastName
    ) {
        Map<String, String> filters = new HashMap<>();
        if (department != null) {
            filters.put(department, "department");
        }
        if (firstName != null) {
            filters.put(firstName, "firstName");
        }
        if (lastName != null) {
            filters.put(lastName, "lastName");
        }
        return restService.getAllWithMultipleFilter(filters);
    }


    @Path("/{Id}/register/{courseId}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public ResponseWrapper registerCourse(
            @PathParam("Id") String Id,
            @PathParam("courseId") String courseId
    ) {
        return restService.registerCourse(Id, courseId);
    }
}

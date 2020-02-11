package com.csye6225.spring2020.courseservice.resources;

import com.csye6225.spring2020.courseservice.datamodel.Course;
import com.csye6225.spring2020.courseservice.service.CoursesService;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.Date;
import java.util.List;
@Path("courses")
public class CoursesResource {
    CoursesService coursesService = new CoursesService();

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Course> getCourses() {
        return coursesService.getAllCourses();
    }

//    @GET
//    @Produces(MediaType.APPLICATION_JSON)
//    public List<Course> getCoursesByDeparment(
//            @QueryParam("department") String department			) {
//
//        if (department == null) {
//            return profService.getAllCourses();
//        }
//        return profService.getCoursesByDepartment(department);
//
//    }

    // ... webapi/course/1
    @GET
    @Path("/{courseId}")
    @Produces(MediaType.APPLICATION_JSON)
    public Course getCourse(@PathParam("courseId") Long courseID) {
        System.out.println("Course Resource: Looking for: " + courseID);
        return coursesService.getCourse(courseID);
    }

    @DELETE
    @Path("/{courseId}")
    @Produces(MediaType.APPLICATION_JSON)
    public Course deleteCourse(@PathParam("courseId") Long courseId) {
        return coursesService.deleteCourse(courseId);
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Course addCourse(Course course) {
        return coursesService.addCourse(course);
    }

    @PUT
    @Path("/{courseId}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Course updateCourse(@PathParam("courseId") Long profId,
                                 Course prof) {
        return coursesService.updateCourseInformation(profId, prof);
    }

}

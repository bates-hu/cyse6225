package com.csye6225.spring2020.courseservice.service;

import com.csye6225.spring2020.courseservice.datamodel.InMemoryDatabase;
import com.csye6225.spring2020.courseservice.datamodel.Course;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class CoursesService {
    static HashMap<Long, Course> courseDB = InMemoryDatabase.getCourseDB();

    public CoursesService() {
    }

    // GET "..webapi/courses"
    public List<Course> getAllCourses() {
        //Getting the list
        ArrayList<Course> list = new ArrayList<>();
        for (Course course : courseDB.values()) {
            list.add(course);
        }
        return list ;
    }

    public Course addCourse(Course course) {
        // Next Id
        long nextAvailableId = courseDB.size() + 1;
        course.setId(nextAvailableId);
        courseDB.put(course.getId(), course);

        return course;
    }


    public Course getCourse(Long courseID) {

        //Simple HashKey Load
        Course course = courseDB.get(courseID);
        System.out.println("Item retrieved:");
        System.out.println(course.toString());

        return course;
    }

    public Course deleteCourse(Long courseID) {
        Course deletedCourseDetails = courseDB.get(courseID);
        courseDB.remove(courseID);
        return deletedCourseDetails;
    }

    public Course updateCourseInformation(Long courseID, Course course) {
        course.setId(courseID);
        courseDB.put(courseID, course);
        return course;
    }
}

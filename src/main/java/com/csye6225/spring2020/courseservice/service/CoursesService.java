package com.csye6225.spring2020.courseservice.service;

import com.csye6225.spring2020.courseservice.datamodel.Course;

public class CoursesService extends RestService<Course>{

    public CoursesService() {
        super(Course.class);
    }

}

package com.csye6225.spring2020.courseservice.service;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.csye6225.spring2020.courseservice.datamodel.Professor;
import com.csye6225.spring2020.courseservice.utils.ResponseWrapper;

public class ProfessorsService extends RestService<Professor>{

    public ProfessorsService() {
        super(Professor.class);
    }

    // Get professors for a year with a size limit

    public static void main(String[] args) {
        ProfessorsService service = new ProfessorsService();
        service.getAll().getBody().forEach(System.out::println);
        Professor professor = new Professor();
        professor.setId("jackttt");
        System.out.println(service.addWithUniqueID(professor));

    }

}
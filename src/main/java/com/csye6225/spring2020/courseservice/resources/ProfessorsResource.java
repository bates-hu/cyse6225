package com.csye6225.spring2020.courseservice.resources;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import com.csye6225.spring2020.courseservice.datamodel.Professor;
import com.csye6225.spring2020.courseservice.service.ProfessorsService;
import com.csye6225.spring2020.courseservice.utils.ResponseWrapper;

import java.util.HashMap;
import java.util.Map;

@Path("professors")
public class ProfessorsResource extends RestResourceTemplate<Professor, ProfessorsService> {

    public ProfessorsResource() {
        super(new ProfessorsService());
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public ResponseWrapper getAll(
            @QueryParam("department") String department,
            @QueryParam("firstName") String firstName,
            @QueryParam("lastName") String lastName) {

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
}

package com.csye6225.spring2020.courseservice.resources;

import com.csye6225.spring2020.courseservice.datamodel.Course;
import com.csye6225.spring2020.courseservice.service.CoursesService;
import com.csye6225.spring2020.courseservice.utils.ResponseWrapper;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Path("courses")
public class CoursesResource extends RestResourceTemplate<Course, CoursesService>{
    public CoursesResource() {
        super(new CoursesService());
    }


    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public ResponseWrapper<List<Course>> getAll(
            @QueryParam("professorId") String professorId,
            @QueryParam("taId") String taId,
            @QueryParam("department") String department,
            @QueryParam("boardId") String boardId) {
        Map<String, String> filters = new HashMap<>();
        if (professorId != null) {
            filters.put(professorId, "professorId");
        }
        if (taId != null) {
            filters.put(taId, "taId");
        }
        if (department != null) {
            filters.put(department, "department");
        }
        if (boardId != null) {
            filters.put(boardId, "boardId");
        }
        return restService.getAllWithMultipleFilter(filters);
    }


}

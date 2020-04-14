package com.csye6225.spring2020.courseservice.resources;

import com.csye6225.spring2020.courseservice.datamodel.Announcement;
import com.csye6225.spring2020.courseservice.datamodel.Board;
import com.csye6225.spring2020.courseservice.service.BoardService;
import com.csye6225.spring2020.courseservice.utils.ResponseWrapper;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Path("boards")
public class BoardsResource extends RestResourceTemplate<Board, BoardService> {
    public BoardsResource() {
        super(new BoardService());
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public ResponseWrapper<List<Board>> getAll(
            @QueryParam("courseId") String courseId
    ) {
        Map<String, String> filters = new HashMap<>();
        if (courseId != null) {
            filters.put(courseId, "courseId");
        }
        return restService.getAllWithMultipleFilter(filters);
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Override
    public ResponseWrapper add(Board model) {
        return restService.addWithGeneratedId(model);
    }
}

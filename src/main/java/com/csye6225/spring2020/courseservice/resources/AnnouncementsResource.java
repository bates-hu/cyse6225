package com.csye6225.spring2020.courseservice.resources;

import com.csye6225.spring2020.courseservice.datamodel.Announcement;
import com.csye6225.spring2020.courseservice.datamodel.Student;
import com.csye6225.spring2020.courseservice.service.AnnouncementService;
import com.csye6225.spring2020.courseservice.utils.ResponseWrapper;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;


@Path("announcements")
public class AnnouncementsResource extends RestResourceTemplate<Announcement, AnnouncementService> {
    public AnnouncementsResource() {
        super(new AnnouncementService());
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public ResponseWrapper<List<Announcement>> getAll(
            @QueryParam("boardId") String boardId) {
        if (boardId == null) {
            return restService.getAll();
        } else {
            return restService.getAnnoucementsByBoardId(boardId);
        }
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Override
    public ResponseWrapper add(Announcement model) {
        return restService.addWithGeneratedId(model);
    }

}

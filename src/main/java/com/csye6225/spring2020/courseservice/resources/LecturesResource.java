package com.csye6225.spring2020.courseservice.resources;

import com.csye6225.spring2020.courseservice.datamodel.Lecture;
import com.csye6225.spring2020.courseservice.service.LecturesService;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.Date;
import java.util.List;

@Path("lectures")
public class LecturesResource {
    LecturesService lecturesService = new LecturesService();

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Lecture> getLectures() {
        return lecturesService.getAllLectures();
    }

    // ... webapi/lecture/1
    @GET
    @Path("/{lectureId}")
    @Produces(MediaType.APPLICATION_JSON)
    public Lecture getLecture(@PathParam("lectureId") Long lectureID) {
        System.out.println("Lecture Resource: Looking for: " + lectureID);
        return lecturesService.getLecture(lectureID);
    }

    @DELETE
    @Path("/{lectureId}")
    @Produces(MediaType.APPLICATION_JSON)
    public Lecture deleteLecture(@PathParam("lectureId") Long lectureId) {
        return lecturesService.deleteLecture(lectureId);
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Lecture addLecture(Lecture lecture) {
        lecture.setPublishDate(new Date().toString());
        //prof.setId(prof.getLectureId());
        return lecturesService.addLecture(lecture);
    }

    @PUT
    @Path("/{lectureId}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Lecture updateLecture(@PathParam("lectureId") Long profId,
                                     Lecture prof) {
        return lecturesService.updateLectureInformation(profId, prof);
    }

}

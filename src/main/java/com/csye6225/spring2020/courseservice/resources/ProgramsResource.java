package com.csye6225.spring2020.courseservice.resources;

import com.csye6225.spring2020.courseservice.datamodel.Program;
import com.csye6225.spring2020.courseservice.service.ProgramsService;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("programs")
public class ProgramsResource {
    ProgramsService programsService = new ProgramsService();

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Program> getPrograms() {
        return programsService.getAllPrograms();
    }

//    @GET
//    @Produces(MediaType.APPLICATION_JSON)
//    public List<Program> getProgramsByDeparment(
//            @QueryParam("department") String department			) {
//
//        if (department == null) {
//            return profService.getAllPrograms();
//        }
//        return profService.getProgramsByDepartment(department);
//
//    }

    // ... webapi/program/1
    @GET
    @Path("/{programId}")
    @Produces(MediaType.APPLICATION_JSON)
    public Program getProgram(@PathParam("programId") Long programID) {
        System.out.println("Program Resource: Looking for: " + programID);
        return programsService.getProgram(programID);
    }

    @DELETE
    @Path("/{programId}")
    @Produces(MediaType.APPLICATION_JSON)
    public Program deleteProgram(@PathParam("programId") Long programId) {
        return programsService.deleteProgram(programId);
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Program addProgram(Program program) {
        return programsService.addProgram(program);
    }

    @PUT
    @Path("/{programId}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Program updateProgram(@PathParam("programId") Long profId,
                                 Program prof) {
        return programsService.updateProgramInformation(profId, prof);
    }
}

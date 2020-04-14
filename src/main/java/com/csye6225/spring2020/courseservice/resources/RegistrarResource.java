package com.csye6225.spring2020.courseservice.resources;

import com.csye6225.spring2020.courseservice.datamodel.Announcement;
import com.csye6225.spring2020.courseservice.datamodel.Registrar;
import com.csye6225.spring2020.courseservice.service.RegistrarService;
import com.csye6225.spring2020.courseservice.utils.ResponseWrapper;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;


@Path("registerOffering")
public class RegistrarResource extends RestResourceTemplate<Registrar, RegistrarService> {
    public RegistrarResource() {
        super(new RegistrarService());
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Override
    public ResponseWrapper add(Registrar model) {
        return restService.addWithGeneratedId(model);
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public ResponseWrapper<List<Registrar>> getAll() {
        return restService.getAll();
    }

}

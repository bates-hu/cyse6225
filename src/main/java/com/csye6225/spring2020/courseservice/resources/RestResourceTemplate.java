package com.csye6225.spring2020.courseservice.resources;

import com.csye6225.spring2020.courseservice.datamodel.IdObject;
import com.csye6225.spring2020.courseservice.service.RestService;
import com.csye6225.spring2020.courseservice.utils.ResponseWrapper;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

public abstract class RestResourceTemplate<T extends IdObject, S extends RestService<T>> {
    protected S restService;
    public RestResourceTemplate(S service) {
        this.restService = service;
    }

    @GET
    @Path("/{Id}")
    @Produces(MediaType.APPLICATION_JSON)
    public ResponseWrapper getCourse(@PathParam("Id") String Id) {
        return restService.get(Id);
    }

    @DELETE
    @Path("/{Id}")
    @Produces(MediaType.APPLICATION_JSON)
    public ResponseWrapper deleteCourse(@PathParam("Id") String Id) {
        return restService.delete(Id);
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public ResponseWrapper add(T model) {
        return restService.addWithUniqueID(model);
    }

    @PUT
    @Path("/{Id}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public ResponseWrapper update(@PathParam("Id") String Id,
                                  T model) {
        return restService.update(Id, model);
    }
}

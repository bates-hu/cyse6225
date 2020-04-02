package com.csye6225.spring2020.courseservice.resources;


import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.io.InputStream;
import java.net.URL;
import java.util.Properties;

@Path("echo")
public class EchoResource {

    @Path("/env")
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String envEcho() {
        String env = "undefine";

        String path = System.getProperty("user.dir");

        try {
            InputStream inputStream = getClass().getResourceAsStream("/app.properties");
            Properties properties = new Properties();
            properties.load(inputStream);
            env = properties.getProperty("env");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return String.format("env is %s, path is %s", env, path);
    }
}

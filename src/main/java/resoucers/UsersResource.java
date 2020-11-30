package resoucers;


import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.List;

@Path("users")
@Produces(MediaType.APPLICATION_JSON) //[GET] localhost:8080/nazev-appky/api/users

public class UsersResource {

    private static List<String> userList = new ArrayList<>();

    @GET
    public Response GetAll() {
        return Response.ok(userList).build();
    }

    @POST
    public Response create(String username) {
        if (userList.contains(username)) {
            return Response.ok("Username taken").build();
        }

        else {
            userList.add(username);
            return Response.ok("User " + username + " created").build();
        }
    }

    @PUT
    @Path("/{username}")
    public Response edit(String username) {
        return Response.ok("Name Edited").build();
    }

    @DELETE
    @Path("/{username}")
    public Response delete(String username) {
        userList.remove(username);
        return Response.ok("User " + username + " deleted").build();
    }
}
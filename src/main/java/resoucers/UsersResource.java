package resoucers;


import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Path("users")
@Produces(MediaType.APPLICATION_JSON) //[GET] localhost:8080/nazev-appky/api/users


public class UsersResource {

    private static List<String> userList = new ArrayList<>();

    Set<String> set = new HashSet<>(userList);


    @GET
    public Response getAll() {
        return Response.ok(userList).build();
    }


    @POST
    public Response create(@FormParam("username") String username) {

        for (int i = 0; i < userList.size(); i++) {
            String control1 = userList.get(i);
            for(int j = i + 1; j < userList.size(); j++){
                String control2 = userList.get(j);
                if(control2.equals(control1)){
                    return Response.ok("Username taken").build();
                }
            }
        }
        userList.add(username);
        return Response.ok("User " + username + " created").build();
    }



    @PUT
    @Path("/{username}")
    public Response edit(String username) {
      /*  String edit;
        edit = username.replace(username, edit);


        userList.remove(username);
        userList.add(edit);*/

        return Response.ok("User renamed from " /*+ username + " to " + edit*/).build();
    }


    @DELETE
    @Path("/{username}")
    public Response delete(@PathParam("username") String username) {
        System.out.println(username);
        userList.remove(username);
        return Response.ok("User " + username + " deleted").build();
    }
}
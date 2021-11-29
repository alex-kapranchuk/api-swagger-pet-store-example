package client;

import io.restassured.response.Response;
import model.user.User;

import static io.restassured.RestAssured.given;
/**
 * Post - ~ Creates list of users with given input array
 * Get - done (getUser)
 * Put - done (updateUser)
 * Delete - done (deleteUser)
 * Get -  ~ login into system
 * Get - ~ Logs out current logged i user session
 * Post - ~ Creates list of users with given input array
 * Post -  done (createUser)
 * */

public class UserClient extends HttpClient {

    public UserClient() {
        super("user");
    }

    public Response createUser(User user) {
        return given(defaultRequestSpecification)
                .body(user)
                .post();
    }

    public Response getUser(String username) {
        return given(defaultRequestSpecification)
                .get("/{username}", username);
    }

    public Response updateUser(String username, User user) {
        return given(defaultRequestSpecification)
                .body(user)
                .put("/{username}", username);
    }

    public Response deleteUser(String username) {
        return given(defaultRequestSpecification)
                .delete("/{username}", username);
    }
    public Response loginUser(String username, String password){
        return given(defaultRequestSpecification)
                .pathParam("username", username)
                .pathParam("password", password)
                .get("/login?username={username}&password={password}");
    }

    public Response LogoutUser(){
        return given(defaultRequestSpecification)
                .get("/logout");
    }





}

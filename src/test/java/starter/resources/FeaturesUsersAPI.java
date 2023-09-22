package starter.resources;

import io.restassured.http.ContentType;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import starter.utils.Constants;

import java.io.File;

public class FeaturesUsersAPI {
    public static String GET_LIST_USER = Constants.BASE_URL+"/{param}";
    public static String GET_SINGLE_USER =Constants.BASE_URL+"/users/{id}";
    public static String GET_USER_WITH_ID =Constants.BASE_URL+"/users?id={id}";
    public static String POST_USER_WITH_JSON = Constants.BASE_URL+"/users";
    public static String PUT_USER = Constants.BASE_URL+"/users/{id}";
    public static String PATCH_USER = Constants.BASE_URL+"/users/{id}";
    public static String DELETE_USER = Constants.BASE_URL+"/users/{id}";


    @Step("Get list user")
    public void getListPost (String param){
        SerenityRest.given()
                .pathParam("param",param);
    }
    @Step("Get single user")
    public void getSinglePost (int id){
        SerenityRest.given().pathParam("id",id);

    }
    @Step("Get user with id")
    public void getPostWithUserId(Object id){
        SerenityRest.given().pathParam("id",id);
    }
    @Step("Post user With Json")
    public void postWithJson(File json){
        SerenityRest.given()
                .contentType(ContentType.JSON)
                .body(json);
    }
    @Step("Put update user")
    public void putPost(File json,Object id){
        SerenityRest.given()
                .pathParam("id",id)
                .contentType(ContentType.JSON)
                .body(json);
    }
    @Step("Patch update user")
    public void patchPost(File json,Object id){
        SerenityRest.given()
                .pathParam("id",id)
                .contentType(ContentType.JSON)
                .body(json);
    }
    @Step("Delete a user")
    public void deletePost(int id){
        SerenityRest.given()
                .pathParam("id",id);
    }
}

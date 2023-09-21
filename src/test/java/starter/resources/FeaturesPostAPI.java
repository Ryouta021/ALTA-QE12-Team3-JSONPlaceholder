package starter.resources;


import io.restassured.http.ContentType;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;

import starter.utils.Constants;

import java.io.File;

public class FeaturesPostAPI {

    public static String GET_LIST_POST = Constants.BASE_URL+"/{param}";
    public static String GET_SINGLE_POST =Constants.BASE_URL+"/posts/{id}";
    public static String GET_POST_WITH_USERID =Constants.BASE_URL+"/posts?userId={id}";
    public static String POST_WITH_JSON = Constants.BASE_URL+"/posts";
    public static String PUT_POST = Constants.BASE_URL+"/posts/{id}";
    public static String PATCH_POST = Constants.BASE_URL+"posts/{id}";
    public static String DELETE_POST = Constants.BASE_URL+"/posts/{id}";


    @Step("Get list post")
    public void getListPost (String param){
        SerenityRest.given()
                .pathParam("param",param);
    }
    @Step("Get single post")
    public void getSinglePost (int id){
        SerenityRest.given().pathParam("id",id);

    }
    @Step("Get post with user id")
    public void getPostWithUserId(Object id){
        SerenityRest.given().pathParam("id",id);
    }
    @Step("Post With Json")
    public void postWithJson(File json){
                SerenityRest.given()
                .contentType(ContentType.JSON)
                .body(json);
    }
    @Step("Put update")
    public void putPost(File json,Object id){
        SerenityRest.given()
                .pathParam("id",id)
                .contentType(ContentType.JSON)
                .body(json);
    }
    @Step("Patch update")
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

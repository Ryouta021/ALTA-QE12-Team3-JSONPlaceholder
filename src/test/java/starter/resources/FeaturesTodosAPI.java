package starter.resources;

import io.restassured.http.ContentType;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import starter.utils.Constants;

import java.io.File;

public class FeaturesTodosAPI {
    public static String GET_LIST_TODOS = Constants.BASE_URL+"/todos/{id}";
    public static String GET_INVALID_TODOS = Constants.BASE_URL+"/todos/{id}";
    public static String POST_CREATE_TODOS = Constants.BASE_URL+"/todos";
    public static String POST_INVALID_TODOS = Constants.BASE_URL+"/todos";
    public static String PUT_UPDATE_TODOS = Constants.BASE_URL+"/todos/{id}";
    public static String PUT_INVALID_TODOS = Constants.BASE_URL+"/todos/{id}";
    public static String PATCH_UPDATE_TODOS = Constants.BASE_URL+"/todos/{id}";
    public static String PATCH_INVALID_TODOS = Constants.BASE_URL+"/todos/{id}";
    public static String DELETE_TODOS = Constants.BASE_URL+"/todos/{id}";
    public static String DELETE_INVALID_TODOS = Constants.BASE_URL+"/todos/{id}";

    @Step("Get list todos")
    public void getListTodos(int id){
        SerenityRest.given()
                .pathParam("id", id);
    }

    @Step("Get todos invalid id")
    public void getTodosInvalidId(int id){
        SerenityRest.given()
                .pathParam("id", id);
    }

    @Step("Post create new todos")
    public void postCreateNewtodos(File json){
        SerenityRest.given()
                .contentType(ContentType.JSON)
                .body(json);
    }

    @Step("Post invalid todos")
    public void postInvalidTodos(File json) {
        SerenityRest.given()
                .contentType(ContentType.JSON)
                .body(json);
    }

    @Step("Put update todos")
    public void putUpdateTodos( File json, int id){
        SerenityRest.given()
                .pathParam("id", id)
                .contentType(ContentType.JSON)
                .body(json);
    }

    @Step("Put invalid todos")
    public void putInvalidTodos(File json,int id){
        SerenityRest.given()
                .pathParam("id", id)
                .contentType(ContentType.JSON)
                .body(json);
    }

    @Step("Patch update todos")
    public void patchUpdateTodos(File json, int id){
        SerenityRest.given()
                .pathParam("id", id)
                .contentType(ContentType.JSON)
                .body(json);
    }

    @Step("Patch invalid todos")
    public void patchInvalidTodos(File json, int id){
        SerenityRest.given()
                .pathParam("id", id)
                .contentType(ContentType.JSON)
                .body(json);
    }

    @Step("Delete a todos")
    public void deleteATodos(int id){
        SerenityRest.given()
                .pathParam("id", id);
    }

    @Step("Delete invalid a todos")
    public void deleteInvalidTodos(int id){
        SerenityRest.given()
                .pathParam("id", id);
    }

}

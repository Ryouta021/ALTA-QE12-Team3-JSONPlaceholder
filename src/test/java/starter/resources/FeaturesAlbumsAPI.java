package starter.resources;

import io.restassured.http.ContentType;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import starter.utils.Constants;

import java.io.File;

public class FeaturesAlbumsAPI {
    public static String GET_LIST_ALBUM = Constants.BASE_URL+"/albums?page={page}";
    public static String GET_SINGLE_ALBUM = Constants.BASE_URL+"/albums/{id}";
    public static String GET_ALBUM = Constants.BASE_URL+"/albums/{id}";
    public static String GET_SINGLE_ALBUM_INVALID_ID = Constants.BASE_URL+"/albums/{id}";
    public static String POST_CREATE_ALBUM = Constants.BASE_URL+"/albums";
    public static String POST_INVALID_ALBUM = Constants.BASE_URL+"/albums";
    public static String PUT_UPDATE_ALBUM = Constants.BASE_URL+"/albums/{id}";
    public static String PUT_INVALID = Constants.BASE_URL+"/albums/{id}";
    public static String PATCH_UPDATE_ALBUM = Constants.BASE_URL+"/albums/{id}";
    public static String PATCH_INVALID = Constants.BASE_URL+"/albums/{id}";
    public static String DELETE_ALBUM = Constants.BASE_URL+"/albums/{id}";


    @Step("Get list album")
    public void getListAlbum(int page){
        SerenityRest.given()
                .pathParam("page", page);
    }

    @Step("Get single album")
    public void getSingleAlbum(int id) {
        SerenityRest.given()
                .pathParam("id", id);
    }

    @Step("Get album invalid user")
    public void getAlbumInvalidUser(int id){
        SerenityRest.given()
                .pathParam("id", id);
    }

    @Step("Get single album invalid id")
    public void getSingleAlbumInvalidId(int id){
        SerenityRest.given()
                .pathParam("id", id);
    }

    @Step("Post create new album")
    public void postCreateNewAlbum(File json){
        SerenityRest.given()
                .contentType(ContentType.JSON)
                .body(json);
    }

    @Step("Post invalid album")
    public void postInvalidAlbum(File json) {
        SerenityRest.given()
                .contentType(ContentType.JSON)
                .body(json);
    }

    @Step("Put update album")
    public void putUpdateAlbum( File json, int id){
        SerenityRest.given()
                .pathParam("id", id)
                .contentType(ContentType.JSON)
                .body(json);
    }

    @Step("Put invalid album")
    public void putInvalidAlbum(File json,int id){
        SerenityRest.given()
                .pathParam("id", id)
                .contentType(ContentType.JSON)
                .body(json);
        }

    @Step("Patch update user")
    public void patchUpdateAlbum(File json, int id){
        SerenityRest.given()
                .pathParam("id", id)
                .contentType(ContentType.JSON)
                .body(json);
    }

    @Step("Patch invalid album")
    public void patchInvalidAlbum(File json, int id){
        SerenityRest.given()
                .pathParam("id", id)
                .contentType(ContentType.JSON)
                .body(json);
    }

    @Step("Delete a album")
    public void deleteAlbum(int id){
        SerenityRest.given()
                .pathParam("id", id);
    }

}

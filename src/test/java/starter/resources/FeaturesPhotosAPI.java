package starter.resources;

import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import starter.utils.Constants;


public class FeaturesPhotosAPI {
    public static String GET_LIST_PHOTOS = Constants.BASE_URL + "/photos";
    public static String GET_SINGLE_PHOTOS = Constants.BASE_URL + "/photos/{param}";

    public static String PUT_UPDATE_PHOTOS = Constants.BASE_URL + "/photos/{pram}";

    public static String DELETE_PHOTOS = Constants.BASE_URL + "/photos/{id}";

    @Step("Get list photos")
    public void getListPhotos(){
        SerenityRest.given();
    }

    @Step("get single photos")
    public void getSinglePhotos(int param){
        SerenityRest.given()
                .pathParam("param", param);
    }

    @Step("Put update photos")
    public void putUpdatePhotos(int pram){
        SerenityRest.given()
                .pathParam("pram", pram);

    }

    @Step("Delete a photos")
    public void  deleteAPhotos(int id){
        SerenityRest.given()
                .pathParam("id", id);
    }



}

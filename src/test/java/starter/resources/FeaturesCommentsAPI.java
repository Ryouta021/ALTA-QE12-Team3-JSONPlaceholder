package starter.resources;

import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import starter.utils.Constants;



public class FeaturesCommentsAPI {
    public static String GET_LIST_COMMENTS = Constants.BASE_URL + "/comments";
    public static String GET_SINGLE_COMMENTS = Constants.BASE_URL + "/comments/{param}";

    public static String PUT_UPDATE_COMMENTS = Constants.BASE_URL + "/comments/{pram}";

    public static String DELETE_UPDATE_COMMENTS = Constants.BASE_URL + "/comments/{id}";

    @Step("Get list comments")
    public void getListComments(){
        SerenityRest.given();
    }

    @Step("get single comments")
    public void getSingleComments(int param){
        SerenityRest.given()
                .pathParam("param", param);
    }

    @Step("Put update comments")
    public void putUpdateComments(int pram){
        SerenityRest.given()
                .pathParam("pram", pram);

    }

    @Step("Delete a comments")
    public void  deleteAComments(int id){
        SerenityRest.given()
                .pathParam("id", id);
    }



}

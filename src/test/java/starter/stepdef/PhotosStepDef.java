package starter.stepdef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.restassured.module.jsv.JsonSchemaValidator;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import starter.resources.FeaturesPhotosAPI;
import starter.utils.Constants;

import java.io.File;


public class PhotosStepDef {
    @Steps
    FeaturesPhotosAPI featuresPhotosAPI;

    //get all photos
    @Given("Get all photos")
    public void getListPhotos() {featuresPhotosAPI.getListPhotos();
    }
    @When("Send request get list photos")
    public void sendRequestGetListPhotos() {
        SerenityRest.when().get(FeaturesPhotosAPI.GET_LIST_PHOTOS);
    }


    @And("Validate get list photos JSON schema {string}")
    public void validateGetListPhotosJSONSchema(String jsonFile) {
        File json = new File(Constants.JSON_SCHEMA+jsonFile);
        SerenityRest.and()
                .assertThat()
                .body(JsonSchemaValidator.matchesJsonSchema(json));
    }

    //get single photo
    @Given("Get single photo with valid parameter {int}")
    public void getSinglePhotoWitValidIdId(int param) {
        featuresPhotosAPI.getSinglePhotos(param);
    }

    @When("Send request get single photo")
    public void sendRequestGetSinglePhoto() {
        SerenityRest.when().get(FeaturesPhotosAPI.GET_SINGLE_PHOTOS);
    }


    @And("Validate get single photos JSON schema {string}")
    public void validateGetSinglePhotosJSONSchema(String jsonFile) {
        File json = new File(Constants.JSON_SCHEMA+jsonFile);
        SerenityRest.and()
                .assertThat()
                .body(JsonSchemaValidator.matchesJsonSchema(json));
    }

    //get single photo exceed
    @Given("Get single photo with exceed parameter {int}")
    public void getSinglePhotoWithExceedParameter(int param) {
        featuresPhotosAPI.getSinglePhotos(param);
    }




//    // Post create new photo on post
//
//    @Given("Post create new photo")
//    public void postCreateNewPhotoWithValidJsonString() {
//        featuresPhotosAPI.getListPhotos();
//    }
//
//    @When("Send request to create photo")
//    public void sendRequestToCreatePhoto() {
//        SerenityRest.when().post(FeaturesPhotosAPI.GET_LIST_PHOTOS);
//    }
//
//    @Then("Status code should be shown {int}")
//    public void statusCodeShouldBeShown(int sCode) {
//        SerenityRest.then().statusCode(sCode);
//    }
//
//    @And("Response body page")
//    public void responseBodyPage() {
//
//    }


//    Put Update Photos

    @Given("Put update photos with valid param {int}")
    public void putUpdatePhotosWithValidParam(int id) {
        featuresPhotosAPI.putUpdatePhotos(id);
    }


    @When("Send req. to update photo")
    public void sendReqToUpdatePhoto() {
        SerenityRest.when()
                .put(FeaturesPhotosAPI.PUT_UPDATE_PHOTOS);
    }



    @And("Validate put update photo JSON Schema {string}")
    public void validatePutUpdatePhotoJSONSchema(String putJson) {
        File json = new File(Constants.JSON_SCHEMA + putJson);
        SerenityRest.and()
                .assertThat()
                .body(JsonSchemaValidator.matchesJsonSchema(json));
    }

//    Delete a photos
    @Given("Delete photos with valid id {int}")
    public void deletePhotosWithValidIdInt(int id) {
        featuresPhotosAPI.deleteAPhotos(id);
    }


    @When("Send req. to delete  photos")
    public void sendReqToDeletePhotos() {
        SerenityRest.when()
                .delete(FeaturesPhotosAPI.DELETE_PHOTOS);
    }



}

package starter.stepdef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.module.jsv.JsonSchemaValidator;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import starter.resources.FeaturesCommentsAPI;
import starter.resources.ResponseJsonHolder;
import starter.utils.Constants;

import java.io.File;

import static org.hamcrest.Matchers.equalTo;

public class CommentStepDef {
    @Steps
    FeaturesCommentsAPI featuresCommentsAPI;

    //get all comments
    @Given("Get all comments")
    public void getListComments() {featuresCommentsAPI.getListComments();
    }
    @When("Send request get list comments")
    public void sendRequestGetListComments() {
        SerenityRest.when().get(FeaturesCommentsAPI.GET_LIST_COMMENTS);
    }
    @Then("Status code should be {int}")
    public void statusCodeShouldBeInt(int code) {
        SerenityRest.then().statusCode(code);
    }

    @And("First id on response body was {int}")
    public void firstDataOnResponBodyWasIdInt(int idArray) {
        SerenityRest.then()
                .body(ResponseJsonHolder.ID_ARRAY, equalTo(idArray));
    }

    @And("Validate get list comments JSON schema {string}")
    public void validateGetListCommentsJSONSchema(String jsonFile) {
        File json = new File(Constants.JSON_SCHEMA+jsonFile);
        SerenityRest.and()
                .assertThat()
                .body(JsonSchemaValidator.matchesJsonSchema(json));
    }

    //get single comment
    @Given("Get single comment with valid parameter {int}")
    public void getSingleCommentWitValidIdId(int param) {
        featuresCommentsAPI.getSingleComments(param);
    }

    @When("Send request get single comment")
    public void sendRequestGetSingleComment() {
        SerenityRest.when().get(FeaturesCommentsAPI.GET_SINGLE_COMMENTS);
    }

    @And("Response body page should be {int}")
    public void responseBodyPageShouldBe(int id) {
        SerenityRest.then()
                .body(ResponseJsonHolder.ID,equalTo(id));
    }

    @And("Validate get single comments JSON schema {string}")
    public void validateGetSingleCommentsJSONSchema(String jsonFile) {
        File json = new File(Constants.JSON_SCHEMA+jsonFile);
        SerenityRest.and()
                .assertThat()
                .body(JsonSchemaValidator.matchesJsonSchema(json));
    }

    //get single comment exceed
    @Given("Get single comment with exceed parameter {int}")
    public void getSingleCommentWithExceedParameter(int param) {
        featuresCommentsAPI.getSingleComments(param);
    }

    @And("Response body page should be null")
    public void responseBodyPageShouldBeString() {
        SerenityRest.then()
                .body(ResponseJsonHolder.ID,equalTo(null));
    }



//    // Post create new comment on post
//
//    @Given("Post create new comment")
//    public void postCreateNewCommentWithValidJsonString() {
//        featuresCommentsAPI.getListComments();
//    }
//
//    @When("Send request to create comment")
//    public void sendRequestToCreateComment() {
//        SerenityRest.when().post(FeaturesCommentsAPI.GET_LIST_COMMENTS);
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


//    Put Update Comments

    @Given("Put update comments with valid param {int}")
    public void putUpdateCommentsWithValidParam(int id) {
        featuresCommentsAPI.putUpdateComments(id);
    }


    @When("Send req. to update comment")
    public void sendReqToUpdateComment() {
        SerenityRest.when()
                .put(FeaturesCommentsAPI.PUT_UPDATE_COMMENTS);
    }


    @Then("Response code should be {int}")
    public void responseCodeShouldBeInt(int cde) {
        SerenityRest.then().statusCode(cde);
    }


    @And("Response body page is {int}")
    public void responseBodyPageIsPutResponseJson(int id) {
        SerenityRest.then()
                .body(ResponseJsonHolder.ID,equalTo(id));

    }


    @And("Validate put update comment JSON Schema {string}")
    public void validatePutUpdateCommentJSONSchema(String putJson) {
        File json = new File(Constants.JSON_SCHEMA + putJson);
        SerenityRest.and()
                .assertThat()
                .body(JsonSchemaValidator.matchesJsonSchema(json));
    }

//    Delete a comments
    @Given("Delete comments woth valid id {int}")
    public void deleteCommentsWothValidIdInt(int id) {
        featuresCommentsAPI.deleteAComments(id);
    }


    @When("Send req. to delete  comments")
    public void sendReqToDeleteComments() {
        SerenityRest.when()
                .delete(FeaturesCommentsAPI.DELETE_UPDATE_COMMENTS);
    }



}

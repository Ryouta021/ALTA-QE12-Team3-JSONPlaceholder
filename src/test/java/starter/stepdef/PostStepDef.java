package starter.stepdef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import starter.resources.FeaturesPostAPI;
import starter.resources.ResponseJsonHolder;
import starter.utils.Constants;

import java.io.File;
import static org.hamcrest.Matchers.equalTo;
public class PostStepDef {

    @Steps
    FeaturesPostAPI featuresPostAPI;

//    GET LIST POST ALL
//        POSITIVE CASE
    @Given("Get list post with valid parameter {string}")
    public void getListPostWithValidParameter(String param) {
        featuresPostAPI.getListPost(param);
    }

    @When("Send Request get list post")
    public void sendRequestGetListPost() {
        SerenityRest.when().get(featuresPostAPI.GET_LIST_POST);
    }

    @Then("Status code should be {int} ok")
    public void statusCodeShouldBeOk(int ok) {
        SerenityRest.then().statusCode(ok);
    }
//        NEGATIVE CASE
    @Given("Get list post with invalid parameter {string}")
    public void getListPostWithInvalidParameter(String param) {
        featuresPostAPI.getListPost(param);
    }

    @Then("Status code should be {int} not found")
    public void statusCodeShouldBeNotFound(int notFound) {
        SerenityRest.then().statusCode(notFound);
    }
//    SINGLE USER
    @Given("Get single post with valid id {int}")
    public void getSinglePostWithValidId(int id) {
        featuresPostAPI.getSinglePost(id);
    }
    @When("Send Request get single post")
    public void sendRequestGetSinglePost() {
        SerenityRest.when().get(featuresPostAPI.GET_SINGLE_POST);
    }
    @Given("Get single post with invalid id {int}")
    public void getSinglePostWithInvalidId(int id) {
        featuresPostAPI.getSinglePost(id);
    }
//     USER ID
    @Given("Get post with user id {int}")
    public void getPostWithUserId(int id) {
        featuresPostAPI.getPostWithUserId(id);
    }
    @When("Send Request get post with user id")
    public void sendRequestGetPostWithUserId() {
        SerenityRest.when().get(featuresPostAPI.GET_POST_WITH_USERID);
    }
    @And("Response body userId should be {}")
    public void responseBodyUserIdShouldBe(String userId) {
        SerenityRest.and()
                .body(ResponseJsonHolder.USER_ID,equalTo(userId));
    }
    @Given("Get post with invalid user id {string}")
    public void getPostWithInvalidUserId(String invalid) {
        featuresPostAPI.getPostWithUserId(invalid);
    }
//POST
    @When("Send Request post with valid json")
    public void sendRequestPostWithValidJson() {
        SerenityRest.when().post(featuresPostAPI.POST_WITH_JSON);
    }

    @Given("Create post with valid json {string}")
    public void createPostWithValidJson(String jsonFile) {
        File json = new File(Constants.REQ_BODY+jsonFile);
        featuresPostAPI.postWithJson(json);
    }

    @Then("Status code should be {int} created")
    public void statusCodeShouldBeCreated(int created) {
        SerenityRest.then().statusCode(created);
    }

    @Given("Create post with invalid json {string}")
    public void createPostWithInvalidJson(String jsonFile) {
        File json = new File(Constants.REQ_BODY+jsonFile);
        featuresPostAPI.postWithJson(json);
    }

    @Then("Status code should be {int} bad request")
    public void statusCodeShouldBeBadRequest(int badRequest) {
        SerenityRest.then().statusCode(badRequest);
    }

    @And("Response body id should be {int}")
    public void responseBodyIdShouldBe(int id) {
        SerenityRest.and()
                .body(ResponseJsonHolder.ID_POST,equalTo(id));

    }
//PUT POST
    @Given("Put Post with valid id {int} and valid json {string}")
    public void putPostWithValidIdAndValidJson(int id, String jsonFile) {
        File json = new File(Constants.REQ_BODY+jsonFile);
        featuresPostAPI.putPost(json,id);
    }

    @When("Send Request put post")
    public void sendRequestPutPost() {
        SerenityRest.when().put(featuresPostAPI.PUT_POST);
    }
    @Given("Put Post with Exceed id {} and valid json {string}")
    public void putPostWithInvalidIdAndValidJson(String id, String jsonFile) {
        File json = new File(Constants.REQ_BODY+jsonFile);
        featuresPostAPI.putPost(json,id);
    }
//PATCH POST
    @Given("Patch post with valid json {string} and valid id {int}")
    public void patchPostWithValidJsonAndValidId(String jsonFile, int id) {
        File json = new File(Constants.REQ_BODY+jsonFile);
        featuresPostAPI.putPost(json,id);
    }

    @When("Send Request Patch Post")
    public void sendRequestPatchPost() {
        SerenityRest.when().patch(featuresPostAPI.PATCH_POST);
    }

    @Given("Patch post with invalid json {string} and valid id {int}")
    public void patchPostWithInvalidJson(String jsonFile,int id) {
        File json = new File(Constants.REQ_BODY+jsonFile);
        featuresPostAPI.putPost(json,id);
    }
//DELETE POST
    @Given("Delete a post with valid id {int}")
    public void deleteAPostWithValidId(int id) {
        featuresPostAPI.deletePost(id);
    }
    @When("Send Request delete post")
    public void sendRequestDeletePost() {
        SerenityRest.when().delete(featuresPostAPI.DELETE_POST);
    }
}

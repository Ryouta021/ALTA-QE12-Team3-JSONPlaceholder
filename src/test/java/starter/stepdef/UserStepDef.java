package starter.stepdef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.module.jsv.JsonSchemaValidator;
import net.serenitybdd.rest.SerenityRest;
import starter.resources.ResponseJsonHolder;
import net.thucydides.core.annotations.Steps;
import starter.resources.FeaturesUsersAPI;
import starter.utils.Constants;
import static org.hamcrest.Matchers.equalTo;
import java.io.File;

public class UserStepDef {

    @Steps
    FeaturesUsersAPI featuresUsersAPI;
    @Given("Get list user with valid parameter {string}")
    public void getListUserWithValidParameter(String param) {
        featuresUsersAPI.getListPost(param);
    }
    @When("Send Request get list user")
    public void sendRequestGetListUser() {
        SerenityRest.when().get(featuresUsersAPI.GET_LIST_USER);
    }

    @Then("Status code should be {int} ok")
    public void statusCodeShouldBeOk(int ok) {
        SerenityRest.then().statusCode(ok);
    }

    @Given("Get list post with invalid parameter {string}")
    public void getListPostWithInvalidParameter(String param) {
        featuresUsersAPI.getListPost(param);
    }

    @Then("Status code should be {int} not found")
    public void statusCodeShouldBeNotFound(int notFound) {
        SerenityRest.then().statusCode(notFound);
    }

    @Given("Get single post with valid id {int}")
    public void getSinglePostWithValidId(int id) {
        featuresUsersAPI.getSinglePost(id);
    }
    @When("Send Request get single post")
    public void sendRequestGetSinglePost() {
        SerenityRest.when().get(featuresUsersAPI.GET_SINGLE_USER);
    }
    @Given("Get single post with exceed id {int}")
    public void getSinglePostWithInvalidId(int id) {
        featuresUsersAPI.getSinglePost(id);
    }
    @Given("Get user with user id {}")
    public void getPostWithUserId(String id) {
        featuresUsersAPI.getPostWithUserId(id);
    }
    @When("Send Request get user with user id")
    public void sendRequestGetPostWithUserId() {
        SerenityRest.when().get(featuresUsersAPI.GET_USER_WITH_ID);
    }
    @Given("Get user with invalid user id {string}")
    public void getPostWithInvalidUserId(String id) {
        featuresUsersAPI.getPostWithUserId(id);
    }

    @Given("Create user with valid json {string}")
    public void createUserWithValidJson(String jsonFile) {
        File json = new File(Constants.REQ_BODY+jsonFile);
        featuresUsersAPI.postWithJson(json);
    }
    @When("Send Request user with valid json")
    public void sendRequestUserWithValidJson() {
        SerenityRest.when().post(featuresUsersAPI.POST_USER_WITH_JSON);
    }

    @Then("Status code should be {int} created")
    public void statusCodeShouldBeCreated(int created) {
        SerenityRest.then().statusCode(created);
    }

    @And("Response body id should be {int}")
    public void responseBodyIdShouldBe(int id) {
        SerenityRest.and()
                .body(ResponseJsonHolder.ID_POST_USER,equalTo(id));
    }

    @Given("Create user with invalid json {string}")
    public void createUserWithInvalidJson(String jsonFile) {
        File json = new File(Constants.REQ_BODY+jsonFile);
        featuresUsersAPI.postWithJson(json);
    }

    @Then("Status code should be {int} bad request")
    public void statusCodeShouldBeBadRequest(int badRequest) {
        SerenityRest.then().statusCode(badRequest);
    }

    @Given("Put User with valid id {int} and valid json {string}")
    public void putUserWithValidIdAndValidJson(int id, String jsonFile) {
        File json = new File(Constants.REQ_BODY+jsonFile);
        featuresUsersAPI.putPost(json,id);
    }

    @When("Send Request put User")
    public void sendRequestPutUser() {
        SerenityRest.when().put(featuresUsersAPI.PUT_USER);
    }

    @Given("Put User with valid id {int} and invalid json {string}")
    public void putUserWithValidIdAndInvalidJson(int id,String jsonFile) {
        File json = new File(Constants.REQ_BODY+jsonFile);
        featuresUsersAPI.putPost(json,id);
    }

    @Given("Patch User with valid json {string} and valid id {int}")
    public void patchUserWithValidJsonAndValidId(String jsonFile, int id) {
        File json = new File(Constants.REQ_BODY+jsonFile);
        featuresUsersAPI.putPost(json,id);
    }
    @When("Send Request Patch User")
    public void sendRequestPatchUser() {
        SerenityRest.when().patch(featuresUsersAPI.PATCH_USER);
    }
    @And("Validate update User JSON Schema {string}")
    public void validateUpdateUserJSONSchema(String jsonFile) {
        File json = new File(Constants.JSON_SCHEMA+jsonFile);
        SerenityRest.and()
                .assertThat()
                .body(JsonSchemaValidator.matchesJsonSchema(json));
    }

    @Given("Patch User with invalid json {string} and valid id {int}")
    public void patchUserWithInvalidJsonAndValidId(String jsonFile, int id) {
        File json = new File(Constants.REQ_BODY+jsonFile);
        featuresUsersAPI.putPost(json,id);
    }

    @Given("Delete a User with valid id {int}")
    public void deleteAUserWithValidId(int id) {
        featuresUsersAPI.deletePost(id);
    }
    @When("Send Request delete User")
    public void sendRequestDeleteUser() {
        SerenityRest.when().delete(featuresUsersAPI.DELETE_USER);
    }
}


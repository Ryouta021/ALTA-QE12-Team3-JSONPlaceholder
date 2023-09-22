package stepdef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.module.jsv.JsonSchemaValidator;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import org.apache.commons.lang3.function.FailableIntToLongFunction;
import starter.resources.FeaturesTodosAPI;
import starter.utils.Constants;

import javax.naming.directory.SearchResult;
import java.io.File;

public class TodosStepDef {
    @Steps
    FeaturesTodosAPI featuresTodosAPI;

    //Scenario get list
    @Given("Get list todos with valid id {int}")
    public void getListTodosWithValidId(int id){
        featuresTodosAPI.getListTodos(id);
    }

    @When("Send request get list todos")
    public void sendRequestGetListTodos() {
        SerenityRest.when().get(FeaturesTodosAPI.GET_LIST_TODOS);
    }

    @Then("Status code todos should be {int} OK")
    public void statusCodeTodosShouldBeOK(int ok) {
        SerenityRest.then().statusCode(ok);
    }

    //Scenario get invalid
    @Given("Get todos with invalid id {int}")
    public void getTodosWithInvalidId(int id) {
        featuresTodosAPI.getTodosInvalidId(id);
    }

    @When("Send request invalid todos")
    public void sendRequestInvalidTodos() {
        SerenityRest.when().get(FeaturesTodosAPI.GET_INVALID_TODOS);
    }

    @Then("Status invalid id code {int} Not Found")
    public void statusInvalidIdCodeNotFound(int NotFound) {
        SerenityRest.then().statusCode(NotFound);
    }

    //Scenario post create todos
    @Given("Create new todos with valid json {string}")
    public void createNewTodosWithValidJson(String jsonFile) {
        File json = new File(Constants.REQ_BODY + jsonFile);
        featuresTodosAPI.postCreateNewtodos(json);
    }

    @When("Send request post create todos")
    public void sendRequestPostCreateTodos() {
        SerenityRest.when().post(FeaturesTodosAPI.POST_CREATE_TODOS);
    }

    @Then("Status code post create todos should be {int} Created")
    public void statusCodePostCreateTodosShouldBeCreated(int created) {
        SerenityRest.then().statusCode(created);
    }

    //Scenario invalid todos
    @Given("Create new todos with invalid json {string}")
    public void createNewTodosWithInvalidJson(String jsonFile) {
        File json = new File(Constants.REQ_BODY + jsonFile);
        featuresTodosAPI.postInvalidTodos(json);
    }

    @When("Send request post create todos invalid")
    public void sendRequestPostCreateTodosInvalid() {
        SerenityRest.when().post(FeaturesTodosAPI.POST_INVALID_TODOS);
    }

    @Then("Status code post invalid todos should be {int} Not Found")
    public void statusCodePostInvalidTodosShouldBeNotFound(int NotFound) {
        SerenityRest.then().statusCode(NotFound);
    }

    //Scenario put update
    @Given("Put update todos with valid json {string} and id {}")
    public void putUpdateTodosWithValidJsonAndId(String jsonFile, int id) {
        File json = new File(Constants.REQ_BODY + jsonFile);
        featuresTodosAPI.putUpdateTodos(json, id);
    }

    @When("Send request put update todos")
    public void sendRequestPutUpdateTodos() {
        SerenityRest.when().put(FeaturesTodosAPI.PUT_UPDATE_TODOS);
    }

    @Then("Status code put update todos should be {int} OK")
    public void statusCodePutUpdateTodosShouldBeOK(int ok) {
        SerenityRest.then().statusCode(ok);
    }

    @And("Validate put update todos JSON schema {string}")
    public void validatePutUpdateTodosJSONSchema(String jsonFile) {
        File json = new File(Constants.JSON_SCHEMA+jsonFile);
        SerenityRest.and()
                .assertThat()
                .body(JsonSchemaValidator.matchesJsonSchema(json));
    }

    //Scenario put invalid
    @Given("Put update todos with invalid json {string} and id {}")
    public void putUpdateTodosWithInvalidJsonAndId(String jsonFile, int id) {
        File json = new File(Constants.REQ_BODY + jsonFile);
        featuresTodosAPI.putInvalidTodos(json, id);
    }

    @When("Send request put invalid todos")
    public void sendRequestPutInvalidTodos() {
        SerenityRest.when().put(FeaturesTodosAPI.PUT_INVALID_TODOS);
    }

    @Then("Status code put invalid todos should be {int} Not Found")
    public void statusCodePutInvalidTodosShouldBeNotFound(int NotFound) {
        SerenityRest.then().statusCode(NotFound);
    }

    //Scenario patch update
    @Given("Patch update todos with valid json {string} and user id {}")
    public void patchUpdateTodosWithValidJsonAndUserId(String jsonFile, int id) {
        File json = new File(Constants.REQ_BODY + jsonFile);
        featuresTodosAPI.patchInvalidTodos(json, id);
    }

    @When("Send request patch update todos")
    public void sendRequestPatchUpdateTodos() {
        SerenityRest.when().patch(FeaturesTodosAPI.PATCH_UPDATE_TODOS);
    }


    @Then("Status code patch update todos {int} OK")
    public void statusCodePatchUpdateTodosOK(int ok) {
        SerenityRest.then().statusCode(ok);
    }

    @And("Validate patch update todos JSON Schema {string}")
    public void validatePatchUpdateTodosJSONSchema(String jsonFile) {
        File json = new File(Constants.JSON_SCHEMA + jsonFile);
        SerenityRest.and()
                .assertThat()
                .body(JsonSchemaValidator.matchesJsonSchema(json));
    }

    @Given("Patch update todos with invalid json {string} and user id {}")
    public void patchUpdateTodosWithInvalidJsonAndUserId(String jsonFile, int id) {
        File json = new File(Constants.REQ_BODY + jsonFile);
        featuresTodosAPI.patchInvalidTodos(json, id);
    }

    @When("Send request patch invalid todos")
    public void sendRequestPatchInvalidTodos() {
        SerenityRest.when().patch(FeaturesTodosAPI.PATCH_INVALID_TODOS);
    }

    @Then("Status code patch invalid todos {int} Not Found")
    public void statusCodePatchInvalidTodosBadRequest(int NotFound) {
        SerenityRest.then().statusCode(NotFound);
    }

    //Scenario delete
    @Given("Delete a todos with valid id {}")
    public void deleteATodosWithValidId(int id) {
        featuresTodosAPI.deleteATodos(id);
    }

    @When("Send request delete todos")
    public void sendRequestDeleteTodos() {
        SerenityRest.when().delete(FeaturesTodosAPI.DELETE_TODOS);
    }

    @Then("Status code delete todos should be {int} OK")
    public void statusCodeDeleteTodosShouldBeOK(int ok) {
        SerenityRest.then().statusCode(ok);
    }

    //Scenario delete invalid
    @Given("Delete a todos with invalid id {}")
    public void deleteATodosWithInvalidId(int id) {
        featuresTodosAPI.deleteInvalidTodos(id);
    }

    @When("Send request invalid delete todos")
    public void sendRequestInvalidDeleteTodos() {
        SerenityRest.when().delete(FeaturesTodosAPI.DELETE_INVALID_TODOS);
    }

    @Then("Status code invalid delete todos should be {int} Not Found")
    public void statusCodeInvalidDeleteTodosShouldBeNotFound(int NotFound) {
        SerenityRest.then().statusCode(NotFound);
    }
}

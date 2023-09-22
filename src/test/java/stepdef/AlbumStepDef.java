package stepdef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.module.jsv.JsonSchemaValidator;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import starter.resources.FeaturesAlbumsAPI;
import starter.utils.Constants;

import java.io.File;

public class AlbumStepDef {

    @Steps
    FeaturesAlbumsAPI featuresAlbumsAPI;

    // Scenario get list
    @Given("Get list album with valid parameter page {int}")
    public void getListAlbumWithValidParameterPage(int page) {
        featuresAlbumsAPI.getListAlbum(page);
    }

    @When("Send request get list albums")
    public void sendRequestGetListAlbums() {
        SerenityRest.when().get(FeaturesAlbumsAPI.GET_LIST_ALBUM);
    }

    @Then("Status code should be {int} OK")
    public void statusCodeShouldBeOK(int ok) {
        SerenityRest.then().statusCode(ok);
    }


    //Scenario get single album
    @Given("Get single album with valid id {int}")
    public void getSingleAlbumWithValidId(int id) {
        featuresAlbumsAPI.getSingleAlbum(id);
    }

    @When("Send get sigle album request")
    public void sendGetSigleAlbumRequest() {
        SerenityRest.when().get(FeaturesAlbumsAPI.GET_SINGLE_ALBUM);
    }

    @Then("Status single album should be {int} OK")
    public void statusSingleAlbumShouldBeOK(int ok) {
        SerenityRest.then().statusCode(ok);
    }

    //Scenario get invalid user id
    @Given("Get album with invalid user id {}")
    public void getAlbumWithInvalidUserId(int id) {
        featuresAlbumsAPI.getAlbumInvalidUser(id);
    }
    @When("Send request get single user")
    public void sendRequestGetSingleUser() {
        SerenityRest.when().get(FeaturesAlbumsAPI.GET_ALBUM);
    }

    @Then("Status code get single user invalid {int} Not Found")
    public void statusCodeGetSingleUserInvalidNotFound(int NotFound) {
        SerenityRest.then().statusCode(NotFound);
    }


    //Scenario get invalid id
    @Given("Get single album with invalid id {}")
    public void getSingleAlbumWithInvalidId(int id) {
        featuresAlbumsAPI.getSingleAlbumInvalidId(id);
    }

    @When("Send request invalid")
    public void sendRequestInvalid() {
        SerenityRest.when().get(FeaturesAlbumsAPI.GET_SINGLE_ALBUM_INVALID_ID);
    }

    @Then("Status single invalid id code {int} Not Found")
    public void statusSingleInvalidIdCodeNotFound(int NotFound) {
        SerenityRest.then().statusCode(NotFound);
    }


    //Scenarion post create album
    @Given("Create new album with valid json {string}")
    public void createNewAlbumWithValidJson(String jsonFile) {
        File json = new File(Constants.REQ_BODY + jsonFile);
        featuresAlbumsAPI.postCreateNewAlbum(json);
    }

    @When("Send request post create album")
    public void sendRequestPostCreateAlbum() {
        SerenityRest.when().post(FeaturesAlbumsAPI.POST_CREATE_ALBUM);
    }
    @Then("Status code post create album should be {int} Created")
    public void statusCodePostCreateAlbumShouldBeCreated(int created) {
        SerenityRest.then().statusCode(created);
    }


    //Scenario post invalid album
    @Given("Create new album with invalid json {string}")
    public void createNewAlbumWithInvalidJson(String jsonFile) {
        File json = new File(Constants.REQ_BODY + jsonFile);
        featuresAlbumsAPI.postCreateNewAlbum(json);
    }

    @When("Send request post create album invalid")
    public void sendRequestPostCreateAlbumInvalid() {
        SerenityRest.when().post(FeaturesAlbumsAPI.POST_INVALID_ALBUM);
    }

    @Then("Status code post create album should be {int} Not Found")
    public void statusCodePostCreateAlbumShouldBeNotFound(int NotFound) {
        SerenityRest.then().statusCode(NotFound);
    }

    //Scenario put update album
    @Given("Put update album with valid json {string} and id {}")
    public void putUpdateAlbumWithValidJsonAndId(String jsonFile, int id) {
        File json = new File(Constants.REQ_BODY + jsonFile);
        featuresAlbumsAPI.putUpdateAlbum(json, id);
    }

    @When("Send request put update album")
    public void sendRequestPutUpdateAlbum() {
        SerenityRest.when().put(FeaturesAlbumsAPI.PUT_UPDATE_ALBUM);
    }

    @Then("Status code put update should be {int} OK")
    public void statusCodePutUpdateShouldBeOK(int ok) {
        SerenityRest.then().statusCode(ok);
    }

    @And("Validate put update album JSON schema {string}")
    public void validatePutUpdateAlbumJSONSchema(String jsonFile){
        File json = new File(Constants.JSON_SCHEMA+jsonFile);
        SerenityRest.and()
                .assertThat()
                .body(JsonSchemaValidator.matchesJsonSchema(json));
    }


    //Scenario put invalid json
    @Given("Put update album with invalid json {string} and id {}")
    public void putUpdateAlbumWithInvalidJsonAndId(String jsonFile, int id) {
        File json = new File(Constants.REQ_BODY + jsonFile);
        featuresAlbumsAPI.putInvalidAlbum(json, id);
    }

    @When("Send request put invalid album")
    public void sendRequestPutInvalidAlbum() {
        SerenityRest.when().put(FeaturesAlbumsAPI.PUT_INVALID);
    }

    @Then("Status code put invalid should be {int} Not Found")
    public void statusCodePutInvalidShouldBeNotFound(int NotFound) {
        SerenityRest.then().statusCode(NotFound);
    }

    //Scenario patch update album
    @Given("Patch update album with valid json {string} and user id {}")
    public void patchUpdateAlbumWithValidJsonAndUserId(String jsonFile, int id) {
        File json = new File(Constants.REQ_BODY + jsonFile);
        featuresAlbumsAPI.patchUpdateAlbum(json, id);
    }

    @When("Send request patch update album")
    public void sendRequestPatchUpdateAlbum() {
        SerenityRest.when().patch(FeaturesAlbumsAPI.PATCH_UPDATE_ALBUM);
    }

    @Then("Status code patch update album {int} OK")
    public void statusCodePatchUpdateAlbumOK(int ok) {
        SerenityRest.then().statusCode(ok);
    }
    @And("Validate patch update album JSON Schema {string}")
    public void validatePatchUpdateAlbumJSONSchema(String jsonFile) {
        File json = new File(Constants.JSON_SCHEMA + jsonFile);
        SerenityRest.and()
                .assertThat()
                .body(JsonSchemaValidator.matchesJsonSchema(json));
    }

    //Scenario patch invalid
    @Given("Patch update album with invalid json {string} and user id {int}")
    public void patchUpdateAlbumWithInvalidJsonAndUserId(String jsonFile, int id) {
        File json = new File(Constants.REQ_BODY + jsonFile);
        featuresAlbumsAPI.patchInvalidAlbum(json, id);
    }

    @When("Send request patch invalid album")
    public void sendRequestPatchInvalidAlbum() {
        SerenityRest.when().patch(FeaturesAlbumsAPI.PATCH_INVALID);
    }

    @Then("Status code patch invalid album {int} Bad Request")
    public void statusCodePatchInvalidAlbumBadRequest(int BadRequest) {
        SerenityRest.then().statusCode(BadRequest);
    }

    //Scenario delete
    @When("Send request delete album")
    public void sendRequestDeleteAlbum() {

        SerenityRest.when().delete(FeaturesAlbumsAPI.DELETE_ALBUM);
    }

    @Then("Status code should be {int} ok")
    public void statusCodeShouldBeNoContent(int ok) {
        SerenityRest.then().statusCode(ok);
    }

    @Given("Delete a album with valid id {}")
    public void deleteAAlbumWithValidId(int id) {
        featuresAlbumsAPI.deleteAlbum(id);
    }


}

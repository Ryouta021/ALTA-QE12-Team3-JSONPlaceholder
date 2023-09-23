Feature: resources user in JSONPlaceholder

  @GETLISTUSER
    #  POSITIVE
  Scenario: Get list user with valid parameter
    Given Get list user with valid parameter "users"
    When Send Request get list user
    Then Status code should be 200 ok
#NEGATIVE
  Scenario: Get list user with invalid parameter
    Given Get list post with invalid parameter "user"
    When Send Request get list user
    Then Status code should be 404 not found

  @GETSINGLEUSER
    #  POSITIVE
  Scenario: Get single user with valid parameter
    Given Get single post with valid id 1
    When Send Request get single post
    Then Status code should be 200 ok
#NEGATIVE
  Scenario: Get single user with exceed parameter
    Given Get single post with exceed id 20000
    When Send Request get single post
    Then Status code should be 404 not found

  @GETUSERWITHID
#  POSITIVE
  Scenario Outline: Get user with valid user id
    Given Get user with user id <id>
    When Send Request get user with user id
    Then Status code should be 200 ok
    Examples:
      | id |
      | 1  |
#NEGATIVE
  Scenario: Get user with invalid user id
    Given Get user with invalid user id "aa"
    When Send Request get user with user id
    Then Status code should be 404 not found
#POSITIVE
  @POSTUSERJSON
  Scenario: Create user with valid json
    Given Create user with valid json "postUserValid.json"
    When Send Request user with valid json
    Then Status code should be 201 created
    And Response body id should be 11

#NEGATIVE
  Scenario: Create user with invalid json
    Given Create user with invalid json "postUserInvalid.json"
    When Send Request user with valid json
    Then Status code should be 400 bad request

  @PUTUSER
#  POSITIVE
  Scenario Outline: Put User with valid id and valid json
    Given Put User with valid id <id> and valid json "<json>"
    When Send Request put User
    Then Status code should be 200 ok
    And Response body id should be <kode>
    Examples:
      | id | json          | kode |
      | 1  | putValidUser.json | 1    |
#NEGATIVE
  Scenario Outline: Put User with valid id and invalid json
    Given Put User with valid id <idv> and invalid json "<json1>"
    When Send Request put User
    Then Status code should be 404 not found
    Examples:
      | json1               | idv |
      | putInvalidUser.json | 1   |
  @PATCHUSER
#  POSITIVE
  Scenario: Patch User with valid json
    Given Patch User with valid json "patchValidUser.json" and valid id 1
    When Send Request Patch User
    Then Status code should be 200 ok
    And Validate update User JSON Schema "UserPatchJsonSchema.json"
#  NEGATIVE
  Scenario: Patch User with invalid json
    Given Patch User with invalid json "patchInvalidUser.json" and valid id 1
    When Send Request Patch User
    Then Status code should be 400 bad request
  @DELETEUSER
  Scenario Outline: Delete User with valid id
    Given Delete a User with valid id <iduser>
    When Send Request delete User
    Then Status code should be 200 ok
    Examples:
      | iduser |
      | 1     |
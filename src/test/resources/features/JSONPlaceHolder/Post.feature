Feature: resources post in JSONPlaceholder

  @GETLISTUSER
    #  POSITIVE
  Scenario: Get list post with valid parameter
    Given Get list post with valid parameter "posts"
    When Send Request get list post
    Then Status code should be 200 ok
#NEGATIVE
  Scenario: Get list post with invalid parameter
   Given Get list post with invalid parameter "pos"
   When Send Request get list post
   Then Status code should be 404 not found

  @GETSINGLEUSER
    #  POSITIVE
  Scenario: Get single user with valid parameter
    Given Get single post with valid id 1
    When Send Request get single post
    Then Status code should be 200 ok
#NEGATIVE
  Scenario: Get single user with invalid parameter
    Given Get single post with invalid id 20000
    When Send Request get single post
    Then Status code should be 404 not found

  @GETPSOTUSERID
#  POSITIVE
  Scenario Outline: Get post with valid user id
  Given Get post with user id <id>
  When Send Request get post with user id
  Then Status code should be 200 ok
    #  And Response body userId should be "1, 1, 1, 1, 1, 1, 1, 1, 1, 1"
    Examples:
      | id |
      | 1  |
#NEGATIVE
  Scenario: Get post with invalid user id
    Given Get post with invalid user id "aa"
    When Send Request get post with user id
    Then Status code should be 404 not found
#POSITIVE
  @POSTJSON
  Scenario: Get post with valid json
    Given Create post with valid json "postPost.json"
    When Send Request post with valid json
    Then Status code should be 201 created
    And Response body id should be 101

#NEGATIVE
  Scenario: Get post with invalid json
    Given Create post with invalid json "postInvalidPost.json"
    When Send Request post with valid json
    Then Status code should be 400 bad request

@PUTPOST
#  POSITIVE
Scenario Outline: Put Post with valid id and valid json
  Given Put Post with valid id <id> and valid json "<json>"
  When Send Request put post
  Then Status code should be 200 ok
  And Response body id should be <kode>
  Examples:
    | id | json              | kode |
    | 1  | putValidPost.json | 1    |
#NEGATIVE
Scenario Outline: Put Post with empty id and valid json
  Given Put Post with Exceed id "<invalidId>" and valid json "<json1>"
  When Send Request put post
  Then Status code should be 404 not found
  Examples:
    | invalidId | json1             |
    | 50000     | putValidPost.json |
  @PATCHPOST
#  POSITIVE
  Scenario: Patch Post with valid json
  Given Patch post with valid json "patchValidPost.json" and valid id 1
  When Send Request Patch Post
  Then Status code should be 200 ok
  And Response body userId should be 1
#  NEGATIVE
  Scenario: Patch post with invalid json
    Given Patch post with invalid json "patchInvalidPost.json" and valid id 1
    When Send Request Patch Post
    Then Status code should be 400 bad request
@DELETEPOST
Scenario Outline: Delete Post with valid id
  Given Delete a post with valid id <iddel>
  When Send Request delete post
  Then Status code should be 200 ok
  Examples:
    | iddel |
    | 1     |
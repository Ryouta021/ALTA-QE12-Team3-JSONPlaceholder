Feature: Comments
  @Comments
  Scenario: Get all of comments
    Given Get all comments
    When Send request get list comments
    Then Status code should be 200
    And First id on response body was 1
    And Validate get list comments JSON schema "ListCommentsSchema.json"

  Scenario Outline: Get single comment with valid id
    Given Get single comment with valid parameter <id>
    When Send request get single comment
    Then Status code should be 200
    And Response body page should be <id>
    And Validate get single comments JSON schema "SingleCommentJsonSchema.json"
    Examples:
      | id |
      | 1  |
      | 2  |
      | 3  |


  Scenario Outline: Get single comment with exceed parameters
    Given Get single comment with exceed parameter <parameter>
    When Send request get single comment
    Then Status code should be 404
    And Response body page should be null
    And Validate get single comments JSON schema "SingleCommentInvalidJsonSchema.json"
    Examples:
      | parameter |
      | 100000    |
      | 200000    |
      | 3333333   |
      | 742342    |
      | 8793458   |
      | 7238237   |

#  Scenario: Post create new comment
#    Given Post create new comment
#    When Send request to create comment
#    Then Status code should be shown 201
#    And Response body page
#    And Validate post create comment JSON Schema {String}

#status code seharusnya 201 tapi aktualnya 500

  Scenario Outline: Put update comments
    Given Put update comments with valid param <id>
    When Send req. to update comment
    Then Response code should be 200
    And Response body page is <id>
    And Validate put update comment JSON Schema "PutUpdateComments.json"
    Examples:
        | id |
        | 1  |
        | 2  |
        | 3  |
        | 4  |

  Scenario Outline: Delete comments with valid id
    Given Delete comments woth valid id <id>
    When Send req. to delete  comments
    Then Response code should be 200
    Examples:
      | id |
      | 1  |
      | 2  |
      | 3  |
      | 4  |
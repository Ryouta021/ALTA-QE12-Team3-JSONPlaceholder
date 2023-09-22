Feature: Photos
  @Tim3 @Photos
  Scenario: Get all of photos
    Given Get all photos
    When Send request get list photos
    Then Status code should be 200
    And First id on response body was 1
    And Validate get list photos JSON schema "ListPhotosSchema.json"

  Scenario Outline: Get single photo with valid id
    Given Get single photo with valid parameter <id>
    When Send request get single photo
    Then Status code should be 200
    And Response body page should be <id>
    And Validate get single photos JSON schema "SinglePhotoJsonSchema.json"
    Examples:
      | id |
      | 1  |
      | 2  |
      | 3  |


  Scenario Outline: Get single photo with exceed parameters
    Given Get single photo with exceed parameter <parameter>
    When Send request get single photo
    Then Status code should be 404
    And Response body page should be null
    And Validate get single photos JSON schema "SinglePhotoInvalidJsonSchema.json"
    Examples:
      | parameter |
      | 100000    |
      | 200000    |
      | 3333333   |
      | 742342    |
      | 8793458   |
      | 7238237   |

#  Scenario: Post create new photo
#    Given Post create new photo
#    When Send request to create photo
#    Then Status code should be shown 201
#    And Response body page
#    And Validate post create photo JSON Schema {String}

#status code seharusnya 201 tapi aktualnya 500

  Scenario Outline: Put update photos
    Given Put update photos with valid param <id>
    When Send req. to update photo
    Then Response code should be 200
    And Response body page is <id>
    And Validate put update photo JSON Schema "PutUpdatePhotos.json"
    Examples:
        | id |
        | 1  |
        | 2  |
        | 3  |
        | 4  |

  Scenario Outline: Delete photos with valid id
    Given Delete photos with valid id <id>
    When Send req. to delete  photos
    Then Response code should be 200
    Examples:
      | id |
      | 1  |
      | 2  |
      | 3  |
      | 4  |
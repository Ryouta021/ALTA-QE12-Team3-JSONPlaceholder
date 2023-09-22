Feature: ALTA QE TEAM 3 JSONPLACEHOLDER

  #positif
  Scenario Outline: Get list albums with valid parameter page
    Given Get list album with valid parameter page <page>
    When Send request get list albums
    Then Status code should be 200 OK
    Examples:
      | page |
      | 1    |

#positif
  Scenario Outline: Get single album with valid id
    Given Get single album with valid id <id>
    When Send get sigle album request
    Then  Status single album should be 200 OK
    Examples:
      | id |
      | 2  |

  #negative
   Scenario Outline: Get album with invalid user id
     Given Get album with invalid user id <id>
     When Send request get single user
     Then Status code get single user invalid 404 Not Found
     Examples:
       | id |
       | 100000 |

  #negatif
   Scenario Outline: Get single album with invalid id
     Given Get single album with invalid id <id>
     When Send request invalid
     Then Status single invalid id code 404 Not Found
     Examples:
       | id    |
       | 29999 |

   #positif
   Scenario: Post create new album with valid json
     Given Create new album with valid json "Album.json"
     When Send request post create album
     Then Status code post create album should be 201 Created


   #negative
   Scenario: Post create new album with invalid json
     Given Create new album with invalid json "InvalidAlbum.json"
     When Send request post create album invalid
     Then Status code post create album should be 404 Not Found

   #positif
   Scenario Outline: Put update album with valid json and id
     Given Put update album with valid json "<jsonFile>" and id <id>
     When Send request put update album
     Then Status code put update should be 200 OK
     And Validate put update album JSON schema "PutUpdateAlbum.json"
     Examples:
       | id | jsonFile           |
       | 49 | PutValidAlbum.json |

   #negative
  Scenario Outline: Put update album with invalid json and id
    Given Put update album with invalid json "<jsonFile>" and id <id>
    When Send request put invalid album
    Then Status code put invalid should be 404 Not Found
    Examples:
      | id | jsonFile          |
      | 1  | InvalidAlbum.json |

  #positif
  Scenario Outline: Patch update album with valid json and user id
    Given Patch update album with valid json "PatchUpdateAlbum.json" and user id <id>
    When Send request patch update album
    Then Status code patch update album 200 OK
    And Validate patch update album JSON Schema "PatchUpdateAlbum.json"
    Examples:
      | id |
      | 16 |

  #negative
  Scenario Outline: Patch update album with invalid json and user id
    Given Patch update album with invalid json "PatchInvalid.json" and user id <id>
    When Send request patch invalid album
    Then Status code patch invalid album 400 Bad Request
    Examples:
      | id |
      | 21  |

  #positif
  Scenario Outline: Delete a album with valid id
    Given Delete a album with valid id <id>
    When Send request delete album
    Then Status code should be 200 OK
    Examples:
      | id |
      | 2  |

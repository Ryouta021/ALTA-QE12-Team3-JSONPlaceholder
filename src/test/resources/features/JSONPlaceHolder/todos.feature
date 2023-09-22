Feature: ALTA QE TEAM 3 JSONPLACEHOLDER

  #positif
  Scenario Outline: Get list todos with valid id
    Given Get list todos with valid id <id>
    When Send request get list todos
    Then Status code todos should be 200 OK
    Examples:
      | id |
      | 1 |

  #negatif
  Scenario Outline: Get todos with invalid id
    Given Get todos with invalid id <id>
    When Send request invalid todos
    Then Status invalid id code 404 Not Found
    Examples:
      | id    |
      | 29999 |

   #positif
  Scenario: Post create new todos with valid json
    Given Create new todos with valid json "Todos.json"
    When Send request post create todos
    Then Status code post create todos should be 201 Created


   #negative
  Scenario: Post create new todos with invalid json
    Given Create new todos with invalid json "InvalidTodos.json"
    When Send request post create todos invalid
    Then Status code post invalid todos should be 404 Not Found


   #positif
  Scenario Outline: Put update todos with valid json and id
    Given Put update todos with valid json "<jsonFile>" and id <id>
    When Send request put update todos
    Then Status code put update todos should be 200 OK
    And Validate put update todos JSON schema "PutUpdateTodos.json"
    Examples:
      | id | jsonFile      |
      | 22 | PutTodos.json |

   #negative
  Scenario Outline: Put update todos with invalid json and id
    Given Put update todos with invalid json "<jsonFile>" and id <id>
    When Send request put invalid todos
    Then Status code put invalid todos should be 404 Not Found
    Examples:
      | id    | jsonFile             |
      | 40999 | PutInvalidTodos.json |

  #positif
  Scenario Outline: Patch update todos with valid json and user id
    Given Patch update todos with valid json "PatchUpdateTodos.json" and user id <id>
    When Send request patch update todos
    Then Status code patch update todos 200 OK
    And Validate patch update todos JSON Schema "PatchUpdateTodos.json"
    Examples:
      | id |
      | 16 |

  #negative
  Scenario Outline: Patch update todos with invalid json and user id
    Given Patch update todos with invalid json "PatchInvalidTodos.json" and user id <id>
    When Send request patch invalid todos
    Then Status code patch invalid todos 404 Not Found
    Examples:
      | id |
      | 42 |

  #positif
  Scenario Outline: Delete a todos with valid id
    Given Delete a todos with valid id <id>
    When Send request delete todos
    Then Status code delete todos should be 200 OK
    Examples:
      | id |
      | 2  |

  #negative
  Scenario Outline: Delete a todos with invalid id
    Given Delete a todos with invalid id <id>
    When Send request invalid delete todos
    Then Status code invalid delete todos should be 404 Not Found
    Examples:
      | id |
      | 2  |

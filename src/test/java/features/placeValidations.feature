Feature: Validating place API's

  Scenario Outline: Verify if place is being successfully added using AddPlaceAPI
    Given add place payload with "<name>" "<language>" "<address>"
    When user calls "ADDPLACEAPI" with "POST" http request
    Then the API call is success with status code 200
    And "status" in response body is "OK"
    And "scope" in response body is "APP"
#    And verify place_id created maps to "<name>" using "GETPLACEAPI"

    Examples:
      | name | language   | address         |
      | Anne | portuguese | Bernardo Reiter |
#      | Dudu | germany    | Oktoberfest     |


  Scenario: Verify if delete place functionality is working
    Given deleteplace payload
    When user calls "DELETEPLACEAPI" with "POST" http request
    Then the API call is success with status code 200
    And "status" in response body is "OK"


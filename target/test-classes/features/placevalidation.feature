Feature:  Validating Place API


Scenario Outline: Verify if Place is being succesfully added using AddPlaceAPI

Given     Add Place Payload with "<name>" "<language>" "<address>"
When      User calls "AddPlaceAPI" with "POST" HTTP request
Then      API call got success with status code 200
And      "scope" in response body is "APP"


Examples: 
  
       | name    | language | address |
       | Rework  | English  | India   |
       | Mindset | English  | India   |   
       
       
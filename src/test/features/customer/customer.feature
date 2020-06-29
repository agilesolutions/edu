Feature: Managing customers

   @basis
   Scenario Outline: Retrieve customer age by identifier
        When I search customer age by identifier <id>
        Then the customer age is found
        And its age is '<age>'
        
   Examples:
   
    | id             | age                      |
    | 9              | 22                         |
    | 8              | 21                         |
    | 3 		     | 23                         |
   
   @critical 
   Scenario Outline: Retrieve customer gender by identifier
        When I search customer gender by id <id>
        Then the customer gender is found
        And its gender is <gender>
        
   Examples:
   
    | id             | gender |
    | 9              | 77577  |
    | 8              | 79521  |
    | 3 		     | 54662  |     